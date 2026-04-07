/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.SystemTypeDAO;
import com.model.SystemType;
import java.util.List;

/**
 *
 * @author mounika
 */
public class RequestService {
    
    public List<SystemType> getSystemTypes(){
        
        return new SystemTypeDAO().getAllTypes();
        
    }
    
}
