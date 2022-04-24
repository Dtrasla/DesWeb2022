package com.webdev.productsystem.Tours.Ticket.Domain.Infrastructure.Hibernate;

import com.webdev.productsystem.Shared.Infrastruture.Hibernate.HibernateRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class HibernateTicketRepository extends HibernateRepository<Tickets> implements TicketRepository {

    public HibernateTicketRepository(SessionFactory sessionFactory, Class<Tickets> aggregateClass) {
        super(sessionFactory, aggregateClass);
    }

    @Override
    public void save(Tickets ticket) {

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
        return Optional.empty();
    }
}
