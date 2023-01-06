package ru.seppna.airportjpa.service.ticket;

import ru.seppna.airportjpa.model.Booking;
import ru.seppna.airportjpa.model.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getAll();

    Ticket getByTicketNumber(String ticketNumber);

    void deleteByTicketNumber(String ticketNumber);

    Ticket update(Ticket ticket);

    Ticket create(Ticket ticket);

}
