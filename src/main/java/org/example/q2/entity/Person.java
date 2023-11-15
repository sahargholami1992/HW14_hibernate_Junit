package org.example.q2.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "person_tbl")
public class Person {
    public final static String TABLE_NAME = "Person";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   @NotBlank(message = "first name not empty")
   private String firstName;
    @NotBlank(message = "last name not empty")
    private String lastName;

   private Date birthDay;

}
