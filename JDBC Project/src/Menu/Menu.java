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
    
    // Get user choice.
    public int getChoice()
    {
        // List Menu Options.
        for (int i = 0; i < menuOptions.size(); i++)
            System.out.println((i + 1) + ") " + menuOptions.get(i));

        // Ask for input.
        System.out.print("Please select one: ");
        // Check if input is an int.
        if (in.hasNextInt())
            choice = in.nextInt();
        else
        {
            System.out.println("\nIncorrect input, please try again.\n");
            // Resets the input.
            in.next();
            
            choice = getChoice();
        }
        // Check if input is within range.
        if (choice > 10 || choice < 1)
        {
            System.out.println("\nIncorrect input, please try again.\n");
            
            choice = getChoice();
        }
        
        return choice;
    }
    
    // Menu Options
    private void addOptions()
    {
        menuOptions.add("List Writing Groups");
        menuOptions.add("List Writing Group Data");
        menuOptions.add("List Publishers");
        menuOptions.add("List Publisher Data");
        menuOptions.add("List Book Titles");
        menuOptions.add("List Book Data");
        menuOptions.add("Insert Book");
        menuOptions.add("Insert Publisher");
        menuOptions.add("Remove Book");
        menuOptions.add("Quit Menu");
    }
}