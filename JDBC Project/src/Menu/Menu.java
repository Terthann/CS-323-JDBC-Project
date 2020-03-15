package Menu;

import java.util.*;

public class Menu
{
    private int choice;
    private Scanner in;
    
    private ArrayList<String> menuOptions;
    
    // Constructor
    public Menu()
    {
        choice = 0;
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
    
    // Get user input.
    public String getInput()
    {
        if (choice == 2)
            System.out.print("Enter a Writing Group: ");
        else if (choice == 4)
            System.out.print("Enter a Publisher: ");
        else if (choice == 6)
            System.out.print("Enter a Book Title: ");
        
        in.nextLine();
        return in.nextLine();
    }
    
    // When choice == 9, ask for the Book's primary key to delete from table.
    public String[] getBookPK()
    {
        String[] bookPK = new String[3];
        
        System.out.print("Enter the Writing Group: ");
        in.nextLine();
        bookPK[0] = in.nextLine();
        
        System.out.print("Enter the Book Title: ");
        //in.nextLine();
        bookPK[1] = in.nextLine();
        
        System.out.print("Enter the Publisher Name: ");
        //in.nextLine();
        bookPK[2] = in.nextLine();
        
        return bookPK;
    }
    
    public String getSecondInput()
    {
        System.out.print("Enter the Writing Group OR Publisher: ");
        return in.nextLine();
    }
    
    // When choice == 7, get Book values to insert into table.
    public String[] getBookValues()
    {
        String[] bookValues = new String[5];
        
        System.out.print("Enter the Writing Group: ");
        in.nextLine();
        bookValues[0] = in.nextLine();
        
        System.out.print("Enter the Book Title: ");
        //in.nextLine();
        bookValues[1] = in.nextLine();
        
        System.out.print("Enter the Publisher Name: ");
        //in.nextLine();
        bookValues[2] = in.nextLine();
        
        System.out.print("Enter the Year Published: ");
        //in.nextLine();
        bookValues[3] = in.nextLine();
        
        System.out.print("Enter the Number of Pages: ");
        //in.nextLine();
        bookValues[4] = in.nextLine();
        
        return bookValues;
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
