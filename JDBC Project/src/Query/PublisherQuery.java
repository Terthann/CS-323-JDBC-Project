package Query;

public class PublisherQuery extends Query
{   
    @Override
    public String listAll()
    {
        // SQL Query
        return "Select * From publishers";
    }

    @Override
    public String listData()
    {
        // SQL Query Here
        return "Select * From publishers";
    }
}