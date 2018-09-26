import java.util.NoSuchElementException; 

/**
 * Just keeps track of stuff- not the actual data 
 * @author Sarah Walz
 * @version (a version number or a date)
 */
public class LinkedList
{
    //Single linked list
    private Node first;
    //needs to access to all nods- so we need an inner class
    
    //can get at public data from node- but cannot acess this outside this class
    class Node
    {
        // Old School 
        //Put any object into and out of linkedlist
        //cast to type the object as we remove 
        public Object data;
        public Node next; 
    }
    
    
    /**
     * Default constructor for objects of class LinkedList
     */
    public LinkedList()
    {
        // initialise instance variables
        first= null; 
    }
    
    /**
     * Adds an element to the front of the LL
     * @param element, the element to add 
     */
    public void addFirst(Object element)
    {
        Node newNode = new Node(); // is polymorphic- can be anything
        newNode.data= element; //the data will point to the object
        newNode.next= first; 
        first= newNode; 
    }
    
    /**
     * Retruns the first element of the LL
     * @return the first element as object
     */
    public Object getFirst()
    {
        if (first== null) {throw new NoSuchElementException();}
        return first.data; 
    }
    
    /**
     * Removes the first element in the LL
     * @return the removed element 
     */
    public Object removeFirst()
    {
        if (first== null) {throw new NoSuchElementException();}
        Object temp= first.data;
        first= first.next;
        return temp; 
    }
    
    public ListIterator listIterator()
    {
       return new LinkedListIterator();  
    }
        
    
    class LinkedListIterator implements ListIterator //could implement iterator interface- but has extra methods we don't need
    {
        private Node position; 
        private Node previous;  //this is so we can remove 
        private boolean isAfterNext; 
        
        public LinkedListIterator()
        {
            position= null; 
            previous= null;
            isAfterNext= false;  
        }
        
        /**
        * Moves the iterator past the next element 
        * @return the traversed element 
        */
        public Object next()
        {
            if (!hasNext()) {throw new NoSuchElementException();}
            
            previous= position; //purly so that I can remove item
            isAfterNext= true; 
            
            if (position == null)//which means we would be at the very end or just started it
            {
                position= first; //just adress/references to objects
            }
            else
            {
                position= position.next;
            }
                        
            return position.data; 
        }
        
        /**
        *Tests if there is a next element
        * @return true if there is a next element 
        */
        public boolean hasNext()
        {
            if (position ==  null)
            {
                return first!= null; 
            }
            else
            {
                return position.next != null; 
            }
        }
        
    }
        

}


