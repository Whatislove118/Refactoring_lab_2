package server.services;

import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.BookList;
import javax.persistence.Query;
import java.util.ArrayList;


public class BookService {




    public static boolean save(Book book) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(book);
            tx1.commit();
            session.close();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public static BookList findBy(String by, String value) throws Exception {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = switch (by) {
            case "name" -> session.createQuery("from Book where name=:v");
            case "isbn" -> session.createQuery("from Book where isbn=:v");
            case "authorName" -> session.createQuery("from Book where authorName=:v");
            case "annotation" -> session.createQuery("from Book where annotation=:v");
            default -> throw new Exception("Wrong by parameter");
        };
        //сортировка по количеству вхождений

        query.setParameter("v", value);
        return new BookList((ArrayList<Book>) query.getResultList());
    };
}

