// IntBag.java
public interface IntBag {
    void addItem(int item);    // adds one item to the collection
    int countOccur(int item);  // checks how many occurrences of a certain item are in the collection
    boolean remove(int item);  // removes one item from the collection
    int size();                // checks how many item are in the collection
}