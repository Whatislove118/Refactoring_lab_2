package server.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import server.entity.User;

import javax.persistence.Query;
import java.io.Serializable;

public class UserService {

    public static boolean reg(User user) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(user);
            tx1.commit();
            session.close();
        }catch (Exception e){
            return false;
        }
        return true;
    }


    public static boolean login(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User where username=:u and password=:p");
        query.setParameter("u", user.getUsername());
        query.setParameter("p", user.getPassword());
        int count = query.getResultList().size();
        return count != 0;
    }

}
