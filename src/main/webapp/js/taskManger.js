/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function(){
    let temTasks=[];
    
    $("#addToListBtn").click(function(){
        
        let taskName =$("#taskInput").val().trim();
        
        if(taskName !==""){
            temTasks.push(taskName);
            
            $("#taskDisplayList").append('<li class="list-group-item">' + taskName + '</li>'); 
            
            $("#taskInput").val(""); 
            $("#saveAllBtn").show(); 
        }        
        
    });
    
    $("#saveAllBtn").click(function(){
        
        if(temTasks.length==0){
            alert("Please add at least one");
            return; 
        }
        $.ajax({
            url :"saveTasksAction",
            type :"POST",
            data:{"taskNames": temTasks},
            traditional : true ,
            success: function(responce){
                alert("Tasks saved to database successfully!");
             
            }
            
        });
        
    });
});