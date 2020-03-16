package Query;

// Created by Andrew Lucas & Giovanni Salas.
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
        return "Select * From publishers " +
                "Natural Join books Natural Join writingGroups " +
                "Where publisherName = ?";
    }
    
    // Inserts a new Publisher into the table.
    public String insertPublisher()
    {
        // SQL Query
        return "Insert Into publishers Values " +
                "(?, ?, ?, ?)";
    }
    
    // Replaces one Publisher with another.
    public String updatePublisher()
    {
        // SQL Query
        return "Update books " +
                "Set publisherName = ? Where publisherName = ?";
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
