package Query;

public class PublisherQuery extends Query
{   
    @Override
    public String listAll()
    {
        // SQL Query
        System.out.println("Creating statement . . .");
        return "Select * From publishers";
    }

    @Override
    public void listData(String input)
    {
        // SQL Query Here
    }
}