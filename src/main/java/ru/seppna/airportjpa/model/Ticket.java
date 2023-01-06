package ru.seppna.airportjpa.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = "booking")
@Table(name="tickets")
//Билеты
public class Ticket {
    @Id
    @Column(name="ticket_no")
    private String ticketNumber;
    @ManyToOne                    //отношение с таблицей Booking
    @JoinColumn(name="book_ref")  //по какому полю будет сопоставление билетов с бронью
    private Booking booking;      //поле указ. на класс Booking

    @Column(name="passender_id")
    private String passengerId;
    @Column(name="passenger_name")
    private String passengerName;
    @Column(name="contact_date")
    private String contactDate;
    @Transient
    //вычисляемое поле
    private String fullPassengerInfo;
}
