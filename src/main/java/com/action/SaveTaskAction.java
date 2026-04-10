/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.service.TaskService;
import java.util.*;

/**
 *
 * @author mounika
 */
public class SaveTaskAction extends ActionSupport {
    
    private List<String> taskNames;
    private TaskService taskService=new TaskService();
    
    @Override
    public String execute(){
        if (taskNames != null && !taskNames.isEmpty()) {
            boolean success=taskService.saveAlltasks(taskNames);
            return success ? SUCCESS : ERROR;
        }
        
        return "error";
    }

    public List<String> getTaskNames() {
        return taskNames;
    }

    public void setTaskNames(List<String> taskNames) {
        this.taskNames = taskNames;
    }
    
    
}
