package Query;

public class WritingGroupQuery extends Query
{
    @Override
    public String listAll()
    {
        // SQL Query
        System.out.println("Creating statement . . .");
        return "Select * From writingGroups";
    }

    @Override
    public void listData(String input)
    {
        // SQL Query Here
    }
}