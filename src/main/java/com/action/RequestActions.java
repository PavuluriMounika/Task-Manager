/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.action;

import com.dto.TypeDTO;
import com.service.TypeService;
import java.util.List;

/**
 *
 * @author mounika
 */
public class RequestActions {
    
    private List<TypeDTO> typeList;
    
    private String selectedType;
    
    private TypeService service = new TypeService();
    
    public String execute(){
        typeList=service.getTypes();
        return "success";
    }
    public String save() {
    // validation runs before this
        return "success";
    }
     public List<TypeDTO> getTypeList() {
        return typeList;
    }

    public String getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(String selectedType) {
        this.selectedType = selectedType;
    }
    
}
