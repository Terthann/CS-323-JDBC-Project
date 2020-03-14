package Query;

public class PublisherQuery extends Query
{   
    // Lists all Publishers in the table.
    @Override
    public String listAll()
    {
        // SQL Query
        return "Select * From publishers";
    }

    // Lists all data related to a specified Publisher.
    @Override
    public String listData()
    {
        // SQL Query Here
        return "Select * From publishers";
    }
    
    // Prints a row from the Publisher table.
    public void printPublisher(String name, String address, String phone, String email)
    {
        // Print data.
        System.out.println("Publisher Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone #: " + phone);
        System.out.println("E-mail: " + email + "\n");
    }
}