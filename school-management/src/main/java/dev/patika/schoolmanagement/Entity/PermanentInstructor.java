package dev.patika.schoolmanagement.Entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PermanentInstructor extends Instructor{

    private double fixedSalary;
}
