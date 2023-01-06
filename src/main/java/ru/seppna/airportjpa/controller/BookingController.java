package ru.seppna.airportjpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.seppna.airportjpa.model.Booking;
import ru.seppna.airportjpa.service.booking.BookingService;

import java.math.BigDecimal;
import java.util.List;

@RestController //возврат не странички, а данных в JSON формате
//задать методам контроллера адреса, по которым они будут доступны на клиенте
@RequestMapping(BookingController.PATH)
@RequiredArgsConstructor //для создания конструктора с final полями

public class BookingController {
    //заводим поле, соответствующее нашему Mapping
    public static final String PATH="/booking/";
    //создаем сервис-внедряем бин,кот.будет содержать бизнес-логику для работы с Booking
    private final BookingService bookingService;

    @GetMapping
    public List<Booking> getAll(){

        return bookingService.getAll();
    }

    @GetMapping(value = "{bookRef}")
    public Booking getByBookRef(@PathVariable String bookRef){
        return bookingService.getByBookRef(bookRef);
    }

    @DeleteMapping(value = "{bookRef}")
    public void delete(@PathVariable String bookRef){
        bookingService.delete(bookRef);
    }
    @PatchMapping
    public Booking update(@RequestBody Booking booking){ //RequestBody-объект будет передан в теле http запроса
        return  bookingService.update(booking);
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking){ //RequestBody-объект будет передан в теле http запроса
        return  bookingService.create(booking);
    }

    @GetMapping(value = "total-amount/")
    public List<Booking> getByTotalAmount(@RequestParam BigDecimal totalAmount){
        return bookingService.getByTotalAmount(totalAmount);
    }


}
