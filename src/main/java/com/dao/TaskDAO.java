/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import java.sql.*;

/**
 *
 * @author mounika
 */

import com.model.Task;
import java.util.*;

public class TaskDAO {
    
    public void insertTask(Task task, Connection conn) throws Exception {
        String sql = "INSERT INTO tasks (task_name, status, task_date) VALUES (?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE status = VALUES(status), task_date = VALUES(task_date)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, task.getTaskName());   
            ps.setString(2, task.getStatus());  
            ps.setString(3, task.getTaskDate()); 
            ps.executeUpdate();
        }
    }
    public List<Task> getAllTasks(Connection conn) throws Exception{
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT task_name, status FROM tasks";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                Task task = new Task();
                task.setTaskName(rs.getString("task_name"));
                task.setStatus(rs.getString("status"));
                tasks.add(task);
            }
             
         }
             
        return tasks;
         
        
    }
    
   public void deleteTaskByName(String name ,Connection conn) throws SQLException{
       String sql = "DELETE FROM tasks WHERE task_name = ?";
       try (PreparedStatement ps = conn.prepareStatement(sql)) {
           ps.setString(1, name);
           ps.executeUpdate();
           
       }
       
   }
}