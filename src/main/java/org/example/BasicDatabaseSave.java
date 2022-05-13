package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BasicDatabaseSave {
    public static void main(String[] args) {


        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
//
//        Book book1 = new Book();
//        book1.setTitle("Hobbit");
//        book1.setAuthor("J.R.R. Tolkien");
//        book1.setReleaseYear(1968);
//        book1.setNumberOfPages(287);
//
//        session.save(book1);
//
//        transaction.commit();




        session.close();
        sessionFactory.close();

    }




}
