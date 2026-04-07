/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.dto.DropDownDTO;
import com.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mounika
 */
public class DropDownDAO {
    
    public List<DropDownDTO> getData(String tableName){
        
        List<DropDownDTO> list=new ArrayList<>();
        
        String sql="select id, name from "+tableName;
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while(rs.next()){
               DropDownDTO dto=new DropDownDTO();
               dto.setId(rs.getInt("id"));
               dto.setName(rs.getString("name"));
               list.add(dto);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return list;
        
        
    }
    
}
