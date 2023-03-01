package Hibernate;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtils factory = new SessionFactoryUtils();
        factory.init();
        Session session = factory.getSession();
        try {
            StudentDao studentDao = new StudentDaoImpl(factory);
            studentDao.findById(2l);
            System.out.println(studentDao);
            studentDao.findAll();
            studentDao.deleteStudent(15L);
            studentDao.addStudent(new Student("Домасевич Ирина", 9));
             System.out.println(studentDao);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.shotdown();
        }


    }
}
