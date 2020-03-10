package Query;

public class BookQuery extends Query
{
    @Override
    public String listAll()
    {
        // SQL Query
        return "Select * From books";
    }

    @Override
    public String listData()
    {
        // SQL QUery Here
        return "Select * From books";
    }
}