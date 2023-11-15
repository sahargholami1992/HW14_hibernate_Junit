package org.example.q2.service;

import org.example.q2.entity.Person;
import org.example.q2.entity.Teacher;

public interface TeacherService extends PersonService<Teacher>{
    Teacher signUp(String firstName, String lastName, Integer teacherNumber);
}
