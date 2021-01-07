import java.util.Scanner;

public class UserInterface {
    private TodoList list;
    private Scanner scanner;
    
    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }
    
    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            
            if (command.equals("add")) {
                add();
            }
            if (command.equals("list")) {
                list();
            }
            if (command.equals("remove")) {
                remove();
            }
        }
    }
    
    public void add() {
        System.out.print("To add: ");
        String input = scanner.nextLine();
        list.add(input);
    }
    
    public void list() {
        list.print();
    }
    
    public void remove() {
        System.out.print("Which one is removed? ");
        int index = Integer.valueOf(scanner.nextLine());
        list.remove(index);
    }
}
