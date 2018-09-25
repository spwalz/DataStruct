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

}


