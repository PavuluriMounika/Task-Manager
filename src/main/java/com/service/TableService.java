/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.TableDAO;
import com.dto.TableDTO;
import java.util.List;

/**
 *
 * @author mounika
 */
public class TableService {
    
    private TableDAO dao= new TableDAO();
    
    public void saveData(List<TableDTO> list){
        dao.saveData(list);
    }
    public List<TableDTO> getAllData(){
        return dao.getAllData();
    }
    
    public void deleteById(int id){
        dao.deleteById(id);
    }
    
    
}
