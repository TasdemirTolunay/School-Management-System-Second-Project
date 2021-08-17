package dev.patika.schoolmanagement.repository;

import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    Student findStudentsByName(String studentName);
    List<Student> findStudentsByGender(String studentGender);
    List<Course> findCoursesOfStudentId(int id);
    Address findAddressOfStudentId(int id);

}
