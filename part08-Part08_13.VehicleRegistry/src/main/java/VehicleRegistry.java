
import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> vehicles;
    
    public VehicleRegistry() {
        this.vehicles = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if (vehicles.containsKey(licensePlate)) {
            return false;
        }
        vehicles.put(licensePlate, owner);
        return true;
    }
    
    public String get(LicensePlate licensePlate) {
        return vehicles.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (!(vehicles.containsKey(licensePlate))) {
            return false;
        }
        vehicles.remove(licensePlate);
        return true;
    }
    
    public void printLicensePlates() {
        for (LicensePlate license: vehicles.keySet()) {
            System.out.println(license);
        }
    }
    
    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();
        for (String owner: vehicles.values()) {
            if (!(owners.contains(owner))) {
                System.out.println(owner);
                owners.add(owner);
            }
        }
    }
}
