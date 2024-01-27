package DrinkCart;

/**
 * Abstract class for an item
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
abstract class Item
// Item has-a Drink because each item contains a drink
{
	/**
	 * Get the drink associated with the item
	 *
	 * @return the drink associated with the item
	 */
	public abstract Drink getDrink();
	// method to return the Drink object associated with the Item

	/**
	 * Get the size of the item
	 *
	 * @return the size of the item
	 */
	public abstract String getSize();
	// method to return a string representing the size of the Item

	/**
	 * Get the temperature of the item
	 *
	 * @return the temperature of the item
	 */
	public abstract String getTemperature();
	// method to return a string representing the temperature of the Item

	/**
	 * Get the price of the item
	 *
	 * @return the price of the item
	 */
	public abstract double getPrice();
	// method to return a double representing the price of the Item
}
