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

@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {

        this.courseService = courseService;

    }

    @GetMapping("/list")
    public ResponseEntity<List<Course>> findAllCourses(){

        return new ResponseEntity<>(courseService.courseList(),HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id){

        return new ResponseEntity<>(courseService.findCourseById(id),HttpStatus.OK);

    }

    @GetMapping("/students/{id}")
    public ResponseEntity<List<Student>> studentsOfCourse(@PathVariable int id){

        return new ResponseEntity<>(courseService.studentsOfCourse(id),HttpStatus.ACCEPTED);

    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<Instructor> instructorOfCourse(@PathVariable int id){

        return new ResponseEntity<>(courseService.instructorOfCourse(id),HttpStatus.ACCEPTED);

    }

    @PostMapping("/save")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){

        return new ResponseEntity<>(courseService.saveCourse(course),HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable int id){

        courseService.updateCourse(course,id);

    }

    @PutMapping("/set/student/{courseId}/{studentId}")
    public void setStudentCourse(@PathVariable int courseId,@PathVariable int studentId){

        courseService.setStudentOfCourse(courseId,studentId);

    }

    @PutMapping("/set/instructor/{courseId}/{instructorId}")
    public void setInstructorCourse(@PathVariable int courseId, @PathVariable int instructorId){

        courseService.setInstructorOfCourse(courseId,instructorId);

    }

    @DeleteMapping("/delete")
    public void deleteCourse(@RequestBody Course course){

        courseService.deleteCourse(course);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourseById(@PathVariable int id){

        courseService.deleteCourseById(id);

    }

}
