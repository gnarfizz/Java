package DrinkCart;

/**
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
class OrderItem extends Item
// OrderItem is-a item, extends the item class
// OrderItem has-a Drink, each OrderItem contains a drink
{
	private Drink drink; // drink is associated with the item
	private String size; // size of the drink
	private String temperature; // temperature of the item
	private double price;

	/**
	 * Creates a new OrderItem object with the given parameters
	 *
	 * @param drink       the drink associated with the item
	 * @param size        the size of the item
	 * @param temperature the temperature of the item
	 */
	public OrderItem(Drink drink, String size, String temperature)
	{
		this.drink = drink;
		this.size = size;
		this.temperature = temperature;
		this.price = calculatePrice();
	}

	/**
	 * Get the drink associated with the item
	 *
	 * @return the drink associated with the item
	 */
	public Drink getDrink()
	{
		return drink;
	}

	/**
	 * Get the size of the item
	 *
	 * @return the size of the item
	 */
	public String getSize()
	{
		return size;
	}

	/**
	 * Get the temperature of the item
	 * 
	 * @return the temperature of the item
	 */
	public String getTemperature()
	{
		return temperature;
	}

	/**
	 * Get the price of the item
	 *
	 * @return the price of the item
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * Calculate the price of the item based on the size and temperature
	 *
	 * @return the calculated price of the item
	 */
	private double calculatePrice()
	{
		double sizeMultiplier = 1.00;
		// sets multiplier for size to 1
		double temperatureMultiplier = 1.00;
		// sets multiplier for temperature to 1
		if (size.equals("M"))
		{
			// if the size is medium
			sizeMultiplier = 1.50;
			// sets sizeMultiplier to 1.50
		}
		else if (size.equals("L"))
		{
			// if the size is large
			sizeMultiplier = 2.00;
			// sets sizeMultiplier to 2.00
		}
		if (temperature.equals("Hot"))
		{
			// if the temperature of the drink is Hot
			temperatureMultiplier = 1.20;
			// sets tempMultiplier to 1.20
		}
		double unroundedPrice = drink.getBasePrice() * sizeMultiplier
				* temperatureMultiplier;
		// sets unrounded variable
		double roundedPrice = Math.round(unroundedPrice * 100.00) / 100.00;
		// rounds the unrounded price to two decimal places using Math.round()
		return roundedPrice;
	}
}
