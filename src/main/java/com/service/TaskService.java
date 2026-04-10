/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.TaskDAO;
import com.util.DBUtil;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author mounika
 */
public class TaskService {
    
    private TaskDAO taskDAO =new TaskDAO();
    
    public boolean saveAlltasks(List<String> names){
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            
            for(String name: names){
                taskDAO.insertTask(name, conn);
            }
            conn.commit();
            return true;
            
        } catch (Exception e) {
            try { if (conn != null) conn.rollback(); } catch (Exception ex) {}
            e.printStackTrace();
            return false;
        } 
    
    }
}
