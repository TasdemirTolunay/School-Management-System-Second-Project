package dev.patika.schoolmanagement.service;

import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.model.Student;
import dev.patika.schoolmanagement.repository.AddressRepository;
import dev.patika.schoolmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//This class contains methods of transaction on the student.
@Service
public class StudentService {

    private StudentRepository studentRepository;

    private AddressRepository addressRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, AddressRepository addressRepository) {

        this.studentRepository = studentRepository;
        this.addressRepository =addressRepository;
    }

    public List<Student> findAllStudent(){

        return studentRepository.findAll();

    }

    public Student findStudentById(int id){

        return (Student) studentRepository.findById(id);

    }

    public Student saveStudent(Student student){

        return (Student) studentRepository.save(student);

    }

    public void deleteStudent(Student student){

        studentRepository.delete(student);

    }

    public void deleteStudentById(int id){

        studentRepository.deleteById(id);

    }

    public void updateStudent(Student student, int id){

        studentRepository.update(student,id);

    }

    public List<Course> findCourseOfStudent(int id){

        return findStudentById(id).getCourses();

    }

    public Address findAddressOfStudent(int id){

        return findStudentById(id).getAddress();

    }

    @Transactional
    public void setAddressOfStudent(int studentId, int addressId){

        Address findAddress = (Address) addressRepository.findById(addressId);
        Student findStudent = findStudentById(studentId);
        findStudent.setAddress(findAddress);
        studentRepository.update(findStudent, studentId);

    }

}
