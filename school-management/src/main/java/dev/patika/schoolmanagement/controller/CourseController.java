package dev.patika.schoolmanagement.controller;

import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.model.Instructor;
import dev.patika.schoolmanagement.model.Student;
import dev.patika.schoolmanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller class
@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {

        this.courseService = courseService;

    }

    //Shows the course list
    @GetMapping("/list")
    public ResponseEntity<List<Course>> findAllCourses(){

        return new ResponseEntity<>(courseService.courseList(),HttpStatus.OK);

    }

    //Shows the course of the entered ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id){

        return new ResponseEntity<>(courseService.findCourseById(id),HttpStatus.OK);

    }

    //Shows students registered to the course with the entered ID
    @GetMapping("/students/{id}")
    public ResponseEntity<List<Student>> studentsOfCourse(@PathVariable int id){

        return new ResponseEntity<>(courseService.studentsOfCourse(id),HttpStatus.ACCEPTED);

    }

    //Shows instructors registered to the course with the entered ID
    @GetMapping("/instructor/{id}")
    public ResponseEntity<Instructor> instructorOfCourse(@PathVariable int id){

        return new ResponseEntity<>(courseService.instructorOfCourse(id),HttpStatus.ACCEPTED);

    }

    //New course information is created
    @PostMapping("/save")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){

        return new ResponseEntity<>(courseService.saveCourse(course),HttpStatus.CREATED);

    }

    //Course information update of the entered ID
    @PutMapping("/update/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable int id){

        courseService.updateCourse(course,id);

    }

    //Assigns the student to a course
    @PutMapping("/set/student/{courseId}/{studentId}")
    public void setStudentCourse(@PathVariable int courseId,@PathVariable int studentId){

        courseService.setStudentOfCourse(courseId,studentId);

    }

    ////Assigns the instructor to a course
    @PutMapping("/set/instructor/{courseId}/{instructorId}")
    public void setInstructorCourse(@PathVariable int courseId, @PathVariable int instructorId){

        courseService.setInstructorOfCourse(courseId,instructorId);

    }

    //Delete course information
    @DeleteMapping("/delete")
    public void deleteCourse(@RequestBody Course course){

        courseService.deleteCourse(course);

    }

    //Delete course information with id
    @DeleteMapping("/delete/{id}")
    public void deleteCourseById(@PathVariable int id){

        courseService.deleteCourseById(id);

    }

}
