package org.example.q2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.q2.entity.enumaratin.Degree;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher_tbl")
public class Teacher extends Person{
    public static final String TABLE_NAME = "Teacher";
    private Integer teacherNumber;

    private String degreeOfEducation;

    private Long salary;

    private Degree degree;
}
