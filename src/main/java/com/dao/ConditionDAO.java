package com.dao;

import com.model.Condition;
import com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConditionDAO {

    // 🔥 SAVE
    public void saveConditions(List<Condition> list){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        for(Condition c : list){
            session.save(c);
        }

        tx.commit();
        session.close();
    }

    // 🔥 GET ALL (IMPORTANT)
    public List<Condition> getAllConditions(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Condition> list = session
                .createQuery("from Condition", Condition.class)
                .list();

        session.close();
        return list;
    }
}