package parkingLot.models;

import parkingLot.strategies.ParkingPlaceAllotmentStrategy;
import parkingLot.strategies.BillingStrategy;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<Floor> floors;
    private List<Gate> gates;
    private BillingStrategy billingStrategy;
    private ParkingLotStatus parkingLotStatus;
    private ParkingPlaceAllotmentStrategy allotmentStrategy;

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public BillingStrategy getBillingStrategy() {
        return billingStrategy;
    }

    public void setBillingStrategy(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public ParkingPlaceAllotmentStrategy getAllotmentStrategy() {
        return allotmentStrategy;
    }

    public void setAllotmentStrategy(ParkingPlaceAllotmentStrategy parkingPlaceAllotmentStrategy) {
        this.allotmentStrategy = parkingPlaceAllotmentStrategy;
    }
}
