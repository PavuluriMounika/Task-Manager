<%-- 
    Document   : TaskManger
    Created on : 08-Apr-2026, 8:44:58 pm
    Author     : mounika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" type="text/css" href="style.css">
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="js/taskManger.js"></script>
</head>
<body>
<div class="container">
    <div class="todo-container">
        <h3 class="text-center mb-4">Daily Task Log</h3>
        
        <div class="input-group mb-4">
            <input type="text" id="taskInput" class="form-control" placeholder="Enter a new task...">
            <button class="btn btn-primary" type="button" id="addToListBtn">Add Task</button>
        </div>

        <ul id="taskDisplayList" class="list-group">
            </ul>
        
        <button class="btn btn-success w-100 mt-4 shadow-sm" id="saveAllBtn" >
            Save Today's Work
        </button>
    </div>
</div>
</body>
</html>
