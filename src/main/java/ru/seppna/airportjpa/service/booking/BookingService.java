package ru.seppna.airportjpa.service.booking;

import ru.seppna.airportjpa.model.Booking;

import java.math.BigDecimal;
import java.util.List;

public interface BookingService {
    List<Booking> getAll();

    Booking getByBookRef(String bookRef);

    void delete(String book_ref);

    Booking update(Booking booking);

    Booking create(Booking booking);

    List<Booking> getByTotalAmount(BigDecimal totalAmount);

}
