
import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {
    
    public int compare(Card curr, Card comp) {
        if (curr.getSuit().ordinal() - comp.getSuit().ordinal() == 0) {
            return curr.getValue() - comp.getValue();
        }
        
        return curr.getSuit().ordinal() - comp.getSuit().ordinal();
        
    }
    
    
    
}
