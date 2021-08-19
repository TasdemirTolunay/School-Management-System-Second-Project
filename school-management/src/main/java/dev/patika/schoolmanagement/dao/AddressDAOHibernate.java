package dev.patika.schoolmanagement.dao;

import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.repository.AddressRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AddressDAOHibernate implements AddressRepository<Address> {

    private EntityManager entityManager;

    public AddressDAOHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Address> findAll() {

        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Address", Address.class).getResultList();

    }

    @Override
    public Address findById(int id) {

        Session session = entityManager.unwrap(Session.class);
        return session.find(Address.class, id);

    }

    @Override
    public Address save(Address address) {

        Session session = entityManager.unwrap(Session.class);
        return (Address) session.merge(address);
    }

    @Override
    public void delete(Address address) {

        Session session = entityManager.unwrap(Session.class);
        Address findAddress = session.createQuery("from Address a where a.id =: id",Address.class).setParameter("id", address.getId()).getSingleResult();
        session.remove(findAddress);

    }

    @Override
    public void deleteById(int id) {

        Session session = entityManager.unwrap(Session.class);
        Address findAddres = session.find(Address.class, id);
        session.remove(findAddres);

    }

    @Override
    public void update(Address address, int id) {

        Session session = entityManager.unwrap(Session.class);
        Address findAddress = session.find(Address.class, id);
        findAddress.setCountry(address.getCountry());
        findAddress.setCity(address.getCity());
        findAddress.setPlateCode(address.getPlateCode());
        session.merge(findAddress);

    }
}
