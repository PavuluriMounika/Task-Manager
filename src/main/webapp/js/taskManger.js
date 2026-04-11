/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function() {
    let temTasks = [];

    // --- FUNCTION TO RENDER UI ---
    function renderTask(name, status) {
        let isChecked = status === "Completed" ? "checked" : "";
        let strikeClass = status === "Completed" ? "completed-text" : "";
        let displayMsg = status === "Completed" ? "display:inline" : "display:none";

        let listItem = `
            <li class="task-item">
                <input type="checkbox" class="task-check form-check-input" ${isChecked}>
                <span class="task-label ${strikeClass}">${name}</span>
               <span class="status-msg" style="display: ${displayMsg}">Completed!</span>
            </li>`;
        $("#taskDisplayList").append(listItem);
    }

    // --- FETCH DATA ON REFRESH ---
    function loadFromDB() {
        $.ajax({
            url: "fetchTasksAction", 
            type: "GET",
            success: function(response) {
                if(response.taskNames) {
                    $("#taskDisplayList").empty();
                    temTasks = response.taskNames; 
                    temTasks.forEach(t => renderTask(t.taskName, t.status));
                    if(temTasks.length > 0) $("#saveAllBtn").show();
                }
            }
        });
    }

    loadFromDB(); 

    // --- ADD TASK ---
    $("#addToListBtn").click(function() {
        let taskName = $("#taskInput").val().trim();
        if (taskName !== "") {
            let newTask = { taskName: taskName, status: "Pending" };
            temTasks.push(newTask);
            renderTask(newTask.taskName, newTask.status);
            $("#taskInput").val("");
            $("#saveAllBtn").show();
        }
    });

    // --- CHECKBOX CHANGE ---
    $(document).on('change', '.task-check', function() {
        let taskSpan = $(this).siblings('.task-label');
        let msgSpan = $(this).siblings('.status-msg');
        let taskNameText = taskSpan.text().trim();
        let taskObj = temTasks.find(t => t.taskName === taskNameText);

        if ($(this).is(':checked')) {
            taskSpan.addClass('completed-text');
            msgSpan.fadeIn(200);
            if (taskObj) taskObj.status = "Completed";
        } else {
            taskSpan.removeClass('completed-text');
            msgSpan.fadeOut(200);
            if (taskObj) taskObj.status = "Pending";
        }
    });

    // --- SAVE TO DB ---
    $("#saveAllBtn").click(function() {
        let formData = {};
        temTasks.forEach((task, index) => {
            formData[`taskNames[${index}].taskName`] = task.taskName; 
            formData[`taskNames[${index}].status`] = task.status;
        });

        $.ajax({
            url: "saveTasksAction",
            type: "POST",
            data: formData,
            success: function() { alert("All progress saved!"); }
        });
    });
});