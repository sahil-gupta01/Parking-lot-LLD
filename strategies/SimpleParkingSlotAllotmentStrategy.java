package parkingLot.strategies;

import parkingLot.exceptions.ParkingLotFullException;
import parkingLot.models.ParkingLot;
import parkingLot.models.Slot;

public class SimpleParkingSlotAllotmentStrategy implements ParkingPlaceAllotmentStrategy{
    @Override
    public Slot getParkingSlot(ParkingLot parkingLot, long parkingLotId) throws ParkingLotFullException {
        //get the free Slot
        return null;
    }
}
