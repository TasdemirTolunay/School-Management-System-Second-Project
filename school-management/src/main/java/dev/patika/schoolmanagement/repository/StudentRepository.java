package dev.patika.schoolmanagement.repository;


import dev.patika.schoolmanagement.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Qualifier("studentRepo")
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


}
