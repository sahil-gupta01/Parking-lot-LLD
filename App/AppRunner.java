package parkingLot.App;

import parkingLot.controller.TicketController;
import parkingLot.dtos.TicketRequest;
import parkingLot.models.VehicleType;
import parkingLot.repositories.GateRepositories;
import parkingLot.repositories.ParkingRepository;
import parkingLot.repositories.TicketRepository;
import parkingLot.repositories.VehicleRepository;
import parkingLot.services.TicketService;

public class AppRunner {
    public static void main(String[] args) {
        GateRepositories gateRepositories = new GateRepositories();
        ParkingRepository parkingRepository = new ParkingRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(gateRepositories, vehicleRepository, parkingRepository, ticketRepository);

        TicketController ticketController = new TicketController(ticketService);
        TicketRequest request = new TicketRequest
                            ("ABCD", "Sahil", VehicleType.TWO_WHEELER, 1, 1);
        ticketController.issueTicket(request);


    }
}
