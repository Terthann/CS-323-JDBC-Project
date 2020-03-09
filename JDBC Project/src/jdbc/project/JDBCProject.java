package jdbc.project;

import Menu.*;
import Query.*;
import java.sql.*;

public class JDBCProject
{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/JDBCProject";
    
    public static void main(String[] args)
    {
        Connection connect = null;
        
        try
        {
            // Register JDBC driver.
            Class.forName(JDBC_DRIVER);

            // Open a connection.
            System.out.println("Connecting to database...");
            connect = DriverManager.getConnection(DB_URL);

            // Testing Menu
            Menu myMenu = new Menu();

            QueryFactory factory = new QueryFactory();
            int choice = myMenu.getChoice();
            Query myQuery = factory.getQuery(choice);
            
            //STEP 6: Clean-up environment
            //rs.close();
            //stmt.close();
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