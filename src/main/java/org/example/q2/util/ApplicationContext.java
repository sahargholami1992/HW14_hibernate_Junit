package org.example.q2.util;

import org.example.q2.repository.PersonRepository;
import org.example.q2.repository.StudentRepository;
import org.example.q2.repository.TeacherRepository;
import org.example.q2.repository.impl.PersonRepositoryImpl;
import org.example.q2.repository.impl.StudentRepositoryImpl;
import org.example.q2.repository.impl.TeacherRepositoryImpl;
import org.example.q2.service.PersonService;
import org.example.q2.service.StudentService;
import org.example.q2.service.TeacherService;
import org.example.q2.service.impl.PersonServiceImpl;
import org.example.q2.service.impl.StudentServiceImpl;
import org.example.q2.service.impl.TeacherServiceImpl;
import org.hibernate.Session;

public class ApplicationContext {
    private static Session session;
    private static final PersonRepository PERSON_REPOSITORY;
    private static final StudentRepository STUDENT_REPOSITORY;
    private static final TeacherRepository TEACHER_REPOSITORY;
    private static final PersonService PERSON_SERVICE;
    private static final StudentService STUDENT_SERVICE;
    private static final TeacherService TEACHER_SERVICE;
    static {
        session = SessionFactoryProvider.getSessionFactory().openSession();
        PERSON_REPOSITORY = new PersonRepositoryImpl(session);
        PERSON_SERVICE = new PersonServiceImpl(PERSON_REPOSITORY);
        STUDENT_REPOSITORY = new StudentRepositoryImpl(session);
        STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY);
        TEACHER_REPOSITORY = new TeacherRepositoryImpl(session);
        TEACHER_SERVICE = new TeacherServiceImpl(TEACHER_REPOSITORY);
    }

     public static PersonService getPersonService(){
        return PERSON_SERVICE;
    }
    public static StudentService getStudentService(){
        return STUDENT_SERVICE;
    }
    public static TeacherService getTeacherService(){
        return TEACHER_SERVICE;
    }



}
