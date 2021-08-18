package dev.patika.schoolmanagement.service;

import dev.patika.schoolmanagement.model.*;
import dev.patika.schoolmanagement.repository.AddressRepository;
import dev.patika.schoolmanagement.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    InstructorRepository instructorRepository;

    AddressRepository addressRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository, AddressRepository addressRepository) {

        this.instructorRepository = instructorRepository;
        this.addressRepository = addressRepository;

    }

    public List<Instructor> instructorList(){

        return instructorRepository.findAll();

    }

    public Instructor findInstructorById(int id){

        return instructorRepository.findById(id).get();

    }

    public Instructor savePermanentInstructor(PermanentInstructor instructor){

        return instructorRepository.save(instructor);

    }

    public Instructor saveVisitingInstructor(VisitingResearcher instructor){

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

    public void setAddressOfInstructor(int instructorId, int addressId){

        Address findAddress = addressRepository.findById(addressId).get();
        Instructor findInstructor = findInstructorById(instructorId);
        findInstructor.setAddress(findAddress);
        instructorRepository.save(findInstructor);

    }

}
