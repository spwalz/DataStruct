
public class TestStack
{
    public static void main (String [] args)
    {
        LinkedListStack s= new LinkedListStack();
        s.push("Aaa");
        s.push("Bbb");
        s.push("Ccc");
        s.push("Ddd");
        s.push("Eee");
        
        while (!s.isEmpty())
        {
            System.out.println(s.pop());
        }
    }

}
