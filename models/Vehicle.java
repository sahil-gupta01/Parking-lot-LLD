package parkingLot.models;

public class Vehicle extends BaseModel{
    private String num;
    private VehicleType vehicleType;
    private String ownerName;

    public Vehicle(String num, VehicleType vehicleType, String ownerName) {
        this.num = num;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
