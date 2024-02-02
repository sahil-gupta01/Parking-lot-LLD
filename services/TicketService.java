package parkingLot.services;

import parkingLot.dtos.TicketRequest;
import parkingLot.exceptions.GateNotFoundException;
import parkingLot.exceptions.NoParkingLotException;
import parkingLot.exceptions.ParkingLotFullException;
import parkingLot.models.*;
import parkingLot.repositories.GateRepositories;
import parkingLot.repositories.ParkingRepository;
import parkingLot.repositories.TicketRepository;
import parkingLot.repositories.VehicleRepository;
import parkingLot.strategies.ParkingPlaceAllotmentStrategy;
import parkingLot.strategies.ParkingSlotAllotmentStrategyFactory;

import java.util.Date;
import java.util.UUID;

public class TicketService {
    private GateRepositories gateRepositories;
    private VehicleRepository vehicleRepository;
    private ParkingRepository parkingRepository;

    public TicketService(GateRepositories gateRepositories, VehicleRepository vehicleRepository, ParkingRepository parkingRepository, TicketRepository ticketRepository) {
        this.gateRepositories = gateRepositories;
        this.vehicleRepository = vehicleRepository;
        this.parkingRepository = parkingRepository;
        this.ticketRepository = ticketRepository;
    }

    private TicketRepository ticketRepository;

    public Ticket issueTicket(TicketRequest ticketRequest) throws GateNotFoundException, NoParkingLotException, ParkingLotFullException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Gate gate = gateRepositories.getGateByGateId(ticketRequest.getGateId());
        ticket.setEntryGate(gate);

        Vehicle vehicle = getVehicleForNumber(ticketRequest);
        ticket.setVehicle(vehicle);

        Slot parkingSlot = getSlot(ticketRequest);
        ticket.setSlot(parkingSlot);

        ticket.setTicketNumber(ticketRequest.getOwnerName() + UUID.randomUUID());

        return ticketRepository.save(ticket);
    }

    private Slot getSlot(TicketRequest ticketRequest) throws NoParkingLotException, ParkingLotFullException {
        ParkingLot parkingLot = parkingRepository.getParkingLotById(ticketRequest.getParkingLotId());
        ParkingPlaceAllotmentStrategy parkingPlaceAllotmentStrategy = parkingLot.getAllotmentStrategy();
        ParkingPlaceAllotmentStrategy allotmentStrategy = ParkingSlotAllotmentStrategyFactory
                                    .getParkingSlotAllotmentStrategy(parkingPlaceAllotmentStrategy);
        Slot parkingSlot = allotmentStrategy.getParkingSlot(parkingLot, parkingLot.getId());
        return parkingSlot;
    }

    private Vehicle getVehicleForNumber(TicketRequest ticketRequest) {
        Vehicle vehicle = vehicleRepository.getVehicleByNumber(ticketRequest.getVehicleNum());
        if(vehicle == null){
            vehicle = new Vehicle(ticketRequest.getVehicleNum(), ticketRequest.getVehicleType(),
                    ticketRequest.getOwnerName());
            vehicleRepository.save(vehicle);
        }
        return vehicle;
    }
}
