package com.dao;

import com.model.Country;
import com.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CountriesDAO {
    
    // 1. Fetch all Countries (Initial load)
    public List<Country> getCountries() {
        List<Country> list = new ArrayList<>(); // Moved inside to keep it fresh
        String sql = "SELECT * FROM countries";
        
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while(rs.next()){
                Country c = new Country();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name")); // Standard getString is better
                list.add(c);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. Fetch States based on Country Selection
    public List<Country> getStates(int countryId) {
        List<Country> list = new ArrayList<>();
        String sql = "SELECT id, name FROM states WHERE country_id = ?";
        
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, countryId); // Set the filter
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()){
                    Country s = new Country(); // Reusing the DTO for simplicity
                    s.setId(rs.getInt("id"));
                    s.setName(rs.getString("name"));
                    list.add(s);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 3. Fetch Villages based on State Selection
    public List<Country> getVillages(int stateId) {
        List<Country> list = new ArrayList<>();
        String sql = "SELECT id, name FROM villages WHERE state_id = ?";
        
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, stateId); // Set the filter
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()){
                    Country v = new Country();
                    v.setId(rs.getInt("id"));
                    v.setName(rs.getString("name"));
                    list.add(v);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}