package dev.patika.schoolmanagement.service;

import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.model.Student;
import dev.patika.schoolmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(@Qualifier("studentRepo") StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public List<Student> findAllStudent(){

        return studentRepository.findAll();

    }


}
