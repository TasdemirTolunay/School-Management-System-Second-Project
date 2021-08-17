package dev.patika.schoolmanagement.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VisitingResearcher extends Instructor{

    private double hourlySalary;
}
