package dev.patika.schoolmanagement.repository;

import dev.patika.schoolmanagement.model.Address;
import dev.patika.schoolmanagement.model.Instructor;
import dev.patika.schoolmanagement.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer> {

    List<Address> findAddressesByCountry(String country);
    List<Address> findAddressesByPlateCode(String plateCode);
    List<Student> findStudentsOfCity(String city);
    List<Student> findStudentsOfAddressId(int id);
    List<Instructor> findInstructorOfAddressId(int id);

}
