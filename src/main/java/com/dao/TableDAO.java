package com.dao;

import com.dto.TableDTO;
import com.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableDAO {

    public void saveData(List<TableDTO> list) {
    String sql = "INSERT INTO request_table(dropdown1,dropdown2,dropdown3,dropdown4) VALUES(?,?,?,?)";
    try (Connection con = DBUtil.getConnection()) {
        con.setAutoCommit(true); // ✅ Ensure data is committed immediately
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            for (TableDTO dto : list) {
                ps.setString(1, dto.getDropdown1());
                ps.setString(2, dto.getDropdown2());
                ps.setString(3, dto.getDropdown3());
                ps.setString(4, dto.getDropdown4());
                ps.addBatch();
            }
            ps.executeBatch();
        }
        System.out.println("Database batch insert complete.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public List<TableDTO> getAllData() {
        List<TableDTO> list = new ArrayList<>();
        // ✅ Added 'id' to the select query
        String sql = "SELECT id, dropdown1, dropdown2, dropdown3, dropdown4 FROM request_table";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TableDTO dto = new TableDTO();
                dto.setId(rs.getInt("id")); // ✅ Store ID in DTO
                dto.setDropdown1(rs.getString("dropdown1"));
                dto.setDropdown2(rs.getString("dropdown2"));
                dto.setDropdown3(rs.getString("dropdown3"));
                dto.setDropdown4(rs.getString("dropdown4"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM request_table WHERE id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Deleted record with ID: " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}