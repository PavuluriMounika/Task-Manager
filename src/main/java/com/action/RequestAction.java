/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.action;

import com.model.SystemType;
import com.service.RequestService;
import java.util.List;

/**
 *
 * @author mounika
 */
public class RequestAction {
    
    private String title;
    private int systemTypeId;
    
    private List<SystemType> systemTypeList;
    
    public String execute(){
        
        systemTypeList=new RequestService().getSystemTypes();
        return "success";
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSystemTypeId() {
        return systemTypeId;
    }

    public void setSystemTypeId(int systemTypeId) {
        this.systemTypeId = systemTypeId;
    }

    public List<SystemType> getSystemTypeList() {
        return systemTypeList;
    }

    public void setSystemTypeList(List<SystemType> systemTypeList) {
        this.systemTypeList = systemTypeList;
    }
    
    
    
    
}
