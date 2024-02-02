package parkingLot.strategies;

import parkingLot.exceptions.ParkingLotFullException;
import parkingLot.models.ParkingLot;
import parkingLot.models.Slot;

public interface ParkingPlaceAllotmentStrategy {
    Slot getParkingSlot(ParkingLot parkingLot, long parkingLotId)
                throws ParkingLotFullException;
}
