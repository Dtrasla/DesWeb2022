package com.webdev.productsystem.Users.Phone.Infrastructure.Adapters;

import com.webdev.productsystem.Shared.Infrastruture.Hibernate.HibernateRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneId;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneNumber;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Transactional
public class HibernatePhoneRepository extends HibernateRepository<Phone> implements PhoneRepository {

    public HibernatePhoneRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Phone.class);
    }

    @Override
    public void save(Phone phone) {
        persist(phone);
    }

    @Override
    public void update(Phone phone) {

    }

    @Override
    public void delete(Phone phone) {

    }

    @Override
    public Optional<Phone> findByNumber(PhoneNumber id) {
        return Optional.empty();
    }

    @Override
    public Optional<Phone> findById(PhoneId id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Phone>> all() {
        return getAll();
    }
}
