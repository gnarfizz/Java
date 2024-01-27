package DrinkCart;

import java.util.ArrayList;

/**
 * Class for the cart
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
class Cart
// Cart has-a arrayList of OrderItem objects
{
	// List to hold OrderItem objects
	private ArrayList<OrderItem> items;

	/**
	 * Creates a new Cart object
	 */
	public Cart()
	{
		// initalizes items list
		items = new ArrayList<>();
	}

	/**
	 * Add an item to the cart
	 *
	 * @param item the item to add to the cart
	 */
	public void addItem(OrderItem item)
	{
		// adds an item to the cart
		items.add(item);
	}

	/**
	 * Remove an item from the cart
	 *
	 * @param index the index of the item to remove
	 */
	public void removeItem(int index)
	{
		// removes an item from the cart based on the index
		if (index < items.size() && index >= 0)
		{
			items.remove(index);
		}
	}

	/**
	 * Get the total price of all items in the cart
	 *
	 * @return the total price of all items in the cart
	 */
	public double getTotal()
	{
		double total = 0;
		for (OrderItem item : items)
		{
			total += item.getPrice();
		}
		return total;
	}

	/**
	 * Display the contents of the cart
	 */
	public void displayCart()
	{
		System.out.println("Items in Cart: ");
		// iterates through all items in the list
		for (int i = 0; i < items.size(); i++)
		{
			// gets the current item
			OrderItem item = items.get(i);
			// prints item details and position in the list
			System.out.println(i + 1 + ". " + item.getSize() + " "
					+ item.getTemperature() + " " + item.getDrink().getName()
					+ " - $" + item.getPrice());
		}
		System.out.println("Total: $" + getTotal());
	}

	/**
	 * Get the items in the cart as an arrayList
	 *
	 * @return an arrayList of the items in the cart
	 */
	public ArrayList<OrderItem> getItems()
	{
		// return a copy of all the items in the cart
		ArrayList<OrderItem> copy = new ArrayList<>(items);
		return copy;
	}
}
