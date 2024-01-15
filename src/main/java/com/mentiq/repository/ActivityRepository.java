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
                    session.createQuery("SELECT a FROM Activity a WHERE a.username LIKE :user AND a.building LIKE :building", Activity.class);
            query.setParameter("user", "%" + user + "%");
            query.setParameter("building", "%" + building + "%");
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
            Query<Activity> query =
                    session.createQuery("UPDATE Activity set status = :status WHERE id = :id", Activity.class);
            query.setParameter("id", id);
            query.setParameter("status", status);
            query.executeUpdate();
            tx.commit();
        }
    }
}
