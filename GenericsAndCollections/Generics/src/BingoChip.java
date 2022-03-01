
public class BingoChip<T1, T2> {

    // The two generic variables of the class
    private T1 item1;
    private T2 item2;

    // The `constructor`
    public BingoChip(T1 item1, T2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    // Override the toString( )
    @Override
    public String toString() {
        // return the string representation of the chip
        return "Chip:" + item1 + "-" + item2;
    }
}

