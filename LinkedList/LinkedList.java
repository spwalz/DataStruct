import java.util.NoSuchElementException; 
import java.util.*; 
//import java.util.IllegalStateException; 

/**
 * Just keeps track of stuff- not the actual data 
 * @author Sarah Walz
 * @version (a version number or a date)
 */
public class LinkedList
{
    //Single linked list
    private Node first;
    public int currentsize; 
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
        currentsize=0;
    }
    
    
    
    /**
     * P16.1 -->pg 761 part 1
     * Get method- gets the element at that integer
     * @param the integer number of the one you want
     * @return the data
     */
    public Object get(int n)
    {
       if (first== null) {throw new NoSuchElementException();}
       if (n> currentsize) {throw new NoSuchElementException();}
       
       Node temp= this.getNode(n);
       return temp.data;  
    }
    
    /**
     * P16.1 -->pg 761 part 2- helper method
     * Get method- gets the element at that integer
     * @param the integer number of the one you want
     * @return the data
     */
    private Node getNode(int n)
    {
       if (first== null) {throw new NoSuchElementException();}
       if (n> currentsize) {throw new NoSuchElementException();}
       
       Node current = first; 
       int count=0;
       while (count!=n ) 
       {
           current= current.next; 
           count++;
        }
       return current;  
    }
    
    /**
     * P16.1 -->pg 761 part 2
     * Set method- changes the data of the node
     * @param the integer number of the one you want, and the data you want to add
     * @return 
     */
    public void setNode(int n, Object newElement)
    {
       Node working= getNode(n);
       working.data= newElement;
    }
    
     /**
     * P16.4 -->pg 761 
     * Contains method- cehceks wheter it is there- no iterator
     */
    public boolean contains(Object element)
    {
       Node current = first; 
       int count=0;
       while (count!=currentsize) 
       {
           if (current.data.equals(element))
           {
               return true;
           }
           
           current= current.next; 
           count++;
        }
        
       return false;
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
        currentsize++; 
    }
    
    /**
     * 
     */
    public void faultyAddFirst(Object element) 
    {
        Node newNode = new Node();
        first = newNode; 
        newNode.data = element; 
        newNode.next = first; 
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
        currentsize--;
        return temp; 
    }
    
    /**
     * Reverses the List linkes
     * e16.1
     */
    public void reverse()
    {
       if (first== null) return; 
       
       Node previous = first; 
       Node current = first.next; 
       first.next = null; 
       while (current != null) 
       {
           Node next = current.next; 
           current.next = previous; 
           previous = current; 
           current = next; 
        }
       first = previous; 
    }
    
    /**
     * 
     */
    public int size() 
    {
        /*
        if (first== null) return;  //without this would throw an error if inputting an empty list
        int count= 0; 
        
        Node temp = first; 
        
        while(temp!= null)
        {
            count++;
            temp=temp.next;
        }
        
        return count; */
        return currentsize; 
    }
    
    public ListIterator listIterator()
    {
       return new LinkedListIterator();  
    }
    
    public String toString() 
    {
        ListIterator iter = this.listIterator(); 
        String returnString = ""; 
        while (iter.hasNext()) 
        {
            returnString += iter.next() + " ";
        }
        return returnString; 
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
        
        /**
         * Adds an element before the interator position
         * and moves the iterator past the inserted element
         * @param element the element to add
         */
        public void add(Object element)
        {
            if(position == null)
            {
                addFirst(element); 
                position=first; 
            }
            else
            {
                Node newNode = new Node();
                
                newNode.data= element; 
                newNode.next= position.next;
                position.next= newNode;
                position= newNode; //moved forward one
            }
            currentsize++; 
            isAfterNext= false; 
        }
        
        /**
         * Removes the last traversed element. this method may 
         * only be called after moving forward
         */
        public void remove()
        {
            if (!isAfterNext){throw new IllegalStateException();}
            
            if (position == first)
            {
                removeFirst(); 
            }
            else
            {
                previous.next= position.next; 
                
            }
            position= previous; 
            currentsize--; 
            isAfterNext= false; 
        }
        
        
    }
        

}


