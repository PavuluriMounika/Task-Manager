/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.State;
import com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author mounika
 */
public class StateDAO {

    public List<State> getStatesByCountry(int countryId){

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<State> list = session.createQuery(
            "from State where countryId = :cid", State.class)
            .setParameter("cid", countryId)
            .list();

        session.close();

        return list;
    }
}
