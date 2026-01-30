package myApp;


import myApp.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

            // Begin transaction
            session.beginTransaction();

            List<Product> products =
                    session.createQuery("FROM Product", Product.class).list();

            System.out.println("____________________All products___________________________");
            products.forEach(System.out::println);
            System.out.println("_________________________________________________");


            List<Product> paginatesUsers = session.createQuery("FROM Product", Product.class)
                    .setFirstResult(1).setMaxResults(4).list();
            System.out.println("____________________Paginated products________________________");
            paginatesUsers.forEach(System.out::println);
            System.out.println("_________________________________________________");


            Query<Product> query =
                    session.createQuery(
                            "FROM Product WHERE manufacturer = :man",
                            Product.class);

            query.setParameter("man", "ManufacturerA");
            System.out.println("________________Select products with manufacturer = ManufacturerA ___________");
            query.list().forEach(System.out::println);
            System.out.println("_________________________________________________");

            System.out.println("__________________________Update __________________");
            Query updateQuery =
                    session.createQuery(
                            "UPDATE Product SET price = price + 10 WHERE id = :id");

            updateQuery.setParameter("id", "1");
            int updated = updateQuery.executeUpdate();
            System.out.println("_________________________________________________");

            System.out.println("Updated rows: " + updated);

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
