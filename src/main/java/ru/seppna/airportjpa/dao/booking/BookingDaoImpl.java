package ru.seppna.airportjpa.dao.booking;

import org.springframework.stereotype.Repository;
import ru.seppna.airportjpa.model.Booking;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class BookingDaoImpl implements BookingDao {
    //запрос на языке JPQL (Booking-это имя нашей сущности)
    private static final String GET_ALL= "SELECT b FROM Booking b";
    private  static  final String GET_BY_TOTAL_AMOUNT="SELECT b from Booking where b.totalAmount=:totalAmount";
    @PersistenceContext
    //предоставляет методы для работы с нашими сущностями-сохранение, получение..
    private EntityManager entityManager;

    @Override
    public List<Booking> getAll() {
        //здесь у entityManager нет готового метода, пишим запрос
        //объект типа Query из persistence
        Query query=entityManager.createQuery(GET_ALL);
        return query.getResultList();
    }

    @Override
    public Booking getByBookRef(String book_ref) {
        return entityManager.find(Booking.class,book_ref);
    }

    @Override
    @Transactional
    public void delete(String book_ref) {
        Booking booking=entityManager.find(Booking.class,book_ref);
        entityManager.remove(booking);
        entityManager.flush();
    }

    @Override
    @Transactional
    public Booking update(Booking booking) {
        entityManager.merge(booking);
        return booking;
    }

    @Override
    @Transactional
    public Booking create(Booking booking) {
        entityManager.persist(booking);
        return booking;
    }

    @Override
    public List<Booking> getByTotalAmount(BigDecimal totalAmount) {
        Query query= entityManager.createQuery(GET_BY_TOTAL_AMOUNT);
        query.setParameter("totalAmount",totalAmount);
        return query.getResultList();
    }
}
