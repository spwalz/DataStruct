import java.util.NoSuchElementException;

/**
   An implementation of a queue as a circular array.
*/
public class CircularArrayQueue
{
   private Object[] elements;
   private int currentSize;
   private int head;
   private int tail;

   /**
      Constructs an empty queue.
   */
   public CircularArrayQueue() 
   {
      final int INITIAL_SIZE = 10;
      elements = new Object[INITIAL_SIZE];
      currentSize = 0;
      head = 0;
      tail = 0;
   }

   /**
      Checks whether this queue is empty.
      @return true if this queue is empty
   */
   public boolean empty() 
   { 
       return currentSize == 0; 
   }

   /**
      Adds an element to the tail of this queue.
      @param newElement the element to add
   */
   public void add(Object newElement)
   {
      growIfNecessary();
      currentSize++;
      elements[tail] = newElement;
      tail = (tail + 1) % elements.length;
   }

   /**
      Removes an element from the head of this queue.
      @return the removed element
   */
   public Object remove() 
   {
      if (currentSize == 0) { throw new NoSuchElementException(); }
      Object removed = elements[head];
      head = (head + 1) % elements.length;
      currentSize--;
      return removed;
   }
   
   public void firstToLast()
   {
       if (currentSize==0) {return;}
               //growIfNecessary();
        //        elements[tail+1]= elements[head];
        //        elements[head]= elements[tail];
        //        elements[tail]= elements[tail+1];
        //        //elements[head]= elements[tail];
        //        elements[tail+1]= null; 
               
        //        int temp1= head;
        //        int temp2= tail;
        //        Object temp3= elements[head];
        //        elements[head]= elements[tail];
        //        elements[tail]= temp3;

        Object temp= elements[head];
        elements[head]= null;
        elements[head]=elements[tail];
        elements[tail]=temp;
        head+=1;
        tail+=1;
        

              
   }
   
   public void lastToFirst()//takes the elements, and moves it to the front
   {
       if (currentSize==0) {return;}
       Object temp= elements[tail-1];
       elements[tail-1]= null; 
       if (head!=0)
       {
           elements[head-1]= temp;
           head-=1;
       }
       else
       {
           head= currentSize;
           elements[currentSize]=temp;
       }
   }

   /**
      Grows the element array if the current size equals the capacity.
   */
   private void growIfNecessary()
   {
      if (currentSize == elements.length)
      {
         Object[] newElements = new Object[2 * elements.length];
         for (int i = 0; i < elements.length; i++) 
         { 
            newElements[i] = elements[(head + i) % elements.length]; 
         }      
         elements = newElements;
         head = 0;
         tail = currentSize;
      }
   }
}
