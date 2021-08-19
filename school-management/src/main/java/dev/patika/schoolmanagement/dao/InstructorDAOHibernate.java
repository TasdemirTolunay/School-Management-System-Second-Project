package dev.patika.schoolmanagement.dao;

import dev.patika.schoolmanagement.model.Instructor;
import dev.patika.schoolmanagement.repository.InstructorRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InstructorDAOHibernate implements InstructorRepository<Instructor> {

    private EntityManager entityManager;

    public InstructorDAOHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {

        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Instructor", Instructor.class).getResultList();

    }

    @Override
    public Instructor findById(int id) {

        Session session = entityManager.unwrap(Session.class);
        return session.find(Instructor.class, id);

    }

    @Override
    public Instructor save(Instructor instructor) {

        Session session = entityManager.unwrap(Session.class);
        return (Instructor) session.merge(instructor);

    }

    @Override
    public void delete(Instructor instructor) {

        Session session = entityManager.unwrap(Session.class);
        Instructor findInstructor = session.createQuery("from Instructor s where s.id =: id", Instructor.class).setParameter("id", instructor.getId()).getSingleResult();
        session.remove(findInstructor);

    }

    @Override
    public void deleteById(int id) {

        Session session = entityManager.unwrap(Session.class);
        Instructor findInstructor = session.find(Instructor.class, id);
        session.remove(findInstructor);

    }

    @Override
    public void update(Instructor instructor, int id) {

        Session session = entityManager.unwrap(Session.class);
        Instructor findIndstructor = findById(id);
        findIndstructor.setInstructorName(instructor.getInstructorName());
        findIndstructor.setInstructorPhoneNumber(instructor.getInstructorPhoneNumber());
        session.merge(findIndstructor);

    }
}
