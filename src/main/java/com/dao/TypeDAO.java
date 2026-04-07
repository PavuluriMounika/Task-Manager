/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.dto.TypeDTO;
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
public class TypeDAO {
    
    public List<TypeDTO> getAllTypes(){
        
        List<TypeDTO> list=new ArrayList<>();
        
        try(Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT id, name FROM type");
             ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                
                TypeDTO dto=new TypeDTO();
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
