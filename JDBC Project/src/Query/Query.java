package Query;

public abstract class Query
{
    // Variables
    // Constructor
    // Methods
    
    // Abstract Methods
    public abstract String listAll();
    public abstract String listData();
    public abstract String insertBook(); // Only used by BookQuery.
    
    public void printData(String head, int year, String subject,
                          String address, String phone, String email,
                          String groupName, String title, String pubName, int yearPub, int pages)
    {
        // Print data.
        System.out.println("Group Name: " + groupName);
        System.out.println("Head Writer: " + head);
        System.out.println("Year Formed: " + year);
        System.out.println("Subject: " + subject);
        System.out.println("Publisher Name: " + pubName);
        System.out.println("Address: " + address);
        System.out.println("Phone #: " + phone);
        System.out.println("E-mail: " + email);
        System.out.println("Book Title: " + title);
        System.out.println("Year Published: " + yearPub);
        System.out.println("Number of Pages: " + pages + "\n");
    }
}
