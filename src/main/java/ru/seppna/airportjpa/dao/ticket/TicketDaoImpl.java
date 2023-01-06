package ru.seppna.airportjpa.dao.ticket;

import org.hibernate.tuple.entity.BytecodeEnhancementMetadataNonPojoImpl;
import org.springframework.stereotype.Repository;
import ru.seppna.airportjpa.dao.ticket.TicketDao;
import ru.seppna.airportjpa.model.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {
    //здесь имплементируем методы наведя мышку на слово implements
    //запрос на языке JPQL (Booking-это имя нашей сущности)
    private static final String GET_ALL= "SELECT t FROM Ticket t";
    @PersistenceContext
    //предоставляет методы для работы с нашими сущностями-сохранение, получение..
    private EntityManager entityManager;

    @Override
    public List<Ticket> getAll() {
        //здесь у entityManager нет готового метода, пишим запрос
        //объект типа Query из persistence
        Query query=entityManager.createQuery(GET_ALL);
        return query.getResultList();
    }

    @Override
    public Ticket getByTicketNumber(String ticketNumber) {

        return entityManager.find(Ticket.class,ticketNumber);
    }

    @Override
    @Transactional
    public void deleteByTicketNumber(String ticketNumber) {
        //сначало надо сущность вытащить, вдруг ее там нет
        Ticket ticket=entityManager.find(Ticket.class,ticketNumber);
        entityManager.remove(ticket);
    }

    @Override
    @Transactional
    public Ticket update(Ticket ticket) {
        entityManager.merge(ticket);
        return ticket;
    }

    @Override
    @Transactional
    public Ticket create(Ticket ticket) {
        entityManager.persist(ticket);
        return ticket;
    }
}
