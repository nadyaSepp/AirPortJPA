package ru.seppna.airportjpa.service.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.seppna.airportjpa.dao.booking.BookingDao;
import ru.seppna.airportjpa.model.Booking;
import ru.seppna.airportjpa.model.Ticket;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingDao bookingDao;
    @Override
    public List<Booking> getAll() {
        return bookingDao.getAll();
    }

    @Override
    public Booking getByBookRef(String bookRef) {
        return bookingDao.getByBookRef(bookRef);
    }

    @Override
    public void delete(String book_ref) {
        bookingDao.delete(book_ref);
    }

    @Override
    public Booking update(Booking booking) {
       return  bookingDao.update(booking);
    }

    @Override
    public Booking create(Booking booking) {
        return  bookingDao.create(booking);
    }

    @Override
    public List<Booking> getByTotalAmount(BigDecimal totalAmount) {
        return bookingDao.getByTotalAmount(totalAmount);
    }
}
