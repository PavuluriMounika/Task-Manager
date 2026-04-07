package com.test;

import org.hibernate.Session;
import com.util.HibernateUtil;

public class TestHibernate {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Hibernate Connected Successfully!");
        session.close();
    }
}