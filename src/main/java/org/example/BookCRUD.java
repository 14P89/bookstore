package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookCRUD {

    private SessionFactory sessionFactory;

    public BookCRUD() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
    }

    public Integer saveBook(Book book) {
        Session session = null;
        Integer id = null;

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            id = (Integer)  session.save(book);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public void run() {
        Book book2 = new Book("Ogniem i Mieczem", "Henryk Sienkiewicz", 1921, 625);

        Integer newID = saveBook(book2);
        System.out.println(newID);
    }



    public static void main(String[] args) {

        BookCRUD bookCRUD = new BookCRUD();
        bookCRUD.run();
    }
}
