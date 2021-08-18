package dev.patika.schoolmanagement.service;

import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.model.Instructor;
import dev.patika.schoolmanagement.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> instructorList(){

        return instructorRepository.findAll();

    }

    public Instructor findInstructorById(int id){

        return instructorRepository.findById(id).get();

    }

    public Instructor saveInstructor(Instructor instructor){

        return instructorRepository.save(instructor);

    }

    public void updateInstructor(Instructor instructor, int id){

        Instructor findInstructor = findInstructorById(id);
        findInstructor.setInstructorName(instructor.getInstructorName());
        findInstructor.setInstructorPhoneNumber(instructor.getInstructorPhoneNumber());
        instructorRepository.save(findInstructor);

    }

    public void deleteInstructor(Instructor instructor){

        instructorRepository.delete(instructor);

    }

    public void deleteInstructorById(int id){

        instructorRepository.deleteById(id);

    }

    public List<Course> coursesOfInstructor(int id){

        return findInstructorById(id).getCourseList();

    }

    public Address addressOfInstructor(int id){

        return findInstructorById(id).getAddress();

    }

}
