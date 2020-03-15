package Query;

public class BookQuery extends Query
{
    // Lists all Books in the table.
    @Override
    public String listAll()
    {
        // SQL Query
        return "Select * From books";
    }
    
    // Lists all data related to a specified Book and Group.
    @Override
    public String listData()
    {
        // SQL Query Here
        return "Select * From books " +
               "Natural Join writingGroups Natural Join publishers " +
               "Where bookTitle = ? and (groupName = ? or publisherName = ?)";
    }
    

    // Inserts new Book into the table.
    public String insertBook()
    {
        // SQL Query
        return "Insert Into books Values " +
                "(?, ?, ?, ?, ?)";

    // Removes a Book from the table.
    public String removeBook()
    {
        // SQL Query
        return "Delete From books " +
                "Where groupName = ? And " +
                "bookTitle = ? And " +
                "publisherName = ?";

    }
    
    // Prints a row from the Book table.
    public void printBook(String groupName, String title, String pubName, int year, int pages)
    {
        // Print data.
        System.out.println("Group Name: " + groupName);
        System.out.println("Book Title: " + title);
        System.out.println("Publisher Name: " + pubName);
        System.out.println("Year Published: " + year);
        System.out.println("Number of Pages: " + pages + "\n");
    }
}
