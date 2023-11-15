package org.example.q2.repository.impl;

import org.example.q2.entity.Student;
import org.example.q2.repository.StudentRepository;
import org.hibernate.Session;

public class StudentRepositoryImpl extends PersonRepositoryImpl<Student> implements StudentRepository {
    public StudentRepositoryImpl(Session session) {
        super(session);
    }
    @Override
    public String getEntityTableName() {
        return Student.TABLE_NAME;
    }
    @Override
    public Class<Student> getEntityClass(){
        return Student.class;
    }
}
