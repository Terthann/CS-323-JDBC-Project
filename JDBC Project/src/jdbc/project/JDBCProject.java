package jdbc.project;

import Menu.Menu;
import java.sql.*;

public class JDBCProject
{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/JDBCProject";
    
    public static void main(String[] args)
    {
        // Testing Menu
        Menu myMenu = new Menu();
        myMenu.start();
    }
}