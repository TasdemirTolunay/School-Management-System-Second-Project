package dev.patika.schoolmanagement.repository;

import dev.patika.schoolmanagement.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {


}
