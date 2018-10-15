import java.util.NoSuchElementException;
/**
   Add a method firstToLast to this implementation of a queue.
   The method moves the element at the head of the queue to
   the tail of the queue. The element that was second in line
   will now be at the head.
*/
public class LinkedListQueue
{
   private Node head; //remove from here
   private Node tail; //add to here 

   /**
      Constructs an empty queue.
   */
   public LinkedListQueue()
   {
      head = null;
      tail = null;
   }

   /**
      Moves the head of the queue to the tail.
   */
   public void firstToLast()
   {
       if (tail==null) {return;}
       if (tail==head) {return;}
       
       tail.next= head;
       tail= head;
       head= head.next;
       tail.next= null; 
       
   }
   
   public void lastToFirst()
   {
       if (tail==null) {return;}
       if (tail==head) {return;}
       
       Node temp=tail;
       temp.next= head;
       
       head=temp;
       
       Node newNode= head;
       
       while(newNode.next!=tail)
       {
           newNode=newNode.next;
       }
       //System.out.println("Hi");
       tail=newNode;
       tail.next=null;
       
   }

   /**
      Checks whether this queue is empty.
      @return true if this queue is empty
   */
   public boolean empty()
   {
      return head == null;
   }

   /**
      Adds an element to the tail of this queue.
      @param newElement the element to add
   */
   public void add(Object element)
   {
       if (tail==null) //head must also be null
       {
           Node temp= new Node();
           temp.data= element; 
           temp.next= null; 
           tail= temp; 
           head= temp; 
       }
       else
       {
           Node temp= new Node();
           temp.data= element; 
           temp.next= null;
           
           tail.next= temp;
           tail= temp;
       }
   }

   /**
      Removes an element from the head of this queue.
      @return the removed element
   */
   public Object remove()
   {
       if (head ==null)
       {
           return null;
       }
       Object element= head.data;
       head= head.next; //head is pointing down to tail //this moves head towards teh tail
       if (head == null)
       //queue is empty
       {
           tail= null;
       }
       return element;
   }
   
   class Node
   {
       public Object data;
       public Node next;
   }

   }

