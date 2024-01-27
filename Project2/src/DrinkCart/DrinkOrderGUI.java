package DrinkCart;

import java.awt.EventQueue;

/**
 * Class to show the GUI
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
 * This is the main class of the application. It runs the GUI on the Event
 * Dispatch Thread.
 */
public class DrinkOrderGUI
{
	/**
	 * The entry point of the application.
	 *
	 * @param args the command-line arguments. This program does not use
	 *             command-line arguments.
	 */
	public static void main(String[] args)
	{
		// EventQueue to run the provided Runnable
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					// Create and display the main frame of the application
					GUI frame = new GUI();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					// Print any exceptions that occur for debugging purposes
					e.printStackTrace();
				}
			}
		});
	}
}
