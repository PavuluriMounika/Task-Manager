/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.DropDownDAO;
import com.dto.DropDownDTO;
import java.util.List;

/**
 *
 * @author mounika
 */
public class DropDownService {
    
    private DropDownDAO dao =new DropDownDAO();
    
    public List<DropDownDTO> getDropDown(String table)
    {
        return dao.getData(table);
    }    
    
    
    
    
}
