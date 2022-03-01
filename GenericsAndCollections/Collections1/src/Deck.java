// imports
import java.util.*;

// The `Deck` class
public class Deck implements Iterable<Card> {
    private List<Card> deck;
    private String[] suits = { "Hearts", "Clubs", "Diamonds", "Spades" };

    public Deck() {

        this.deck = new ArrayList<>();

        for (String suit : suits) {
            this.deck.add(new Card<String, String>("Ace", suit));
            this.deck.add(new Card<Integer, String>(2, suit));
            this.deck.add(new Card<Integer, String>(3, suit));
            this.deck.add(new Card<Integer, String>(4, suit));
            this.deck.add(new Card<Integer, String>(5, suit));
            this.deck.add(new Card<Integer, String>(6, suit));
            this.deck.add(new Card<Integer, String>(7, suit));
            this.deck.add(new Card<Integer, String>(8, suit));
            this.deck.add(new Card<Integer, String>(9, suit));
            this.deck.add(new Card<Integer, String>(10, suit));
            this.deck.add(new Card<String, String>("Jack", suit));
            this.deck.add(new Card<String, String>("Queen", suit));
            this.deck.add(new Card<String, String>("King", suit));
        }

    }

    public Card dealCard() {

        int index = new Random().nextInt(this.deck.size());
        return this.deck.remove(index);
    }

    public int size() {
        return this.deck.size();
    }

    @Override
    public Iterator<Card> iterator() {
        return new DeckIterator(this);
    }
}