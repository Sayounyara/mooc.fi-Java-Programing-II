
import java.util.ArrayList;

public class Herd implements Movable {
    
    private ArrayList<Movable> members;
    
    public Herd() {
        this.members = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable) {
        this.members.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Movable member : this.members) {
            member.move(dx, dy);
        }
    }
    
    @Override
    public String toString() {
        String members = "";
        for (int i = 0; i < this.members.size(); i++) {
            members += this.members.get(i);
            if (i == this.members.size() - 1) {
                break;
            }
            members += "\n";
        }
        return members;
    }
    
}
