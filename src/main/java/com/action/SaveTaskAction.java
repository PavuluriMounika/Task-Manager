/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.action;

import com.model.Task; // Make sure you import your Task model
import com.opensymphony.xwork2.ActionSupport;
import com.service.TaskService;
import java.util.*;

/**
 *
 * @author mounika
 */
public class SaveTaskAction extends ActionSupport {
    
    // Changed from List<String> to List<Task> to handle objects
    private List<Task> taskNames; 
    private TaskService taskService = new TaskService();
    private List<Task> savedTasks;
    
    @Override
    public String execute() {
        if (taskNames != null && !taskNames.isEmpty()) {
            // Update service call to pass the list of Task objects
            boolean success = taskService.saveAlltasks(taskNames);
            return success ? SUCCESS : ERROR;
        }
        
        return ERROR;
    }
    
    public String fetch(){
        taskNames =taskService.fetchAllTasks();
        return "success";
    }
    

    // Getters and Setters must match the new List<Task> type
    public List<Task> getTaskNames() {
        return taskNames;
    }

    public void setTaskNames(List<Task> taskNames) {
        this.taskNames = taskNames;
    }
}