
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Divisible {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(2);
        numbers.add(-17);
        numbers.add(-5);
        numbers.add(7);

        ArrayList<Integer> divisible = divisible(numbers);

        divisible.stream()
                .forEach(luku -> System.out.println(luku));
    }

    public static ArrayList<Integer> divisible(ArrayList<Integer> numbers) {
        ArrayList<Integer> listA = numbers.stream()
            .filter(x -> x % 2 == 0)
            .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> listB = numbers.stream()
            .filter(x -> x % 3 == 0)
            .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> listC = numbers.stream()
            .filter(x -> x % 5 == 0)
            .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> fullList = listA;
        for (int i : listB) {
            fullList.add(i);
        }
        for (int i : listC) {
            fullList.add(i);
        }
        return fullList;
    }

}
