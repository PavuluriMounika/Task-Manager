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

public class TaskDAO {
    
    public void insertTask(Task task, Connection conn) throws Exception {
        String sql = "INSERT INTO tasks (task_name, status) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // Updated to getTaskName() to match your Task.java model
            ps.setString(1, task.getTaskName());   
            ps.setString(2, task.getStatus());  
            ps.executeUpdate();
        }
    }
}