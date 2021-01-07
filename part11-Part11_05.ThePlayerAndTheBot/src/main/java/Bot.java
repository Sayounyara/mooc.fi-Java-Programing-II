
public class Bot extends Player {
    
    @Override
    public void play() {
        System.out.println("Bot is playing...");
    }
    
    public void addMove(String move) {
        System.out.println("Moved to " + move);
    }
    
}
