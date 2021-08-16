package dev.patika.schoolmanagement.Entity;

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
