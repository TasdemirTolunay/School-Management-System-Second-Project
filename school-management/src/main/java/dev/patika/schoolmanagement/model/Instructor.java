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
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String instructorName;
    private String instructorPhoneNumber;

    @ManyToOne
    private Address address;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList = new ArrayList<>();
}
