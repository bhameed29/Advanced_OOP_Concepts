// imports
import java.util.*;

public class Counter<E> {

    // stores the count of objects
    private HashMap<E, Integer> counts;

    public Counter(E[] things) {
        // initialize the map
        this.counts = new HashMap<>();
        for (int i = 0; i < things.length; i++) {
            // get the number of times `ith` thing appeared before
            int count = this.counts.getOrDefault(things[i], 0);
            // increase the count in the map
            this.counts.put(things[i], count + 1);
        }

    }

    public Integer getCount(E element) {
        return this.counts.getOrDefault(element, 0);
    }

    public int getSize() {
        return this.counts.size();
    }

    public E mostFrequent() {
        E frequentItem = null;
        Integer frequency = 0;
        for (Map.Entry<E, Integer> entry : this.counts.entrySet()) {
            E key = entry.getKey();
            Integer value = entry.getValue();
            if (value > frequency) {
                frequency = value;
                frequentItem = key;
            }
        }
        return frequentItem;
    }
}