package DrinkCart;

/**
 * Main class for the program
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
public class Main
// Main class has a Checkout and a cart
{
	/**
	 * Entry point for the program
	 *
	 * @param args command line arguments (not used in this program)
	 */
	public static void main(String[] args)
	{
		try
		{
			Cart cart = new Cart();
			// creates a Cart class object (has-a relationship)
			Checkout checkout = new Checkout(cart);
			// creates a Checkout class that passes the Cart object (has-a
			// relationship)
			checkout.start();
			// starts the checkout process for the cart
		}
		catch (Exception e)
		{ // catches any exceptions thrown
			e.printStackTrace();
			System.out.println("Error:" + e.getMessage()); // prints exception
															// trace message
		}
	}
}
