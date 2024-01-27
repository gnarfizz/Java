package DrinkCart;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Class for the GUI
 * Class has-a Cart and CheckoutGUI
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
 * GUI class extends JFrame, which is a part of Java's Swing Library for
 * creating a graphical user interface.
 * This class represents the main window of your application. It contains a
 * CheckoutGUI panel,
 * which is responsible for the user interactions related to the cart checkout.
 */
public class GUI extends JFrame
{
	// JPanel contentPane is used as the main container for GUI components
	private JPanel contentPane;

	/**
	 * Constructor for the GUI class
	 */
	public GUI()
	{
		// Defines the operation that will happen by default when the user
		// initiates a "close" on this frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Sets up the dimensions and position of the JFrame window
		setBounds(100, 100, 450, 300);
		// Instantiate contentPane as a JPanel, container for components
		contentPane = new JPanel();
		// Setting a 5 pixel empty border around the contentPane
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Sets the layout manager for the content Pane as BorderLayout
		contentPane.setLayout(new BorderLayout(0, 0));
		// Adds the contentPane to the JFrame
		setContentPane(contentPane);
		// Creates an instance of CheckoutGUI with a new cart Object
		CheckoutGUI checkoutGUI = new CheckoutGUI(new Cart());
		// Adds checkoutGUI panel to the center of the BorderLayout
		contentPane.add(checkoutGUI, BorderLayout.CENTER);
	}
}
