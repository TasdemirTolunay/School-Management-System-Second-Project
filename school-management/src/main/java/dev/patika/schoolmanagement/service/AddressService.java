package dev.patika.schoolmanagement.service;

import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.model.Instructor;
import dev.patika.schoolmanagement.model.Student;
import dev.patika.schoolmanagement.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return addressRepository.findById(id).get();

    }

    public Address saveAddress(Address address){

        return addressRepository.save(address);

    }

    public void deleteAddress(Address address){

        addressRepository.delete(address);

    }

    public void deleteAddressById(int id){

        addressRepository.deleteById(id);

    }

    public void updateAddress(Address address, int id){

        Address findAddress = findAddressById(id);
        findAddress.setCountry(address.getCountry());
        findAddress.setCity(address.getCity());
        findAddress.setPlateCode(address.getPlateCode());
        addressRepository.save(findAddress);

    }

    public List<Student> studentsOfAddress(int id){

        return findAddressById(id).getStudentList();

    }

    public List<Instructor> instructorOfAddress(int id){

        return findAddressById(id).getInstructorList();

    }

}
