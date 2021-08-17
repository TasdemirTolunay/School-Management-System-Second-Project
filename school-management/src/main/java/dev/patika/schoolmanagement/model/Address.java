package dev.patika.schoolmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String country;
    private String city;
    private String plateCode;


    @OneToMany(mappedBy = "address")
    private List<Student> studentList = new ArrayList<>();

    @OneToMany(mappedBy = "address")
    private List<Instructor> instructorList = new ArrayList<>();
}
