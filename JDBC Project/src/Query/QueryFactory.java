package Query;

// Created by Andrew Lucas & Giovanni Salas.
public class QueryFactory
{
    public Query getQuery(int choice)
    {
        if (choice < 1)
            return null;
        
        if (choice <= 2)
            return new WritingGroupQuery();
        else if (choice <= 4 || choice == 8)
            return new PublisherQuery();
        else if (choice <= 6 || choice == 7 || choice == 9)
            return new BookQuery();
        
        return null;
    }
}