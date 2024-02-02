package parkingLot.controller;

import parkingLot.dtos.ResponseStatus;
import parkingLot.dtos.TicketRequest;
import parkingLot.dtos.TicketResponse;
import parkingLot.exceptions.GateNotFoundException;
import parkingLot.exceptions.NoParkingLotException;
import parkingLot.exceptions.ParkingLotFullException;
import parkingLot.models.Ticket;
import parkingLot.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public static String TICKET_ISSUED_MESSAGE = "Ticket Booked";
    public static String INVALID_GATE = "Gate is not valid";
    public static String INVALID_PARKING_LOT = "Parking Lot is not valid";
    public static String PARKING_LOT_FULL = "Parking Lot is full";

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketResponse issueTicket(TicketRequest ticketRequest) {
        Ticket ticket = null;
        try {
            ticket = ticketService.issueTicket(ticketRequest);
        } catch (GateNotFoundException e) {
            return new TicketResponse(null,ResponseStatus.FAILED, INVALID_GATE);
        } catch (NoParkingLotException e) {
            return new TicketResponse(null,ResponseStatus.FAILED, INVALID_PARKING_LOT);
        } catch (ParkingLotFullException e) {
            return new TicketResponse(null,ResponseStatus.FAILED, PARKING_LOT_FULL);
        }
        return new TicketResponse(ticket, ResponseStatus.SUCCESS,TICKET_ISSUED_MESSAGE);

    }
}
