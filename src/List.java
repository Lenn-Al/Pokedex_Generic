import java.util.function.Predicate;

/**
 * Interface for a List
 *
 * @author Jane Doe 1234567 Group 42h
 * @author John Doe 1234567 Group 42h
 */
public interface List<T extends Comparable<T>> {
    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    int length();

    /**
     * Retrieves, but does not remove, the first item of this list, or returns null if this list is empty.
     * @return the first item of this list, or null if this list is empty
     */
    T firstItem();

    /**
     * Inserts the specified item in this list.
     * @param item item to be inserted
     */
    void insert(T item);

    /**
     * Removes the first occurrence of the item from this list, if it is present.
     * @param item item to be removed from this list, if present
     */
    void delete(T item);

    /**
     * Returns true if this list contains the specified element. More formally, returns true if and only if this list contains at least one element e such that (o==null ? e==null : o.compareTo(e) == 0).
     * @param x element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    boolean isInList(T x);

    /**
     * Removes the element at the front position in this list. Returns the element that was removed from the list.
     * @return the element previously at the front position
     */
    T delete();

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return he element at the specified position in this list
     */
    T get(int index);

    /**
     * Appends all of the elements in the specified list.
     * @param list list containing elements to be added to this list
     */
    void addAll(List<T> list);

    /**
     * Returns a list consisting of the elements of this list that match the given predicate.
     * @param predicate a non-interfering, stateless predicate to apply to each element to determine if it should be included
     * @return the new list
     */
    List<T> filter(Predicate<T> predicate);
}