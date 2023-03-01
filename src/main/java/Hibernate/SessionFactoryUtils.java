package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils {
    private static SessionFactory sf;
   // private SessionFactory sf;

    public void init() {
        sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static Session getSession() {
        return sf.getCurrentSession();
    }

    public void shotdown() {
        if (sf != null) {
            sf.close();
        }
    }

}
