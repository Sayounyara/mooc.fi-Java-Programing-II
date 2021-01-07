
import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> storage;
    
    public StorageFacility() {
        this.storage = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        storage.putIfAbsent(unit, new ArrayList<>());
        
        storage.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        if (storage.containsKey(storageUnit)) {
            return storage.get(storageUnit);
        }
        return new ArrayList<>();
    }
    
    public void remove(String storageUnit, String item) {
        storage.get(storageUnit).remove(item);
        
        if (storage.get(storageUnit).isEmpty()) {
            storage.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> units = new ArrayList<>();
        for (String i: storage.keySet()) {
            if (!(storage.get(i).isEmpty())) {
                units.add(i);
            }
        }
        return units;
    }
}
