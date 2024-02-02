package parkingLot.repositories;

import parkingLot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    Map<String, Vehicle> vehicleMap = new HashMap<>();
    long previousId = 0;
    public Vehicle getVehicleByNumber(String vehicleNum) {
        if(vehicleMap.containsKey(vehicleNum)){
            return vehicleMap.get(vehicleNum);
        }
        return null;
    }

    public void save(Vehicle vehicle) {
        vehicle.setId(++previousId);
        vehicleMap.put(vehicle.getNum(), vehicle);
    }
}
