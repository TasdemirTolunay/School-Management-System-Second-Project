package dev.patika.schoolmanagement.Entity;

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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseName;
    private String courseCode;
    private double courseCreditScore;

    @ManyToMany
    private List<Student> students = new ArrayList<>();

    @ManyToOne
    private Instructor instructor;
}
