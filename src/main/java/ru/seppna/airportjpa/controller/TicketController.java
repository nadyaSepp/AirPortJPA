package ru.seppna.airportjpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.seppna.airportjpa.model.Ticket;
import ru.seppna.airportjpa.service.ticket.TicketService;

import java.util.List;

@RestController
@RequestMapping(TicketController.PATH)
@RequiredArgsConstructor
public class TicketController {
    //обозначаем по какому пути будут мапится запросы для получения билетов
    public static final String PATH = "/ticket/";

    private final TicketService ticketService;

    @GetMapping
    public List<Ticket> getAll(){

        return ticketService.getAll();
    }

    //@GetMapping(value="ticketNumber")
    @GetMapping("{ticketNumber}")
    public Ticket getByTicketNumber(@PathVariable String ticketNumber){
        return ticketService.getByTicketNumber(ticketNumber);
    }



}
