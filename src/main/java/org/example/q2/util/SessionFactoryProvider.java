package org.example.q2.util;

import org.example.q2.entity.Person;
import org.example.q2.entity.Student;
import org.example.q2.entity.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryProvider {
    private static final SessionFactory sessionFactory ;
    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Student.class)
                .buildMetadata()
                .buildSessionFactory();

    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
