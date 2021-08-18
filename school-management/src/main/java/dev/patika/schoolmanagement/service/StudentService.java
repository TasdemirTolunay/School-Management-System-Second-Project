package dev.patika.schoolmanagement.service;

import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.model.Student;
import dev.patika.schoolmanagement.repository.AddressRepository;
import dev.patika.schoolmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//This class contains methods of transaction on the student.
@Service
public class StudentService {

    StudentRepository studentRepository;

    AddressRepository addressRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, AddressRepository addressRepository) {

        this.studentRepository = studentRepository;
        this.addressRepository =addressRepository;
    }

    public List<Student> findAllStudent(){

        return studentRepository.findAll();

    }

    public Student findStudentById(int id){

        return  studentRepository.findById(id).get();

    }

    public Student saveStudent(Student student){

        return studentRepository.save(student);

    }

    public void deleteStudent(Student student){

        studentRepository.delete(student);

    }

    public void deleteStudentById(int id){

        studentRepository.deleteById(id);

    }

    public void updateStudent(Student student, int id){

        Student findStudent = findStudentById(id);
        findStudent.setStudentName(student.getStudentName());
        findStudent.setStudentGender(student.getStudentGender());
        findStudent.setStudentBirthDate(student.getStudentBirthDate());
        studentRepository.save(findStudent);

    }

    public List<Course> findCourseOfStudent(int id){

        return findStudentById(id).getCourses();

    }

    public Address findAddressOfStudent(int id){

        return findStudentById(id).getAddress();

    }

    public void setAddressOfStudent(int studentId, int addressId){

        Address findAddress = addressRepository.findById(addressId).get();
        Student findStudent = findStudentById(studentId);
        findStudent.setAddress(findAddress);
        studentRepository.save(findStudent);

    }

}
