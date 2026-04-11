/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function() {
    let temTasks = [];

    // 1. Add Task to List
    $("#addToListBtn").click(function() {
        let taskName = $("#taskInput").val().trim();

        if (taskName !== "") {
// Ensure the key is 'taskName' to match private String taskName in Java
            temTasks.push({ taskName: taskName, status: "Pending" });
            let listItem = `
                <li class="list-group-item d-flex align-items-center">
                    <input type="checkbox" class="task-check form-check-input me-3">
                    <span class="task-label">${taskName}</span>
                </li>`;

            $("#taskDisplayList").append(listItem);
            $("#taskInput").val("");
            $("#saveAllBtn").show();
        }
    });

    $(document).on('change', '.task-check', function() {
        let taskSpan = $(this).siblings('.task-label');
        let taskName = taskSpan.text();

// match 'taskName' here too
        let taskObj = temTasks.find(t => t.taskName === taskName);
        if ($(this).is(':checked')) {
            taskSpan.addClass('completed-text');
            if (taskObj) taskObj.status = "Completed";
        } else {
            taskSpan.removeClass('completed-text');
            if (taskObj) taskObj.status = "Pending";
        }
    });

    // 3. Save to Database
    $("#saveAllBtn").click(function() {
    if (temTasks.length === 0) return;

    let formData = {};
        temTasks.forEach((task, index) => {
            formData[`taskNames[${index}].taskName`] = task.taskName; 
            formData[`taskNames[${index}].status`] = task.status;
        });

    $.ajax({
        url: "saveTasksAction",
        type: "POST",
        data: formData, // Send as a regular object, NOT stringify
        success: function(response) {
            alert("Tasks saved to database successfully!");
        }
    });
});
});