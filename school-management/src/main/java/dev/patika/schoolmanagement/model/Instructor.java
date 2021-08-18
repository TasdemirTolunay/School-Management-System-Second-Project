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
public class Instructor {

    //This class have Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Variables
    private String instructorName;
    private String instructorPhoneNumber;

    //Relations with other classes
    @ManyToOne
    private Address address;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList = new ArrayList<>();
}
