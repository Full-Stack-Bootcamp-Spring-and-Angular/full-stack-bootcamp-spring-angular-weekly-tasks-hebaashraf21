package myApp;

import myApp.model.Passport;
import myApp.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();

        Session session = null;
        int passportId;

        try {

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Passport passport = new Passport(
                    "A1",
                    LocalDate.of(2025, 12, 14)
            );

            Person person = new Person(
                    "H",
                    "A",
                    LocalDate.of(2000, 12, 14)
            );

            passport.setPersonId(person);
            person.setPassport(passport);

            session.save(passport);

            passportId = passport.getId();

            session.getTransaction().commit();
            session.close();


            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Passport dbPassport = session.get(Passport.class, passportId);

            System.out.println(dbPassport);
            System.out.println(dbPassport.getPersonId());
            System.out.println(dbPassport.getPersonId().getPassport());

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
            sessionFactory.close();
        }
    }
}
