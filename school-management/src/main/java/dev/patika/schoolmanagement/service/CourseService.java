package dev.patika.schoolmanagement.service;

import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.model.Instructor;
import dev.patika.schoolmanagement.model.Student;
import dev.patika.schoolmanagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> courseList(){

        return courseRepository.findAll();

    }

    public Course findCourseById(int id){

        return courseRepository.findById(id).get();

    }

    public Course saveCourse(Course course){

        return courseRepository.save(course);

    }

    public void deleteCourse(Course course){

        courseRepository.delete(course);

    }

    public void deleteCourseById(int id){

        courseRepository.deleteById(id);

    }

    public void updateCourse(Course course, int id){

        Course findCourse = findCourseById(id);
        findCourse.setCourseName(course.getCourseName());
        findCourse.setCourseCode(course.getCourseCode());
        findCourse.setCourseCreditScore(course.getCourseCreditScore());
        courseRepository.save(findCourse);

    }

    public List<Student> studentsOfCourse(int id){

        return findCourseById(id).getStudents();

    }

    public Instructor instructorOfCourse(int id){

        return findCourseById(id).getInstructor();

    }
}
