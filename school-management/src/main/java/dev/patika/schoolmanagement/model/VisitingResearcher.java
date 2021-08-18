package dev.patika.schoolmanagement.model;

import lombok.*;

import javax.persistence.Entity;

//This class is a subclass of the instructor class
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VisitingResearcher extends Instructor{

    //Variables
    private double hourlySalary;

}
