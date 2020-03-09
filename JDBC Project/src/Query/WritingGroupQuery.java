package Query;

public class WritingGroupQuery extends Query
{
    @Override
    public String listAll()
    {
        // SQL Query
        return "Select * From writingGroups";
    }

    @Override
    public void listData(String input)
    {
        // SQL Query Here
    }
}