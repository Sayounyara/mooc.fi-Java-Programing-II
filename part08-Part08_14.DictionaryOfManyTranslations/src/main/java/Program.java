
public class Program {

    public static void main(String[] args) {
        // Testaa sanakirjaa täällä
        DictionaryOfManyTranslations dictionary = new DictionaryOfManyTranslations();
        dictionary.add("lie", "maata");
        dictionary.add("lie", "valehdella");

        dictionary.add("bow", "jousi");
        dictionary.add("bow", "kumartaa");

        System.out.println(dictionary.translate("lie"));
        dictionary.remove("bow");
        System.out.println(dictionary.translate("bow"));
        
        DictionaryOfManyTranslations d = new DictionaryOfManyTranslations();
        d.add("monkey","apina");
        d.add("monkey","apfe");
        d.add("cheese","juusto");
        d.remove("monkey");d.add("milk","maito");
        d.translate("monkey");

    }
}
