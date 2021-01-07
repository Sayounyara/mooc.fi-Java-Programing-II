
import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> todo;
    
    public TodoList() {
        this.todo = new ArrayList<>();
    }
    
    public void add(String task) {
        todo.add(task);
    }
    
    public void print() {
        for (int i = 0; i < todo.size(); i++) {
            int a = i + 1;
            System.out.println(a + ": " + todo.get(i));
        }
    }
    
    public void remove(int index) {
        if (index < todo.size()) {
            todo.remove(index - 1);
        }
    }
}
