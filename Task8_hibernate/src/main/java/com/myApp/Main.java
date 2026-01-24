package com.myApp;

import com.myApp.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

            // Begin transaction
            session.beginTransaction();

            // Retrieve object
            Student student = session.get(Student.class, 2);

            if (student != null) {
                session.delete(student);
                System.out.println("Student deleted successfully");
            } else {
                System.out.println("Student not found");
            }

            // Commit
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
            sessionFactory.close();
        }
    }
}
