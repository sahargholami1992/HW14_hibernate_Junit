package org.example.q2.repository.impl;


import org.example.q2.entity.Teacher;
import org.example.q2.repository.TeacherRepository;
import org.hibernate.Session;

public class TeacherRepositoryImpl extends PersonRepositoryImpl<Teacher> implements TeacherRepository {
    public TeacherRepositoryImpl(Session session) {
        super(session);
    }
    @Override
    public String getEntityTableName() {
        return Teacher.TABLE_NAME;
    }
    @Override
    public Class<Teacher> getEntityClass(){
        return Teacher.class;
    }
}
