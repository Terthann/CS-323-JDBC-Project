package Query;

public class BookQuery extends Query
{
    @Override
    public String listAll()
    {
        // SQL Query
        System.out.println("Creating statement . . .");
        return "Select * From books";
    }

    @Override
    public void listData(String input)
    {
        // SQL QUery Here
    }
}