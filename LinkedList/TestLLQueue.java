public class TestLLQueue
{
    public static void main (String [] args)
    {
        LinkedListQueue q= new LinkedListQueue();
        q.add("Diana");
        q.add("Harry");
        q.add("Tom");
        
        while (!q.empty())
        {
            System.out.print(q.remove()+" ");
        }
        System.out.println("\nExpected: Diana Harry Tom\n");
        
        q.add("Tom");
        q.add("Harry");
        q.add("Diana");
        q.firstToLast();
        
        while (!q.empty())
        {
            System.out.print(q.remove()+" ");
        }
        System.out.println("\nExpected: Harry Diana Tom \n");
        
        q.add("Tom");
        q.add("Harry");
        q.add("Diana");
        q.lastToFirst();
        
        while (!q.empty())
        {
            System.out.print(q.remove()+" ");
        }
        System.out.println("\nExpected: Diana Tom Harry \n");
    }

}