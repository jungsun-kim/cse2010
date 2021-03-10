// IntArrayBag.java
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntArrayBag implements IntBag {
    public static int INITIAL_CAPACITY = 100;
    
    private int[] data;
    private int manyItems;
    
    public IntArrayBag() {
        data = new int[INITIAL_CAPACITY];
        manyItems = 0;
    }
    
    public IntArrayBag(int capacity) {
        data = new int[capacity];
        manyItems = 0;
    }
    
    @Override
    public void addItem(int item) {
        data[manyItems++] = item;
    }
    
    @Override
    public int countOccur(int item) {
        return (int) Arrays.stream(data).filter(elem -> elem == item).count();
    }
    
    @Override
    public boolean remove(int item) {
        int current = 0;
        while (current < manyItems && data[current] != item)
            current++;
        if (current == manyItems) return false;
        
        while (current < manyItems - 1) {
            data[current] = data[current+1];
            current++;
        }
        --manyItems;
        return true;
    }
    
    public boolean removeFast(int item) {
        int current = 0;
        while (current < manyItems && data[current] != item)
            current++;
        if (current == manyItems) return false;
        
        data[current] = data[--manyItems];
        return true;
    }
    
    @Override
    public int size() {
        return data.length;
    }
    
    @Override
    public String toString() {
        return "IntArrayBag{" +
            "data=" + Arrays.toString(data) +
            ", manyItems=" + manyItems +
            '}';
    }
    
    // for testing only
    public int[] getData() {
        return data;
    }
    
    // for testing only
    public void print() {
        System.out.println(
            Arrays.stream(data).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]"))
        );
    }

}
