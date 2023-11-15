package org.example.q2.service;

import org.example.q2.entity.Person;
import org.example.q2.entity.Student;

public interface StudentService extends PersonService<Student>{
    Student signUp(String firstName, String lastName,Integer studentNumber);
}
