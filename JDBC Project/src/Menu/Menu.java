package Menu;

import java.util.*;

public class Menu
{
    private int choice;
    private String specified;
    private Scanner in;
    
    private ArrayList<String> menuOptions;
    
    // Constructor
    public Menu()
    {
        choice = 0;
        specified = null;
        in = new Scanner(System.in);
        
        menuOptions = new ArrayList<String>();
        addOptions();
    }
    
    // Method to start the menu.
    public void start()
    {
        System.out.println("Welcome!");
        
        do
        {
            // List Menu Options.
            for (int i = 0; i < menuOptions.size(); i++)
                System.out.println(menuOptions.get(i));
            
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
    
    // Menu Options
    private void addOptions()
    {
        menuOptions.add("1) List Writing Groups");
        menuOptions.add("2) List Writing Group Data");
        menuOptions.add("3) List Publishers");
        menuOptions.add("4) List Publisher Data");
        menuOptions.add("5) List Book Titles");
        menuOptions.add("6) List Book Data");
        menuOptions.add("7) Insert Book");
        menuOptions.add("8) Insert Publisher");
        menuOptions.add("9) Remove Book");
        menuOptions.add("10) Quit Menu");
    }
}