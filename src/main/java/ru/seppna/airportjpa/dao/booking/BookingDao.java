package ru.seppna.airportjpa.dao.booking;
import ru.seppna.airportjpa.model.Booking;

import java.math.BigDecimal;
import java.util.List;

public interface BookingDao {
    //накидываем методы кот хотели бы иметь
    List<Booking> getAll();

    //поиск по id
    Booking getByBookRef(String book_ref);

    void delete(String book_ref);

    Booking update(Booking booking);

    Booking create(Booking booking);

    List<Booking> getByTotalAmount(BigDecimal totalAmount);

}
