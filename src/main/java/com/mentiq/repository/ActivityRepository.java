package com.mentiq.repository;

import com.mentiq.entity.Activity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ActivityRepository {

    public List<Activity> all(String user, String building) throws RuntimeException {
        try (Session session = ConnectionFactory.getSessionFactory().openSession()) {
            Query<Activity> query =
                    session.createQuery("SELECT a FROM Activity a WHERE LOWER(a.username) LIKE :user AND LOWER(a.building) LIKE :building", Activity.class);
            query.setParameter("user", "%" + user + "%".toLowerCase());
            query.setParameter("building", "%" + building + "%".toLowerCase());
            return query.list();
        }
    }

    public Activity save(Activity activity) throws RuntimeException {
        try (Session session = ConnectionFactory.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();
            session.save(activity);
            t.commit();
        }
        return activity;
    }

    public void updateStatus(int id, String status) throws RuntimeException {
        try (Session session = ConnectionFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query query =
                    session.createQuery("UPDATE Activity set status = :status WHERE id = :id");
            query.setParameter("id", id);
            query.setParameter("status", status);
            query.executeUpdate();
            tx.commit();
        }
    }
}
