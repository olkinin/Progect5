package Hibernate;

import org.hibernate.Session;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    SessionFactoryUtils sf;

    StudentDaoImpl(SessionFactoryUtils sf) {
        this.sf = sf;
    }

    @Override
    public Student findById(Long id) {
        Session session = sf.getSession();
        session.beginTransaction();
        session.getTransaction();
        Student s = session.get(Student.class, id);
        System.out.println(s);
        session.getTransaction().commit();
        return s;
    }

    @Override
    public void deleteStudent(Long id) {
        Session session = sf.getSession();
        session.beginTransaction();
        Student s = session.load(Student.class, id);
        System.out.println("Студент " + s + " удален");
        session.getTransaction().commit();

    }

    @Override
    public void addStudent(Student student) {
        Session session = sf.getSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
    }

    @Override
    public List<Student> findAll() {
        Session session = sf.getSession();
        session.beginTransaction();
        List<Student> s;
        s = session.createQuery("select s from Student s ").getResultList();
        System.out.println(s);
        session.getTransaction().commit();
        return s;

    }
}