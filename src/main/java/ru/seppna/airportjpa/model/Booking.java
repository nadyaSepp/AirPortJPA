package ru.seppna.airportjpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@ToString(exclude = "tickets") //исключаем из работы метода toString поле tickets,чтобы избежать StackOverflowError
@Table(name="booking")
//Бронирование
public class Booking {
    @Id
    @Column(name="book_ref")
    private String bookRef;
    @Column(name="book_date")
    private Date bookDate;
    @Column(name="total_amount")
    private BigDecimal totalAmount;
    @JsonIgnore //игнорировать создание вида Json,чтоб не было зацикливания
    //mappedBy="booking" - по какому полю с tickets сопоставление будет,
    //cascade - задаем и каскадное удаление связанных Ticketov (.ALL или .Remove ....)
    @OneToMany(mappedBy="booking",cascade = CascadeType.ALL)
    List<Ticket> tickets=new ArrayList<>();

}
