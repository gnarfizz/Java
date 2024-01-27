package DrinkCart;

/*
 * Class for a drink
 * Lead Author: Anver Chou; 0005756587
 * References:
 * Morelli, R., & Walde, R. (2016).
 * Java, Java, Java: Object-Oriented Problem Solving
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-
 * java-object-oriented-problem-solving
 * <<Add more references here>>
 * Version: May 27, 2023
 */
class Drink implements HotDrink
// Drink is-a HotDrink
{
	private String name;
	private double basePrice;
	private boolean isHotDrink;

	/**
	 * Creates a new Drink object with the given parameters
	 *
	 * @param name       the name of the drink
	 * @param basePrice  the base price of the drink
	 * @param isHotDrink whether the drink is hot or cold
	 */
	public Drink(String name, double basePrice, boolean isHotDrink)
	{
		this.name = name;
		this.basePrice = basePrice;
		this.isHotDrink = isHotDrink;
	}

	/**
	 * Get the name of the drink
	 *
	 * @return the name of the drink
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Get the base price of the drink
	 *
	 * @return the base price of the drink
	 */
	public double getBasePrice()
	{
		return basePrice;
	}

	/**
	 * Check whether the drink is a hot drink
	 *
	 * @return true if the drink is hot, false otherwise
	 */
	public boolean isHotDrink()
	{
		return isHotDrink;
	}

	/**
	 * Check whether the drink is a cold drink
	 *
	 * @return true if the drink is cold, false otherwise
	 */
	public boolean isColdDrink()
	{
		return !isHotDrink;
	}
	
	@Override
    public String toString() {
        return this.name;  // Return the name of the drink when toString() is called.
    }
}