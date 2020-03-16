package jdbc.project;

import Menu.*;
import Query.*;
import java.sql.*;
import java.util.ArrayList;

// Created by Andrew Lucas & Giovanni Salas.
public class JDBCProject
{
    // JDBC driver name and database URL.
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/JDBCProject";
    
    public static void main(String[] args)
    {
        // Initialize variables.
        Connection connect = null;
        Statement state = null;
        ResultSet result = null;
        Menu mainMenu = new Menu();
        QueryFactory factory = new QueryFactory();
        int choice = 0;
        
        try
        {
            // Register JDBC driver.
            Class.forName(JDBC_DRIVER);

            // Open a connection.
            System.out.println("Connecting to database...");
            connect = DriverManager.getConnection(DB_URL);
            
            // Start menu.
            System.out.println("Welcome!");
            do
            {
                // Show menu to get user input.
                choice = mainMenu.getChoice();
                // Create query based on input.
                Query userQuery = factory.getQuery(choice);
                
                // List all writing groups.
                if (choice == 1)
                {
                    // Create statement.
                    System.out.println("\nCreating statement...\n");
                    state = connect.createStatement();
                    // Execute SQL.
                    result = state.executeQuery(userQuery.listAll());
                    
                    while (result.next())
                    {
                        // Get row data.
                        String name = result.getString("groupName");
                        String head = result.getString("headWriter");
                        int year = result.getInt("yearFormed");
                        String subject = result.getString("subject");
                        
                        // Print data.
                        ((WritingGroupQuery) userQuery).printGroup(name, head, year, subject);
                    }
                }
                // List all data for specified writing group.
                else if (choice == 2)
                {
                    // Ask user for Writing Group.
                    String userInput = mainMenu.getInput();
                    // Create prepared statement.
                    System.out.println("\nCreating statement...\n");
                    PreparedStatement prepared = connect.prepareStatement(userQuery.listData());
                    // Add user input to statement.
                    prepared.clearParameters();
                    prepared.setString(1, userInput);
                    // Execute SQL.
                    result = prepared.executeQuery();
                    
                    // Used to check if the group exists.
                    int loopCounter = 0;
                    // Print each row of data.
                    while (result.next())
                    {
                        // Get Writing Group data.
                        String head = result.getString("headWriter");
                        int year = result.getInt("yearFormed");
                        String subject = result.getString("subject");
                        // Get Publisher data.
                        String address = result.getString("publisherAddress");
                        String phone = result.getString("publisherPhone");
                        String email = result.getString("publisherEmail");
                        // Get Book data.
                        String groupName = result.getString("groupName");
                        String title = result.getString("bookTitle");
                        String pubName = result.getString("publisherName");
                        int yearPub = result.getInt("yearPublished");
                        int pages = result.getInt("numberPages");
                        
                        // Print data.
                        userQuery.printData(head, year, subject, address, phone, email, groupName, title, pubName, yearPub, pages);
                        
                        // Tracks number of rows.
                        loopCounter++;
                    }
                    
                    // Check if the group exists.
                    if (loopCounter == 0)
                        System.out.println("No group with that name.\n");
                }
                // List all publishers.
                else if (choice == 3)
                {
                    // Create statement.
                    System.out.println("\nCreating statement...\n");
                    state = connect.createStatement();
                    // Execute SQL.
                    result = state.executeQuery(userQuery.listAll());
                    
                    while (result.next())
                    {
                        // Get row data.
                        String name = result.getString("publisherName");
                        String address = result.getString("publisherAddress");
                        String phone = result.getString("publisherPhone");
                        String email = result.getString("publisherEmail");
                        
                        // Print data.
                        ((PublisherQuery) userQuery).printPublisher(name, address, phone, email);
                    }
                }
                // List all data for specified Publisher.
                else if (choice == 4)
                {
                    // Ask user Publisher.
                    String userInput = mainMenu.getInput();
                    // Create prepared statement.
                    System.out.println("\nCreating statement...\n");
                    PreparedStatement prepared = connect.prepareStatement(userQuery.listData());
                    // Add user input to statement.
                    prepared.clearParameters();
                    prepared.setString(1, userInput);
                    // Execute SQL.
                    result = prepared.executeQuery();
                    
                    // Used to check if the group exists.
                    int loopCounter = 0;
                    // Print each row of data.
                    while (result.next())
                    {
                        // Get Writing Group data.
                        String head = result.getString("headWriter");
                        int year = result.getInt("yearFormed");
                        String subject = result.getString("subject");
                        // Get Publisher data.
                        String address = result.getString("publisherAddress");
                        String phone = result.getString("publisherPhone");
                        String email = result.getString("publisherEmail");
                        // Get Book data.
                        String groupName = result.getString("groupName");
                        String title = result.getString("bookTitle");
                        String pubName = result.getString("publisherName");
                        int yearPub = result.getInt("yearPublished");
                        int pages = result.getInt("numberPages");
                        
                        // Print data.
                        userQuery.printData(head, year, subject, address, phone, email, groupName, title, pubName, yearPub, pages);
                        
                        // Tracks number of rows.
                        loopCounter++;
                    }
                    
                    // Check if the group exists.
                    if (loopCounter == 0)
                        System.out.println("No publisher with that name.\n");
                }
                // List all books.
                else if (choice == 5)
                {
                    // Create statement.
                    System.out.println("\nCreating statement...\n");
                    state = connect.createStatement();
                    // Execute SQL.
                    result = state.executeQuery(userQuery.listAll());
                    
                    while (result.next())
                    {
                        // Get row data.
                        String groupName = result.getString("groupName");
                        String title = result.getString("bookTitle");
                        String pubName = result.getString("publisherName");
                        int year = result.getInt("yearPublished");
                        int pages = result.getInt("numberPages");
                        
                        // Print data.
                        ((BookQuery) userQuery).printBook(groupName, title, pubName, year, pages);
                    }
                }
                // List all data for specified book.
                else if (choice == 6)
                {
                    // Ask user for Book Title.
                    String titleInput = mainMenu.getInput();
                    String secondInput = mainMenu.getSecondInput();
                    // Create prepared statement.
                    System.out.println("\nCreating statement...\n");
                    PreparedStatement prepared = connect.prepareStatement(userQuery.listData());
                    // Add user input to statement.
                    prepared.clearParameters();
                    prepared.setString(1, titleInput);
                    prepared.setString(2, secondInput);
                    prepared.setString(3, secondInput);
                    // Execute SQL.
                    result = prepared.executeQuery();
                    
                    // Used to check if the group exists.
                    int loopCounter = 0;
                    // Print each row of data.
                    while (result.next())
                    {
                        // Get Writing Group data.
                        String head = result.getString("headWriter");
                        int year = result.getInt("yearFormed");
                        String subject = result.getString("subject");
                        // Get Publisher data.
                        String address = result.getString("publisherAddress");
                        String phone = result.getString("publisherPhone");
                        String email = result.getString("publisherEmail");
                        // Get Book data.
                        String groupName = result.getString("groupName");
                        String title = result.getString("bookTitle");
                        String pubName = result.getString("publisherName");
                        int yearPub = result.getInt("yearPublished");
                        int pages = result.getInt("numberPages");
                        
                        // Print data.
                        userQuery.printData(head, year, subject, address, phone, email, groupName, title, pubName, yearPub, pages);
                        
                        // Tracks number of rows.
                        loopCounter++;
                    }
                    
                    // Check if the group exists.
                    if (loopCounter == 0)
                        System.out.println("No book with that title, group, or publisher.\n");
                }
                // Insert a new book.
                else if (choice == 7)
                {
                    // Prompt user for new Book values.
                    String userInput[] = mainMenu.getBookValues();
                    // Create a statement to check if the Book exists.
                    System.out.println("\nChecking for duplicate entry...");
                    state = connect.createStatement();
                    result = state.executeQuery("Select * From books");
                    boolean duplicate = false;
                    while (result.next())
                    {
                        String group = result.getString("groupName");
                        String publish = result.getString("publisherName");
                        String title = result.getString("bookTitle");
                        if (group.equals(userInput[0]) && title.equals(userInput[1]) && publish.equals(userInput[2]))
                            duplicate = true;
                    }
                    if (duplicate)
                    {
                        System.out.println("That book already exists.");
                    }
                    else
                    {
                        System.out.println("No duplicate found.");
                        // Create a statement to check if the Writing Group exists.
                        System.out.println("\nChecking if group exists...");
                        state = connect.createStatement();
                        result = state.executeQuery("Select * From writingGroups");
                        ArrayList<String> groups = new ArrayList<String>();
                        while (result.next())
                        {
                            groups.add(result.getString("groupName"));
                        }
                        // If the group does not exist, add it to the table.
                        if (!groups.contains(userInput[0]))
                        {
                            System.out.println("Group not found.");
                            PreparedStatement addGroup = connect.prepareStatement("Insert Into writingGroups (groupName) Values (?)");
                            addGroup.clearParameters();
                            addGroup.setString(1, userInput[0]);
                            addGroup.executeUpdate();
                            System.out.println("Added " + userInput[0] + " to Writing Groups.");
                        }
                        else
                            System.out.println("Group found.");
                        // Create a statement to check if the Publisher exists.
                        System.out.println("\nChecking if publisher exists...");
                        state = connect.createStatement();
                        result = state.executeQuery("Select * From publishers");
                        ArrayList<String> publishers = new ArrayList<String>();
                        while (result.next())
                        {
                            publishers.add(result.getString("publisherName"));
                        }
                        // If the publisher does not exist, add it to the table.
                        if (!publishers.contains(userInput[2]))
                        {
                            System.out.println("Publisher not found.");
                            PreparedStatement addPublisher = connect.prepareStatement("Insert Into publishers (publisherName) Values (?)");
                            addPublisher.clearParameters();
                            addPublisher.setString(1, userInput[2]);
                            addPublisher.executeUpdate();
                            System.out.println("Added " + userInput[2] + " to Publishers.");
                        }
                        else
                            System.out.println("Publisher found.");
                        // Create prepared statement.
                        System.out.println("\nCreating statement...");
                        PreparedStatement prepared = connect.prepareStatement(((BookQuery)userQuery).insertBook());
                        // Add user input to statement.
                        prepared.clearParameters();
                        prepared.setString(1, userInput[0]);
                        prepared.setString(2, userInput[1]);
                        prepared.setString(3, userInput[2]);
                        prepared.setString(4, userInput[3]);
                        prepared.setString(5, userInput[4]);
                        // Execute SQL to add the book.
                        prepared.executeUpdate();
                        // Inform the user it was added.
                        System.out.println("Added " + userInput[1] + " to the Books table.\n");
                    }
                }
                // Insert a new publisher.
                else if (choice == 8)
                {
                    // Prompt user for new Publisher's details.
                    String userInput[] = mainMenu.getPublisherValues();
                    // Create a statement to check if the Publisher exists.
                    System.out.println("\nChecking for duplicate entry...");
                    state = connect.createStatement();
                    result = state.executeQuery("Select * From publishers");
                    boolean duplicate = false;
                    while (result.next())
                    {
                        String publish = result.getString("publisherName");
                        if (publish.equals(userInput[0]))
                            duplicate = true;
                    }
                    if (duplicate)
                    {
                        System.out.println("That publisher already exists.");
                    }
                    else
                    {
                        System.out.println("No duplicate found.");
                        // Create prepared statement.
                        System.out.println("\nCreating statement...");
                        PreparedStatement prepared = connect.prepareStatement(((PublisherQuery)userQuery).insertPublisher());
                        // Add user input to statement.
                        prepared.clearParameters();
                        prepared.setString(1, userInput[0]);
                        prepared.setString(2, userInput[1]);
                        prepared.setString(3, userInput[2]);
                        prepared.setString(4, userInput[3]);
                        // Execute SQL to add the Publisher.
                        prepared.executeUpdate();
                        // Inform the user it was added.
                        System.out.println("Added " + userInput[0] + " to the Publishers table.\n");

                        // Update Publisher.
                        String oldPublisher = mainMenu.updatePublisher(userInput[0]);
                        // Create prepared statement.
                        System.out.println("Creating statement...");
                        prepared = connect.prepareStatement(((PublisherQuery)userQuery).updatePublisher());
                        // Add user input to statement.
                        prepared.clearParameters();
                        prepared.setString(1, userInput[0]);
                        prepared.setString(2, oldPublisher);
                        // Execute SQL to add the Publisher.
                        int rowsUpdated = prepared.executeUpdate();
                        if (rowsUpdated > 0)
                        {
                            // Inform the user of the acquisition.
                            System.out.println(oldPublisher + " has been acquired by " + userInput[0] + ". " + rowsUpdated + " books updated.\n");
                        }
                        else
                            System.out.println(oldPublisher + " has no books or does not exist. No books updated.\n");
                    }
                }
                // Remove a single book.
                else if (choice == 9)
                {
                    // Ask user to enter Book's primary key.
                    String userInput[] = mainMenu.getBookPK();
                    // Create prepared statement.
                    System.out.println("\nCreating statement...\n");
                    PreparedStatement prepared = connect.prepareStatement(((BookQuery)userQuery).removeBook());
                    // Add user input to statement.
                    prepared.clearParameters();
                    prepared.setString(1, userInput[0]);
                    prepared.setString(2, userInput[1]);
                    prepared.setString(3, userInput[2]);
                    // Execute SQL.
                    prepared.executeUpdate();
                    
                    System.out.println("Removed " + userInput[1] + " from the Books table.\n");
                }
            } while (choice != 10);
            
            // Clean-up environment.
            if (result != null)
                result.close();
            if (state != null)
                state.close();
            if (connect != null)
                connect.close();
        }
        catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally
        {
            // Finally block used to close resources.
            try
            {
                if(state != null)
                    state.close();
            }
            catch(SQLException se2)
            {} // Nothing we can do.
            try
            {
                if(connect != null)
                    connect.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
