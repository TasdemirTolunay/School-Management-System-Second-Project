package dev.patika.schoolmanagement.service;

import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.model.Instructor;
import dev.patika.schoolmanagement.model.Student;
import dev.patika.schoolmanagement.repository.CourseRepository;
import dev.patika.schoolmanagement.repository.InstructorRepository;
import dev.patika.schoolmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//This class contains methods of transaction on the course.
@Service
public class CourseService {

    CourseRepository courseRepository;

    StudentRepository studentRepository;

    InstructorRepository instructorRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository, InstructorRepository instructorRepository) {

        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.instructorRepository =instructorRepository;

    }

    public List<Course> courseList(){

        return courseRepository.findAll();

    }

    public Course findCourseById(int id){

        return (Course) courseRepository.findById(id);

    }

    public Course saveCourse(Course course){

        return (Course) courseRepository.save(course);

    }

    public void deleteCourse(Course course){

        courseRepository.delete(course);

    }

    public void deleteCourseById(int id){

        courseRepository.deleteById(id);

    }

    public void updateCourse(Course course, int id){

        courseRepository.update(course, id);

    }

    public List<Student> studentsOfCourse(int id){

        return findCourseById(id).getStudents();

    }

    public Instructor instructorOfCourse(int id){

        return findCourseById(id).getInstructor();

    }

    @Transactional
    public void setStudentOfCourse(int courseId, int studentId){

        Student findStudent = (Student) studentRepository.findById(studentId);
        Course findCourse = findCourseById(courseId);
        findCourse.getStudents().add(findStudent);
        courseRepository.update(findCourse,courseId);

    }

    @Transactional
    public void setInstructorOfCourse(int courseId, int instructorId){

        Instructor findInstructor = (Instructor) instructorRepository.findById(instructorId);
        Course findCourse = findCourseById(courseId);
        findCourse.setInstructor(findInstructor);
        courseRepository.update(findCourse, courseId);

    }

}
