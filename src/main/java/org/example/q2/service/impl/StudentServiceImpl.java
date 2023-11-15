package org.example.q2.service.impl;

import org.example.q2.entity.Person;
import org.example.q2.entity.Student;
import org.example.q2.repository.PersonRepository;
import org.example.q2.repository.StudentRepository;
import org.example.q2.service.StudentService;

public class StudentServiceImpl extends PersonServiceImpl<Student, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository personRepository) {
        super(personRepository);
    }

    @Override
    public Student signUp(String firstName, String lastName, Integer studentNumber) {
        if (!personRepository.contains(firstName,lastName)){
            Student student = new Student();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setStudentNumber(studentNumber);
            personRepository.save(student);
            return student;
        }
        return null;
    }
}
