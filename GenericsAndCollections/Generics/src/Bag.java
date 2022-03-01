import java.util.*;

public class Bag<T> {
    ArrayList<T> objects;
    public Bag(){
        /* TODO 
Initialize the objects variable*/
        this.objects = new ArrayList<>();
    }
    // Adds the `obj` to Bag
    // Throws `BagException` if obj is null
    public void add(T obj) throws BagException
    {
        // check if the object is null
        if (obj == null)    throw new BagException("Cannot add null to Bag");
        // add the object to the end of list
        objects.add(obj);
    }

    // Adds the `element` to Bag
    // Throws `BagException` if ekement is null
    public void add(T element, double prob) throws BagException
    {
        // check if the object is null
        if (element == null)    throw new BagException("Cannot add null to Bag");
        // check if the probability is invalid
        if (prob < 0 || prob > 1)   throw new BagException("Probability should be between 0 and 1");
        // look at number of elements in `Bag`
        // and insert new element with given probability
        int tot = (int)Math.round(objects.size()*prob);
        for(int i=0; i < tot; i++){
            objects.add(element);
        }
    }


    // The `drawOne` Method
    public T drawOne()
    {
        // get a random Index
        int index = new Random().nextInt(this.objects.size());
        // return the element at given index
        return this.objects.get(index);
    }

    public ArrayList<T> drawMany(int howMany)
    {
        // stores the elements to be returned
        ArrayList<T> items = new ArrayList<>();
        // draw elements at random
        for (int i = 0; i < howMany; i++) items.add(drawOne());
        // return the elements
        return items;
    }


}
