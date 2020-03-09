package Query;

public class QueryFactory
{
    public Query getQuery(int choice)
    {
        if (choice < 1)
            return null;
        
        if (choice <= 2)
            return new WritingGroupQuery();
        else if (choice <= 4 || choice == 7 || choice == 9)
            return new BookQuery();
        else if (choice <= 6 || choice == 8)
            return new PublisherQuery();
        
        return null;
    }
}