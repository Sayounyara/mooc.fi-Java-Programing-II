
package dictionary;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.Paths;

public class SaveableDictionary {
    
    private HashMap<String, String> entries;
    private String file;
    
    public SaveableDictionary() {
        this.entries = new HashMap<>();
        this.file = null;
    }
    
    public SaveableDictionary(String file) {
        this.entries = new HashMap<>();
        this.file = file;
    }
    
    public void add(String words, String translation) {
        if (this.entries.containsKey(words) || this.entries.containsKey(translation)) {
            return;
        }
        if (this.entries.containsValue(translation) || this.entries.containsValue(words)) {
            return;
        }
        
        this.entries.put(words, translation);
        this.entries.put(translation, words);
    }
    
    public void delete(String word) {
        this.entries.remove(this.entries.get(word));
        this.entries.remove(word);
    }
    
    public boolean save() {
        try {
            PrintWriter write = new PrintWriter(this.file);
            
            ArrayList<String> usedKeys = new ArrayList<>();
            for (String key : this.entries.keySet()) {
                if (usedKeys.contains(this.entries.get(key))) {
                    continue;
                }
                write.println(key + ":" + this.entries.get(key));
                usedKeys.add(key);
            }
            write.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean load() {
        try (Scanner scanner = new Scanner(Paths.get(this.file))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                
                String[] parts = row.split(":");
                add(parts[0], parts[1]);
            }
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public String translate(String word) {
        if (!this.entries.containsKey(word)) {
            return null;
        }
        return this.entries.get(word);
    }
    
}
