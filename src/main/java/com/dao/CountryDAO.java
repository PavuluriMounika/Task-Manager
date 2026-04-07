package com.dao;

import java.util.List;
import org.hibernate.Session;
import com.model.Country;
import com.util.HibernateUtil;

public class CountryDAO {

    public List<Country> getAllCountries() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Country> list = session
                .createQuery("from Country", Country.class)
                .list();

        session.close();
        return list;
    }
}