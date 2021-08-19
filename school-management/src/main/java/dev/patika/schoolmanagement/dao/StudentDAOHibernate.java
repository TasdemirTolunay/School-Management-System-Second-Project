package dev.patika.schoolmanagement.dao;

import dev.patika.schoolmanagement.model.Student;
import dev.patika.schoolmanagement.repository.StudentRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOHibernate implements StudentRepository<Student> {

    private EntityManager entityManager;

    public StudentDAOHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {

        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Student",Student.class).getResultList();

    }

    @Override
    public Student findById(int id) {

        Session session = entityManager.unwrap(Session.class);
        return session.find(Student.class, id);

    }

    @Override
    public Student save(Student student) {

        Session session = entityManager.unwrap(Session.class);
        return (Student) session.merge(student);

    }

    @Override
    public void delete(Student student) {

        Session session = entityManager.unwrap(Session.class);
        Student findStudent = session.createQuery("from Student s where s.id =: id", Student.class).setParameter("id", student.getId()).getSingleResult();
        session.remove(findStudent);

    }

    @Override
    public void deleteById(int id) {

        Session session = entityManager.unwrap(Session.class);
        Student findStudent = session.find(Student.class, id);
        session.remove(findStudent);

    }

    @Override
    public void update(Student student, int id) {

        Session session = entityManager.unwrap(Session.class);
        Student findStudent = findById(id);
        findStudent.setStudentName(student.getStudentName());
        findStudent.setStudentGender(student.getStudentGender());
        findStudent.setStudentBirthDate(student.getStudentBirthDate());
        session.merge(findStudent);

    }

}
