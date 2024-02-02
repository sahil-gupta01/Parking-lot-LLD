package parkingLot.repositories;

import parkingLot.exceptions.GateNotFoundException;
import parkingLot.models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepositories {

    Map<Integer,Gate> gates = new HashMap<>();
    public Gate getGateByGateId(int gateId) throws GateNotFoundException {
        if(gates.containsKey(gateId)){
           return gates.get(gateId);
        }
        throw new GateNotFoundException();
    }
}
