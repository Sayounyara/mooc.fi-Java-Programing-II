
import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    
    private ArrayList<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void sort() {
        Collections.sort(this.cards);
    }
    
    public void print() {
        this.cards.stream().forEach(c -> System.out.println(c));
    }
    
    public ArrayList<Card> getCards() {
        return this.cards;
    }
    
    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }
    
    @Override
    public int compareTo(Hand o) {
        int currentTemp = 0; // this coulda been much simpler
        for (Card card : this.cards) {
            currentTemp += card.getValue();
        }
        int comparedTemp = 0;
        for (Card card : o.getCards()) {
            comparedTemp += card.getValue();
        }
        
        return currentTemp - comparedTemp;
    }
    
}
