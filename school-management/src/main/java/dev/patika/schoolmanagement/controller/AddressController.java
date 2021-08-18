package dev.patika.schoolmanagement.controller;

import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.model.Instructor;
import dev.patika.schoolmanagement.model.Student;
import dev.patika.schoolmanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Address>> allAddress(){

        return  new ResponseEntity<>(addressService.findAllAddress(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> addressById(@PathVariable int id){

        return new ResponseEntity<>(addressService.findAddressById(id),HttpStatus.OK);

    }

    @GetMapping("/students/{id}")
    public ResponseEntity<List<Student>> addressStudents(@PathVariable int id){

        return new ResponseEntity<>(addressService.studentsOfAddress(id),HttpStatus.ACCEPTED);

    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<List<Instructor>> addressInstructor(@PathVariable int id){

        return new ResponseEntity<>(addressService.instructorOfAddress(id),HttpStatus.ACCEPTED);
    }

    @PostMapping("/save")
    public ResponseEntity<Address> addressSave(@RequestBody Address address){

        return new ResponseEntity<>(addressService.saveAddress(address),HttpStatus.ACCEPTED);

    }

    @PutMapping("/update/{id}")
    public void addressUpdate(@RequestBody Address address, @PathVariable int id){

        addressService.updateAddress(address,id);
        System.out.println("Data Updated......");

    }

    @DeleteMapping("/delete")
    public void addressDelete(@RequestBody Address address){

        addressService.deleteAddress(address);
        System.out.println("Data Deleted......");

    }

    @DeleteMapping("/delete/{id}")
    public void addressDeleteWithId(@PathVariable int id){

        addressService.deleteAddressById(id);
        System.out.println("id = " + id + " ,Data Deleted.....");

    }

}
