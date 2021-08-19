package dev.patika.schoolmanagement.dao;

import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.repository.CourseRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOHibernate implements CourseRepository<Course> {

    private EntityManager entityManager;

    public CourseDAOHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {

        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Course", Course.class).getResultList();

    }

    @Override
    public Course findById(int id) {

        Session session = entityManager.unwrap(Session.class);
        return session.find(Course.class,id);

    }

    @Override
    public Course save(Course course) {

        Session session = entityManager.unwrap(Session.class);
        return (Course) session.merge(course);

    }

    @Override
    public void delete(Course course) {

        Session session = entityManager.unwrap(Session.class);
        Course findCourse = session.createQuery("from Course c where c.id =: id", Course.class).setParameter("id", course.getId()).getSingleResult();
        session.remove(findCourse);

    }

    @Override
    public void deleteById(int id) {

        Session session = entityManager.unwrap(Session.class);
        Course findCourse = session.find(Course.class, id);
        session.remove(findCourse);

    }

    @Override
    public void update(Course course, int id) {

        Session session = entityManager.unwrap(Session.class);
        Course findCourse = session.find(Course.class, id);
        findCourse.setCourseName(course.getCourseName());
        findCourse.setCourseCode(course.getCourseCode());
        findCourse.setCourseCreditScore(course.getCourseCreditScore());
        session.merge(findCourse);

    }

}
