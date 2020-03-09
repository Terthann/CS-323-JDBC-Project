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
    public void listData(String input)
    {
        // SQL QUery Here
    }
}