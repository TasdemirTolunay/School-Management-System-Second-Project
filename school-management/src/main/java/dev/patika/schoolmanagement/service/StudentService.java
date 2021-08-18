package dev.patika.schoolmanagement.service;

import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.model.Student;
import dev.patika.schoolmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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

}
