package Query;

public class WritingGroupQuery extends Query
{
    // Lists all Writing Groups in the table.
    @Override
    public String listAll()
    {
        // SQL Query
        return "Select * From writingGroups";
    }
    
    // Lists all data related to a specified Writing Group.
    @Override
    public String listData()
    {
        // SQL Query Here
        return "Select * From writingGroups " +
               "Natural Join books Natural Join publishers " +
               "Where groupName = ?";
    }
    
    // Prints a row from the Writing Group table.
    public void printGroup(String name, String head, int year, String subject)
    {
        // Print data.
        System.out.println("Group Name: " + name);
        System.out.println("Head Writer: " + head);
        System.out.println("Year Formed: " + year);
        System.out.println("Subject: " + subject + "\n");
    }
}