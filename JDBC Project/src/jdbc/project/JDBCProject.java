package jdbc.project;

import Menu.*;
import Query.*;
import java.sql.*;

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
                    // ***
                    // *** NEEDS DOING ***
                    // ***
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
                else if (choice == 7)
                {
                    // Ask user to enter new Book values.
                    String userInput[] = mainMenu.getBookValues();
                    // Create prepared statement.
                    System.out.println("\nCreating statement...\n");
                    PreparedStatement prepared = connect.prepareStatement(userQuery.insertBook());
                    // Add user input to statement.
                    prepared.clearParameters();
                    prepared.setString(1, userInput[0]);
                    prepared.setString(2, userInput[1]);
                    prepared.setString(3, userInput[2]);
                    prepared.setString(4, userInput[3]);
                    prepared.setString(5, userInput[4]);
                    // Execute SQL.
                    prepared.executeUpdate();
                    
                    System.out.println("Added " + userInput[1] + " to the Books table.\n");
                }
                else if (choice == 8)
                {
                    // ***
                    // *** NEEDS DOING ***
                    // ***
                    // Insert new publisher.
                }
                else if (choice == 9)
                {
                    // Ask user to enter Book's primary key.
                    String userInput[] = mainMenu.getBookPK();
                    // Create prepared statement.
                    System.out.println("\nCreating statement...\n");
                    PreparedStatement prepared = connect.prepareStatement(userQuery.removeBook());
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
