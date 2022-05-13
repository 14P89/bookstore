package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

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

    public Book getBook (Integer id) {
        Session session = null;
        Book book = null;

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            String hql = "FROM Book B WHERE B.id = " + id;
            Query query = session.createQuery(hql);
            List results = query.list();

            if (results.size() > 0) {
                book = (Book) results.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                session.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return book;
    }

    public List getAllBooks () {
        Session session = null;
        List results = null;

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            String hql = "FROM Book B";
            Query query = session.createQuery(hql);
            results = query.list();



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                session.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return results;
    }

    public void updateBook (Integer id, int numberOfPages) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Book book = (Book) session.get(Book.class,id);

            book.setNumberOfPages(numberOfPages);

            session.update(book);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            try {
                session.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void deleteBook (Integer id) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Book book = (Book) session.get(Book.class,id);

            session.delete(book);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            try {
                session.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }





    public void run() {
        Book book2 = new Book("Ogniem i Mieczem", "Henryk Sienkiewicz", 1921, 625);

        Book book1 = getBook(1);
        System.out.println(book1);
        System.out.println("--");
        List allBooks = getAllBooks();
        allBooks.forEach(System.out::println);

        //updateBook(1,500);
        System.out.println("\n");
        allBooks.forEach(System.out::println);

        System.out.println("Skasowanie ksiazki");
        //deleteBook(2);

        //allBooks.forEach(System.out::println);

    }



    public static void main(String[] args) {

        BookCRUD bookCRUD = new BookCRUD();
        bookCRUD.run();
    }
}
