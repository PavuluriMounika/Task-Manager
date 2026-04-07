package com.dao;

import com.model.Condition;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {

    public void saveUser(String name, String password, List<Condition> conditions) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {

            // Insert user
            session.createNativeQuery(
                "INSERT INTO user_data(name, password) VALUES (:name, :pass)"
            )
            .setParameter("name", name)
            .setParameter("pass", password)
            .executeUpdate();

            // Get last inserted id
            int userId = ((Number) session.createNativeQuery("SELECT LAST_INSERT_ID()")
                    .getSingleResult()).intValue();

            // Insert conditions
            if (conditions != null) {
                for (Condition c : conditions) {

                    session.createNativeQuery(
                        "INSERT INTO conditions(user_id, field, value) VALUES (:uid, :field, :val)"
                    )
                    .setParameter("uid", userId)
                    .setParameter("field", c.getField())
                    .setParameter("val", c.getValue())
                    .executeUpdate();
                }
            }

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }

        session.close();
    }
}