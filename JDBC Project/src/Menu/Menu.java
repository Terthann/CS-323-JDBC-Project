package Menu;

import java.util.Scanner;

public class Menu
{
    private int choice;
    private String specified;
    private Scanner in;
    
    // Constructor
    public Menu()
    {
        choice = 0;
        specified = null;
        in = new Scanner(System.in);
    }
    
    // Method to start the menu.
    public void start()
    {
        System.out.println("Welcome!");
        
        do
        {
            // List all writing groups.
            System.out.println("1) List Writing Groups");
            // List all data for a group specified by the user.
                // Includes all data for the associated books and publishers.
            System.out.println("2) List Writing Group Data");
            // List all publishers.
            System.out.println("3) List Publishers");
            // List all data for a publisher specified by the user.
                // Includes all data for the associated books and writing groups.
            System.out.println("4) List Publisher Data");
            // List all book titles.
            System.out.println("5) List Book Titles");
            // List all data for a single book specified by the user.
                // Includes all data for the associated publisher and writing group.
            System.out.println("6) List Book Data");
            // Insert new book.
            System.out.println("7) Insert Book");
            // Insert new publisher and update books from a previous publisher to the new one.
                // Add publisher first.
                // Then update books.
            System.out.println("8) Insert Publisher");
            // Remove single book specified by the user.
            System.out.println("9) Remove Book");
            // Quit menu.
            System.out.println("10) Quit Menu");
            
            // Ask for input.
            System.out.print("Please select one: ");
            // Check if input is valid.
            if (in.hasNextInt())
                choice = in.nextInt();
            else
            {
                System.out.println("\nIncorrect input, please try again.\n");
                // Resets the input.
                in.next();
            }
        } while (choice != 10);
    }
}