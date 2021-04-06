package dictionary;

public class Main {
    public static void main(String[] args) {
        SaveableDictionary dictionary = new SaveableDictionary("words.txt");
        
        boolean loadSuccessful = dictionary.load();
        
        if (loadSuccessful) {
            System.out.println("Load was successful.");
            System.out.println();
        }
        
        System.out.println(dictionary.translate("apina")); // monkey
        System.out.println(dictionary.translate("olut")); // beer
        System.out.println(dictionary.translate("below")); // alla oleva
        System.out.println(dictionary.translate("beer")); // olut
        
        dictionary.add("a", "1");
        dictionary.add("b", "2");
        dictionary.add("c", "3");
        dictionary.add("d", "4");
        
        System.out.println();
        System.out.println(dictionary.translate("a")); // 1
        System.out.println(dictionary.translate("b")); // 2
        System.out.println(dictionary.translate("c")); // 3
        System.out.println(dictionary.translate("1")); // a
        System.out.println(dictionary.translate("4")); // d
        System.out.println(dictionary.translate("d")); // 4
        System.out.println(dictionary.translate("2")); // b
        System.out.println(dictionary.translate("3")); // c
        
        
        boolean saveSuccessful = dictionary.save();
        
        if (saveSuccessful) {
            System.out.println();
            System.out.println("Save was succesfull.");
        }
    }
}
