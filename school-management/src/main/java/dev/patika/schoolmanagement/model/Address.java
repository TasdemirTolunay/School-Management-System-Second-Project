package dev.patika.schoolmanagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//Entity class
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Address {

    //This class have Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Variables
    private String country;
    private String city;
    private String plateCode;


    //Relations with other classes
    @OneToMany(mappedBy = "address")
    private List<Student> studentList = new ArrayList<>();

    @OneToMany(mappedBy = "address")
    private List<Instructor> instructorList = new ArrayList<>();
}
