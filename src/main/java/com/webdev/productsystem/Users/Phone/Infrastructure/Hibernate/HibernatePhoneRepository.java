package com.webdev.productsystem.Users.Phone.Infrastructure.Hibernate;

import com.webdev.productsystem.Shared.Infrastruture.Hibernate.HibernateRepository;
import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneId;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneNumber;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class HibernatePhoneRepository extends HibernateRepository<Phone> implements PhoneRepository {
    public HibernatePhoneRepository(SessionFactory sessionFactory, Class<Phone> aggregateClass) {
        super(sessionFactory, aggregateClass);
    }

    @Override
    public void save(Phone phone) {
        persist(phone);

    }

    @Override
    public void update(Phone phone) {
        super.updateEntity(phone);
    }

    @Override
    public Optional<Phone> findById(PhoneId phoneId) {
        return super.byId(phoneId);
    }

    @Override
    public Optional<Phone> findByNumber(PhoneNumber number) {
        Phone phone = null;
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Phone> cr = cb.createQuery(Phone.class);
        Root<Phone> root = cr.from(Phone.class);
        cr.select(root).where(cb.equal(root.get("PhoneNumber"), number));
        List<Phone> phones = sessionFactory.getCurrentSession().createQuery(cr).getResultList();
        if(!phones.isEmpty()) {
            phone = phones.get(0);
        }
        return Optional.ofNullable(phone);
    }

    @Override
    public Optional<List<Phone>> all() {
        return super.getAll();
    }

    @Override
    public void delete(Phone phone) {
        super.deleteEntity(phone);
    }
}
