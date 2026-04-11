/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.TaskDAO;
import com.model.Task; // Import the Task model
import com.util.DBUtil;
import java.sql.Connection;
import java.util.*;

/**
 *
 * @author mounika
 */
public class TaskService {
    
    private TaskDAO taskDAO = new TaskDAO();
    
    // Changed parameter to List<Task>
    public boolean saveAlltasks(List<Task> tasks) {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            
            for(Task task : tasks) {
                // Pass the whole task object to the DAO
                taskDAO.insertTask(task, conn);
            }
            conn.commit();
            return true;
            
        } catch (Exception e) {
            try { if (conn != null) conn.rollback(); } catch (Exception ex) {}
            e.printStackTrace();
            return false;
        } finally {
            try { if (conn != null) conn.close(); } catch (Exception ex) {}
        }
    }
    public List<Task> fetchAllTasks(){
        Connection conn=null;
        try{
            conn=DBUtil.getConnection();
            return taskDAO.getAllTasks(conn);
        }catch (Exception e) {
        e.printStackTrace();
            return new ArrayList<>();
        } finally {
            try { if (conn != null) conn.close(); } catch (Exception ex) {}
        }

    }
}