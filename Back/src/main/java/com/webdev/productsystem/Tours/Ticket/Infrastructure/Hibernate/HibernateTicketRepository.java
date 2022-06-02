package com.webdev.productsystem.Tours.Ticket.Infrastructure.Hibernate;

import com.webdev.productsystem.Shared.Infrastruture.Hibernate.HibernateRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class HibernateTicketRepository extends HibernateRepository<Tickets> implements TicketRepository {
    public HibernateTicketRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Tickets.class);
    }

    @Override
    public void save(Tickets ticket) {
        System.out.println(ticket.data());
        persist(ticket);
    }

    @Override
    public void update(Tickets ticket) {

    }

    @Override
    public void delete(Tickets ticket) {

    }

    @Override
    public Optional<Tickets> find(TicketId id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Tickets>> all() {
        return getAll();
    }
}
