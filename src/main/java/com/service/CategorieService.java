package com.service;

import com.dao.CategorieDAO;
import com.dto.CategorieDTO;
import java.util.List;

public class CategorieService {
    CategorieDAO dao = new CategorieDAO();
    
    public List<CategorieDTO> getCategories(){
        return dao.getCategories();
    }
    
    public List<CategorieDTO> getItemsByCategory(int catId){
        return dao.getItemsByCategory(catId);
    }

    // FIX: This must match the call in your Action class
    public void saveSelection(CategorieDTO dto) { 
        // Pass the IDs from the DTO to the DAO
        dao.saveSelection(dto.getCatId(), dto.getId());
    }
}