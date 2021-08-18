package dev.patika.schoolmanagement.controller;

import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.model.Course;
import dev.patika.schoolmanagement.model.Instructor;
import dev.patika.schoolmanagement.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Instructor>> allInstructor(){

        return new ResponseEntity<>(instructorService.instructorList(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id){

        return new ResponseEntity<>(instructorService.findInstructorById(id),HttpStatus.OK);

    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<List<Course>> coursesOfInstructor(@PathVariable int id){

        return new ResponseEntity<>(instructorService.coursesOfInstructor(id),HttpStatus.ACCEPTED);

    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> addressOfInstructor(@PathVariable int id){

        return new ResponseEntity<>(instructorService.addressOfInstructor(id),HttpStatus.ACCEPTED);

    }

    @PostMapping("/save")
    public ResponseEntity<Instructor> instructorSave(@RequestBody Instructor instructor){

        return new ResponseEntity<>(instructorService.saveInstructor(instructor),HttpStatus.ACCEPTED);

    }

    @PutMapping("/save/{id}")
    public void instructorUpdate(@RequestBody Instructor instructor, @PathVariable int id){

        instructorService.updateInstructor(instructor, id);
        System.out.println("Data Updated.......");

    }

    @DeleteMapping("/delete")
    public void instructorDelete(@RequestBody Instructor instructor){

        instructorService.deleteInstructor(instructor);
        System.out.println("Data Deleted.....");

    }

    @DeleteMapping("/delete/{id}")
    public void instructorDeleteWithId(@PathVariable int id){

        instructorService.deleteInstructorById(id);
        System.out.println("id = " + id + " ,Data Deleted.....");

    }


}
