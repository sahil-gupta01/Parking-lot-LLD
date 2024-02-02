package parkingLot.dtos;

import parkingLot.models.Vehicle;
import parkingLot.models.VehicleType;

public class TicketRequest {
    private String vehicleNum;
    private String ownerName;
    private VehicleType vehicleType;
    private int gateId;
    private int parkingLotId;

    public TicketRequest(String vehicleNum, String ownerName, VehicleType vehicleType, int gateId, int parkingLotId) {
        this.vehicleNum = vehicleNum;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.gateId = gateId;
        this.parkingLotId = parkingLotId;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
