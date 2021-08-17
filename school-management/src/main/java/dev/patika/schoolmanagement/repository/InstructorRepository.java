package dev.patika.schoolmanagement.repository;

import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.model.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Integer> {

    Instructor findInstructorByName(String instructorName);
    Instructor findInstructorByPhoneNumber(String instructorPhoneNumber);
    Address findAddressOfInstructorId(int id);
    List<Course> findCoursesOfInstructorId(int id);

}
