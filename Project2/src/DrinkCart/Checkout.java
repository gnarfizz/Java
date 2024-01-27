package DrinkCart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for the checkout process
 * Class has-a relationship with Cart class
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
class Checkout
//Checkout has-a Cart
{
	private Cart cart;
	private static final Drink[] drinks = { new Drink("Tea", 2.00, true),
			new Drink("Smoothie", 4.00, false),
			new Drink("Coffee", 3.00, true) };

	/**
	 * Creates a new Checkout object with the given cart
	 *
	 * @param cart the cart to use for the checkout process
	 */
	public Checkout(Cart cart)
	{
		this.cart = cart;
	}

	/**
	 * Calculate the total price of all items in the cart
	 *
	 * @param items     the items in the cart
	 * @param itemCount the number of items in the cart
	 * @return the total price of all items in the cart
	 */
	private double getTotal(Item[] items, int itemCount)
	{
		double total = 0;
		for (int i = 0; i < itemCount; i++)
		{
			total += items[i].getPrice();
		}
		return total;
	}

	/**
	 * Start the checkout process
	 */
	public void start()
	{
		Scanner keyboardInput = new Scanner(System.in);
		Item[] items = new Item[10];
		// sets the array size to 10
		int itemCount = 0;
		int option = 0;

		do // do-while loop for menu options
		{
			// displays menu to user
			System.out.println("Enter an option:");
			System.out.println("1. Add item to cart");
			System.out.println("2. Remove item from cart");
			System.out.println("3. Display cart");
			System.out.println("4. Checkout");
			System.out.println("5. Exit");

			try
			{
				option = keyboardInput.nextInt();
				keyboardInput.nextLine();

				switch (option)
				{
					case 1:
						// case to add item to cart
						System.out.println("Choose a drink:");
						// prints if case 1 is chosen
						for (int i = 0; i < drinks.length; i++)
						{
							// loop to iterate over each in the drinks array
							System.out.println(
									(i + 1) + ". " + drinks[i].getName());
							// prints out the drink name
						}
						int drinkChoice = keyboardInput.nextInt();
						// user input is set to drinkChoice variable
						keyboardInput.nextLine();
						System.out.println("Choose a size (S/M/L):");
						// prompts user to pick a size
						String sizeChoice = keyboardInput.nextLine();
						// user input is set to sizeChoice variable
						while (!sizeChoice.equalsIgnoreCase("S")
								&& !sizeChoice.equalsIgnoreCase("M")
								&& !sizeChoice.equalsIgnoreCase("L"))
						{
							System.out.println(
									"Invalid size. Please choose between S/M/L.");
							// prints statement if input is not S/M/ or L
							sizeChoice = keyboardInput.nextLine();
						}
						String temperatureChoice = null;
						if (drinks[drinkChoice - 1].getName()
								.equalsIgnoreCase("Smoothie"))
						{
							// if the drink is a Smoothie, prompts user with
							// Iced
							System.out.println("Choose a temperature:(Iced): ");
							temperatureChoice = keyboardInput.nextLine();
							while (!temperatureChoice.equalsIgnoreCase("Iced"))
							{
								System.out.println(
										"Invalid option. Please choose Iced.");
								// print statement if something other than ice
								// is
								// chosen
								temperatureChoice = keyboardInput.nextLine();
								// user input is set to temperatureChoice
								// variable
							}
						}
						else
						{
							System.out.println(
									"Choose a temperature(Hot/Iced): ");
							// else, prompts user with the temperature choices
							temperatureChoice = keyboardInput.nextLine();
							// user input is set to temperatureChoice variable
							while (!temperatureChoice.equalsIgnoreCase("Hot")
									&& !temperatureChoice
											.equalsIgnoreCase("Iced"))
							{
								System.out.println(
										"Invalid option. Please choosen between Hot or Cold.");
								// print statement if input is not hot or cold
								temperatureChoice = keyboardInput.nextLine();
							}
						}

						Drink chosenDrink = drinks[drinkChoice - 1];
						Item newItem = new OrderItem(chosenDrink, sizeChoice,
								temperatureChoice);
						// creates a new item using the chosen drink, size, and
						// temperature
						items[itemCount++] = newItem;
						// adds the new item to the items array and increments
						// itemCount
						System.out.println("Item added to cart.");
						// prints statement
						break;
					// breaks case

					case 2:
						// case to remove item from the cart
						System.out.println("Enter the item number to remove:");
						// prints statement if case 2 is chosen
						int itemToRemove = keyboardInput.nextInt();
						keyboardInput.nextLine();
						for (int i = itemToRemove - 1; i < itemCount - 1; i++)
						{
							// loop to iterate over each item in the items array
							items[i] = items[i + 1];
							// sets the corresponding item in the items array to
							// be
							// the same as the next item in the array
						}
						itemCount--;
						// decrements the itemCount variable
						System.out.println("Item removed from cart.");
						// prints statement
						break;
					// breaks case

					case 3:
						// case to display all items in the cart
						double total = 0;
						System.out.println("Items in Cart:");
						// prints statement if case 3 is picked
						for (int i = 0; i < itemCount; i++)
						{
							// loop to iterate over each item in the items array
							Item item = items[i];
							// each item receive the Item object at the current
							// index and is assigned to the item variable
							System.out.println(i + 1 + ". " + item.getSize()
									+ " " + item.getTemperature() + " "
									+ item.getDrink().getName() + " - $"
									+ item.getPrice());
							// prints each item in the index in the cart by
							// adding 1
							// to i. Prints drink size, temperature, drink name,
							// and
							// price.
							total += item.getPrice();
						}
						System.out.println("Total: $" + total);
						// prints the total of all the drinks
						break;
					// breaks case

					case 4:
						// case to checkout items in the cart
						total = 0;
						// resets the total variable to 0
						System.out.println("Total: $" + cart.getTotal());
						// prints the total cost of all items in the cart
						System.out.println("Thank you for your purchase!");
						// prints statement
						saveCartToFile(items, itemCount);
						// saves items in the cart to file using
						// saveCartToFile()
						// method
						items = new Item[10];
						// clears cart by initializing a new array of items
						itemCount = 0;
						return;
					// returns the method, ends while loop

					case 5:
						System.out.println("Goodbye!");
						// prints statement if case 5 is chosen
						return;
					// returns the method, ends while loop
				}
			}
			catch (InputMismatchException e) // throws exception if input isn't
												// from 1-5
			{
				System.out.println(
						"Invalid input. Please enter a number from 1-5.");
				keyboardInput.nextLine(); // clears the invalid input
			}
		} while (option != 5); // loop continues until the user enters 5 to exit
		// closes scanner for input
		keyboardInput.close();
	}

	/**
	 * Save the contents of the cart to a file
	 *
	 * @param items     the array of items to save to a file
	 * @param itemCount the number of items in the array
	 */
	private void saveCartToFile(Item[] items, int itemCount)
	{
		// create file object
		File file = new File("cart.txt");
		// creates a new file writer to write to the file
		// File Writer will automatically close even if an exception occurs
		try (FileWriter writer = new FileWriter(file))
		{
			for (int i = 0; i < itemCount; i++)
			{
				// loop to iterate over each item in the items array
				Item item = items[i];
				// creates a new item object and sets it to the current item in
				// the array
				writer.write(item.getSize() + "," + item.getTemperature() + ","
						+ item.getDrink().getName() + "," + item.getPrice()
						+ "\n");
			} // writes in the file including the size, temperature, name, and
				// price of the drink.
			writer.write("Total: $" + getTotal(items, itemCount));
			// writes in the file the total cost of all the items through
			// getTotal method
		}
		catch (IOException e)
		{
			// throws IOException and prints error message
			System.out.println(
					"An error occurred while saving the cart to file.");
			e.printStackTrace();
		}
	}
}
