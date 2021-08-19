package dev.patika.schoolmanagement.service;

import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.model.Instructor;
import dev.patika.schoolmanagement.model.Student;
import dev.patika.schoolmanagement.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//This class contains methods of transaction on the address.
@Service
public class AddressService {

    AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAllAddress(){

        return addressRepository.findAll();

    }

    public Address findAddressById(int id){

        return (Address) addressRepository.findById(id);

    }

    @Transactional
    public Address saveAddress(Address address){

        return (Address) addressRepository.save(address);

    }

    @Transactional
    public void deleteAddress(Address address){

        addressRepository.delete(address);

    }

    @Transactional
    public void deleteAddressById(int id){

        addressRepository.deleteById(id);

    }

    @Transactional
    public void updateAddress(Address address, int id){

        addressRepository.update(address, id);

    }

    public List<Student> studentsOfAddress(int id){

        return findAddressById(id).getStudentList();

    }

    public List<Instructor> instructorOfAddress(int id){

        return findAddressById(id).getInstructorList();

    }

}
