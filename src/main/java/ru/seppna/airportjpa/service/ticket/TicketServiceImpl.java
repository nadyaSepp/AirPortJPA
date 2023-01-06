package ru.seppna.airportjpa.service.ticket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.seppna.airportjpa.dao.ticket.TicketDao;
import ru.seppna.airportjpa.model.Ticket;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketServiceImpl implements TicketService{

    private final TicketDao ticketDao;

    @Override
    public List<Ticket> getAll() {

        return ticketDao.getAll();
    }

    @Override
    public Ticket getByTicketNumber(String ticketNumber) {
        //какой параметр передаем в запросе
        log.info("Reguest with ticket number '{}'",ticketNumber);
        Ticket ticket=ticketDao.getByTicketNumber(ticketNumber);
        //логируем что вернулось из БД
        log.info("Responce from database with ticket '{}'",ticket);
        ticket.setFullPassengerInfo(String.format("%s - %s",ticket.getPassengerName(),ticket.getPassengerId()));
        return ticket;
    }

    @Override
    public void deleteByTicketNumber(String ticketNumber) {
        ticketDao.deleteByTicketNumber(ticketNumber);
    }

    @Override
    public Ticket update(Ticket ticket) {
        ticketDao.update(ticket);
        return ticket;
    }

    @Override
    public Ticket create(Ticket ticket) {
        ticketDao.create(ticket);
        return ticket;
    }
}
