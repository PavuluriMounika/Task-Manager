/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.SystemType;
import com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author mounika
 */
public class SystemTypeDAO {
    
    public List<SystemType> getAllTypes(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        List<SystemType> list=session.createQuery("from SystemType" ,SystemType.class).list();
        
        session.close();
        return list;

        
        
        
    }
    
}
