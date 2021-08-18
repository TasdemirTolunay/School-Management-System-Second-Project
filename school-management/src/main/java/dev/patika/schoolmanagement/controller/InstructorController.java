package dev.patika.schoolmanagement.controller;

import dev.patika.schoolmanagement.model.*;
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

    @PostMapping("/save/permanent")
    public ResponseEntity<Instructor> permanentInstructorSave(@RequestBody PermanentInstructor instructor){

        return new ResponseEntity<>(instructorService.savePermanentInstructor(instructor),HttpStatus.ACCEPTED);

    }

    @PostMapping("/save/visiting")
    public ResponseEntity<Instructor> visitingInstructorSave(@RequestBody VisitingResearcher instructor){

        return new ResponseEntity<>(instructorService.saveVisitingInstructor(instructor),HttpStatus.ACCEPTED);

    }

    @PutMapping("/update/{id}")
    public void instructorUpdate(@RequestBody Instructor instructor, @PathVariable int id){

        instructorService.updateInstructor(instructor, id);
        System.out.println("Data Updated.......");

    }

    @PutMapping("/set/address/{instructorId}/{addressId}")
    public void setAddressInstructor(@PathVariable int instructorId, @PathVariable int addressId){

        instructorService.setAddressOfInstructor(instructorId,addressId);

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
