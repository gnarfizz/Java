package DrinkCart;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Class for the checkout gui
 * Class has-a relationship with Cart class
 * Class is-a GUI
 * Lead Author: Anver Chou; 0005756587
 *
 * References:
 * Morelli, R., & Walde, R. (2016).
 * Java, Java, Java: Object-Oriented Problem Solving
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-
 * java-object-oriented-problem-solving
 * <<Add more references here>>
 *
 * Version: May 27, 2023
 */

/**
 * CheckoutGUI is a custom JPanel for managing the order process, including
 * selection, removal of items, and checkout.
 * It includes a variety of Swing components for user interaction.
 */
class CheckoutGUI extends JPanel
{

	// Components and data
	private Cart cart; // Holds the cart
	private JComboBox<Drink> drinkComboBox; // Allows user to select a drink
	private JComboBox<String> sizeComboBox; // Allows user to select a size
	private JComboBox<String> temperatureComboBox; // Allows user to select a
													// temperature
	private JList<String> cartList; // Displays the current items in the cart
	private DefaultListModel<String> cartListModel; // Model for the CartList
	private JButton addButton; // Button to add an item to the cart
	private JButton removeButton; // Button to remove an item from the cart
	private JButton checkoutButton; // Button to checkout items
	private JLabel totalLabel; // Label to display the total cost of drinks

	/**
	 * Constructor for the CheckoutGUI class.
	 * Initializes the various components and layouts, and sets up event
	 * handlers.
	 *
	 * @param cart The cart that this CheckoutGUI will modify
	 */
	public CheckoutGUI(Cart cart)
	{
		this.cart = cart; // Initializes the cart
		setLayout(new BorderLayout()); // Sets layout to BorderLayout

		// Define the available drinks
		Drink[] drinks = { new Drink("Tea", 2.00, true),
				new Drink("Smoothie", 4.00, false),
				new Drink("Coffee", 3.00, true), };

		// Initialize GUI Components
		// ComboxBox for selecting a drink
		drinkComboBox = new JComboBox<>(drinks);
		// ComboBox for selecting size
		sizeComboBox = new JComboBox<>(new String[] { "S", "M", "L" });
		// ComboBox for selecting temperature
		temperatureComboBox = new JComboBox<>(new String[] { "Hot", "Iced" });
		// ListModel for JList
		cartListModel = new DefaultListModel<>();
		// JLiSt for displaying cart items
		cartList = new JList<>(cartListModel);
		// Button for adding items
		addButton = new JButton("Add");
		// Button for removing items
		removeButton = new JButton("Remove");
		// Button for Checking out
		checkoutButton = new JButton("Checkout");
		// Label for displaying total
		totalLabel = new JLabel("Total: $0");
		// Top panel for drink, size, and temperature selection
		// Sets layout to GridLayout
		JPanel topPanel = new JPanel(new GridLayout(3, 2));
		topPanel.add(new JLabel("Drink: "));
		topPanel.add(drinkComboBox);
		topPanel.add(new JLabel("Size: "));
		topPanel.add(sizeComboBox);
		topPanel.add(new JLabel("Temperature: "));
		topPanel.add(temperatureComboBox);
		// Adds top panel to north of BorderLayout
		add(topPanel, BorderLayout.NORTH);

		// Add JScrollPane to holds cartList to the center of BorderLayout
		JScrollPane cartListScrollPane = new JScrollPane(cartList);
		// Button panel for add, remove, and checkout buttons
		add(cartListScrollPane, BorderLayout.CENTER);
		// Buttons to button panel
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
		buttonPanel.add(addButton);
		buttonPanel.add(removeButton);
		buttonPanel.add(checkoutButton);
		add(buttonPanel, BorderLayout.EAST);
		// Add totalLabel to the south of the BorderLayout
		add(totalLabel, BorderLayout.SOUTH);
		// Add action listeners to buttons
		addButton.addActionListener(new AddButtonListener());
		removeButton.addActionListener(new RemoveButtonListener());
		checkoutButton.addActionListener(new CheckoutButtonListener());
	}

	/**
	 * Updates the totalLabel to display the current total price of the items in
	 * the cart.
	 */
	public void updateTotalLabel()
	{
		// Sets the text of the totalLabel to the current total of the Cart
		totalLabel.setText("Total: $" + cart.getTotal());
	}

	/**
	 * Private inner class that defines the action when the "Add" button is
	 * clicked.
	 */
	private class AddButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Gets the selected drink, size, and temperature from the combo
			// boxes
			Drink selectedDrink = (Drink) drinkComboBox.getSelectedItem();
			String selectedSize = (String) sizeComboBox.getSelectedItem();
			String selectedTemperature = (String) temperatureComboBox
					.getSelectedItem();
			// If the selected drink is a smoothie, set the temperature to Iced
			if (selectedDrink.getName().equalsIgnoreCase("Smoothie"))
			{
				selectedTemperature = "Iced";
			}

			// Create a new OrderItem with2 the selected options
			OrderItem newItem = new OrderItem(selectedDrink, selectedSize,
					selectedTemperature);
			// Add the new item to the cart
			cart.addItem(newItem);
			// Adds the new item to the cartListModel, updates the CartList
			cartListModel.addElement(
					newItem.getSize() + " " + newItem.getTemperature() + " "
							+ newItem.getDrink().getName() + " - $"
							+ newItem.getPrice());
			// Update the totalLabel to reflect the new total
			updateTotalLabel();
		}
	}

	/**
	 * Private inner class that defines the action when the "Remove" button is
	 * clicked.
	 */
	private class RemoveButtonListener implements ActionListener
	{
		/**
		 * Defines what happens when the "Remove" button is clicked.
		 */
		public void actionPerformed(ActionEvent e)
		{
			// Get the index of the selected item in the cartList
			int selectedIndex = cartList.getSelectedIndex();
			// If an item is selected, remove it from the cart and the
			// cartListModel
			if (selectedIndex != -1)
			{
				cart.removeItem(selectedIndex);
				cartListModel.remove(selectedIndex);
				updateTotalLabel();
			}
		}
	}

	/**
	 * Method to save the current state of the cart to a file.
	 *
	 * @param cart The cart to save
	 */
	private class CheckoutButtonListener implements ActionListener
	{
		/**
		 * Defines what happens when the "Checkout" button is clicked.
		 */
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Save the current state of the cart to a file
			saveCartToFile(cart);
			// Reset the cart and cartListModel, update the totalLabel
			cart = new Cart();
			cartListModel.clear();
			updateTotalLabel();
			// Display a message to the user for their purchase
			JOptionPane.showMessageDialog(null, "Thank you for your purchase!");
		}

		private void saveCartToFile(Cart cart)
		{
			try
			{
				// try to write the cart's contents to a file
				File file = new File("cart.txt");
				FileWriter writer = new FileWriter(file);
				// For each item in the cart, write the drink's size,
				// temperature, drink name, and price to the file
				for (Item item : cart.getItems())
				{
					writer.write(item.getSize() + "," + item.getTemperature()
							+ "," + item.getDrink().getName() + ","
							+ item.getPrice() + "\n");
				}
				// Write the total cost to the file
				writer.write("Total: $" + cart.getTotal());
				writer.close();
			}
			catch (IOException ex)
			{
				// If an error occurs, print error message
				System.out.println(
						"An error occurred while saving the cart to file.");
				ex.printStackTrace();
			}
		}
	}
}
