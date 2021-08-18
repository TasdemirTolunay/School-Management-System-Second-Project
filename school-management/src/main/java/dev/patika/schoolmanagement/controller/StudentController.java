package dev.patika.schoolmanagement.controller;


import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.model.Student;
import dev.patika.schoolmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> findAllStudent(){

        return new ResponseEntity<>(studentService.findAllStudent(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable int id){

        return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.OK);

    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<List<Course>> findCoursesOfStudent(@PathVariable int id){

        return new ResponseEntity<>(studentService.findCourseOfStudent(id), HttpStatus.ACCEPTED);

    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> findAddressOfStudent(@PathVariable int id){

        return new ResponseEntity<>(studentService.findAddressOfStudent(id),HttpStatus.ACCEPTED);

    }

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){

        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public void updateToStudent(@RequestBody Student student, @PathVariable int id){

        studentService.updateStudent(student,id);

    }

    @PutMapping("/set/address/{studentId}/{addressId}")
    public void setAddressStudent(@PathVariable int studentId, @PathVariable int addressId){

        studentService.setAddressOfStudent(studentId,addressId);

    }

    @DeleteMapping("/delete")
    public void deleteStudentOfObject(@RequestBody Student student){

        studentService.deleteStudent(student);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable int id){

        studentService.deleteStudentById(id);

    }

}
