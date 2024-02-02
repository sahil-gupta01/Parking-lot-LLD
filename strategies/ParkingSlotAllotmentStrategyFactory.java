package parkingLot.strategies;

public class ParkingSlotAllotmentStrategyFactory {
    public static ParkingPlaceAllotmentStrategy getParkingSlotAllotmentStrategy(ParkingPlaceAllotmentStrategy allotmentStrategy){
        return new SimpleParkingSlotAllotmentStrategy();
    }
}
