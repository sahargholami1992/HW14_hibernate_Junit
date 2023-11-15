package org.example.q2.repository.impl;

import org.example.q2.entity.Person;
import org.example.q2.repository.PersonRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import java.util.List;

public class PersonRepositoryImpl<T extends Person> implements PersonRepository<T> {
    Session session;

    public PersonRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(T person) {
        try {
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @Override
    public void delete(Integer id) {
        //String hql = "delete from Person WHERE id=:id";
        try {
//            session.beginTransaction();
//            Query query = session.createQuery(hql);
//            query.setParameter("id",id);
//            query.executeUpdate();
//            session.getTransaction().commit();
//            session.close();
            T person = session.get(getEntityClass(), id);
            if (person != null) {
                session.getTransaction().begin();
                session.remove(person);
                session.getTransaction().commit();
            }
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(T person, Integer id) {
        String hql = "UPDATE "+getEntityTableName()+" p SET p.birthDay=:birthDay WHERE p.id=:id";
        try {
            session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("birthDay",person.getBirthDay());
            query.setParameter("id",id);
            query.executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }


    }

    @Override
    public List<T> loadAll() {
        String hql = "SELECT p FROM "+getEntityTableName()+" p";
        Query<T> query = session.createQuery(hql, getEntityClass());
        return query.list();
        }



    @Override
    public boolean contains(String firstName, String lastName) {
        String hql = "select count(p) from "+getEntityTableName()+" p WHERE p.firstName =:firstName AND p.lastName =:lastName";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("firstName",firstName);
        query.setParameter("lastName",lastName);
        Long number = query.uniqueResult();
        return number>0;
    }

    @Override
    public T findById(Integer id) {
        String hql = "SELECT p FROM "+getEntityTableName()+" p where p.id=:id";
        Query<T> query = session.createQuery(hql, getEntityClass());
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public String getEntityTableName() {
        return Person.TABLE_NAME;
    }

    @Override
    public Class<T> getEntityClass() {
        return (Class<T>) Person.class;
    }

}
