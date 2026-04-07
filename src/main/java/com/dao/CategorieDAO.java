package com.dao;

import com.dto.CategorieDTO; // Using your specific DTO name
import com.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mounika
 */
public class CategorieDAO {

    /**
     * Method 1: Fetches all categories for the FIRST dropdown (Electronics, Furniture, etc.)
     */
    public List<CategorieDTO> getCategories() {
        List<CategorieDTO> list = new ArrayList<>();
        String sql = "SELECT cat_id, cat_name FROM categorie";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CategorieDTO dto = new CategorieDTO();
                dto.setId(rs.getInt("cat_id")); 
                dto.setName(rs.getString("cat_name")); 
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Method 2: Fetches items for the SECOND dropdown based on category selection
     */
    public List<CategorieDTO> getItemsByCategory(int catId) {
        List<CategorieDTO> list = new ArrayList<>();
        // Note: The '?' is a placeholder for the category ID selected by the user
        String sql = "SELECT item_id, item_name FROM items WHERE cat_id = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, catId); // This replaces the '?' with the actual catId
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CategorieDTO dto = new CategorieDTO();
                    dto.setId(rs.getInt("item_id"));
                    dto.setName(rs.getString("item_name"));
                    list.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void saveSelection(int catId,int itemId){
        
       String sql = "INSERT INTO user_selections (cat_id, item_id) VALUES (?, ?)";
    try (Connection con = DBUtil.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, catId);
        ps.setInt(2, itemId);
        ps.executeUpdate();
    }catch(Exception e){
        e.printStackTrace();
    }
    
        
    }
}