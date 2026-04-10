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
public class TaskDAO {
    
    public void insertTask(String taskName,Connection conn) throws Exception {
        String sql="insert into tasks(task_name,status) Values(?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, taskName);
            ps.setString(2, "pending");
            ps.execute();
        }
        
    }
    
}
