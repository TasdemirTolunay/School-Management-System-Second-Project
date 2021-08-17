package dev.patika.schoolmanagement.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentName;
    private LocalDate studentBirthDate;
    private String Gender;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    @ManyToOne
    private Address address;


}
