package org.example.q2.service.impl;

import org.example.q2.entity.Teacher;
import org.example.q2.repository.TeacherRepository;
import org.example.q2.service.TeacherService;

public class TeacherServiceImpl extends PersonServiceImpl<Teacher, TeacherRepository> implements TeacherService {
    public TeacherServiceImpl(TeacherRepository personRepository) {
        super(personRepository);
    }

    @Override
    public Teacher signUp(String firstName, String lastName, Integer teacherNumber) {
        if (!personRepository.contains(firstName,lastName)){
            Teacher teacher = new Teacher();
            teacher.setFirstName(firstName);
            teacher.setLastName(lastName);
            teacher.setTeacherNumber(teacherNumber);
            personRepository.save(teacher);
            return teacher;
        }
        return null;
    }
}
