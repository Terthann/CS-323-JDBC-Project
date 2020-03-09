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
            
            System.out.println("Welcome!");
            do
            {
                // Show menu to get user input.
                choice = mainMenu.getChoice();
                // Create query based on input.
                Query userQuery = factory.getQuery(choice);
                
                if (choice == 1)
                {
                    System.out.println("\nCreating statement...\n");
                    state = connect.createStatement();
                    result = state.executeQuery(userQuery.listAll());
                    
                    while (result.next())
                    {
                        // Get row data.
                        String name = result.getString("groupName");
                        String head = result.getString("headWriter");
                        int year = result.getInt("yearFormed");
                        String subject = result.getString("subject");
                        
                        // Print data.
                        System.out.println("Group Name: " + name);
                        System.out.println("Head Writer: " + head);
                        System.out.println("Year Formed: " + year);
                        System.out.println("Subject: " + subject + "\n");
                    }
                }
                else if (choice == 3)
                {
                    System.out.println("\nCreating statement...\n");
                    state = connect.createStatement();
                    result = state.executeQuery(userQuery.listAll());
                    
                    while (result.next())
                    {
                        // Get row data.
                        String name = result.getString("publisherName");
                        String address = result.getString("publisherAddress");
                        String phone = result.getString("publisherPhone");
                        String email = result.getString("publisherEmail");
                        
                        // Print data.
                        System.out.println("Publisher Name: " + name);
                        System.out.println("Address: " + address);
                        System.out.println("Phone #: " + phone);
                        System.out.println("E-mail: " + email + "\n");
                    }
                }
                else if (choice == 5)
                {
                    System.out.println("\nCreating statement...\n");
                    state = connect.createStatement();
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
                        System.out.println("Group Name: " + groupName);
                        System.out.println("Book Title: " + title);
                        System.out.println("Publisher Name: " + pubName);
                        System.out.println("Year Published: " + year);
                        System.out.println("Number of Pages: " + pages + "\n");
                    }
                }
            } while (choice != 10);
            
            // Clean-up environment.
            result.close();
            state.close();
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
    }
}