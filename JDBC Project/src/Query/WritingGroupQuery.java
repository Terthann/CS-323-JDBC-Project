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
    public String listData()
    {
        // SQL Query Here
        return "Select * From writingGroups " +
               "Inner Join books Using (groupName) Inner Join publishers Using (publisherName) " +
               "Where groupName = ?";
    }
}