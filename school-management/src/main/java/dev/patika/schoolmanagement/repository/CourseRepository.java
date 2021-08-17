package dev.patika.schoolmanagement.repository;

import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.model.Instructor;
import dev.patika.schoolmanagement.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {

    Course findCoursesByName(String courseName);
    Course findCourseByCode(String courseCode);
    List<Course> findCoursesByCreditScore(double courseCreditScore);
    List<Student> findStudentsOfCourseId(int id);
    Instructor findInstructorOfCourseId(int id);

}
