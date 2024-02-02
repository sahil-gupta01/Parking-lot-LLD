package parkingLot.repositories;

import parkingLot.exceptions.NoParkingLotException;
import parkingLot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingRepository {

    Map<Integer, ParkingLot> parkingLotMap = new HashMap<>();
    public ParkingLot getParkingLotById(int parkingLotId) throws NoParkingLotException {
        if(parkingLotMap.containsKey(parkingLotId)){
            return parkingLotMap.get(parkingLotId);
        }
        throw new NoParkingLotException();
    }
}
