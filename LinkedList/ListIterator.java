

/**
 * Will create an interaface for a linked list iterator
 * 
 * @author Sarah Walz 
 * @version (a version number or a date)
 */
public interface ListIterator
{
    /**
     * Moves the iterator past the next element 
     * @return the traversed element 
     */
    Object next();
    
    /**
     * Tests if there is a next element
     * @return true if there is a next element 
     */
    boolean hasNext(); 
    
    /**
     * Adds an element before the interator position
     * and moves the iterator past the inserted element
     * @param element the element to add
     */
    void add(Object element);
    
    /**
     * Removes the last traversed element. this method may 
     * only be called after moving forward
     */
    void remove();

}
