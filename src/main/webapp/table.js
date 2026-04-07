function loadDropdown(id, type) {
    $.ajax({
        url: "getDropdownData.action",
        type: "GET",
        data: { type: type },
        success: function(data) {
            let dropdown = $("#" + id);
            dropdown.empty().append("<option value=''>Select</option>");
            $.each(data, function(i, item) {
                dropdown.append("<option value='" + item.id + "'>" + item.name + "</option>");
            });
        }
    });
}

$(document).ready(function() {
    loadDropdown("id1", "dropdown1");
    loadDropdown("id2", "dropdown2");
    loadDropdown("id3", "dropdown3");
    loadDropdown("id4", "dropdown4");
    loadTable();
});

function addRow() {
    let v1 = $("#id1 option:selected").text();
    let v2 = $("#id2 option:selected").text();
    let v3 = $("#id3 option:selected").text();
    let v4 = $("#id4 option:selected").text();

    if (v1 === "Select" || v2 === "Select" || v3 === "Select" || v4 === "Select") {
        alert("Please select all values");
        return;
    }

    // ✅ New rows use 'null' for ID because they aren't in the DB yet
    let row = `<tr>
                <td>${v1}</td><td>${v2}</td><td>${v3}</td><td>${v4}</td>
                <td><button onclick="deleteRow(null, this)">Delete</button></td>
               </tr>`;
    $("#tableBody").append(row);
}

function deleteRow(id, btn) {
    // Case 1: Row only exists in UI (not saved yet)
    if (id === null || id === undefined) {
        $(btn).closest('tr').remove();
        return;
    }

    // Case 2: Row exists in Database
    if (confirm("Delete this permanently from Database?")) {
        $.ajax({
            url: "deleteRow.action",
            type: "POST",
            data: { id: id },
            success: function() {
                $(btn).closest('tr').remove();
                alert("Deleted successfully");
            }
        });
    }
}
function saveTable() {
    let tableData = [];
    $("#tableBody tr").each(function() {
        tableData.push({
            dropdown1: $(this).find("td:eq(0)").text(),
            dropdown2: $(this).find("td:eq(1)").text(),
            dropdown3: $(this).find("td:eq(2)").text(),
            dropdown4: $(this).find("td:eq(3)").text()
        });
    });

    if (tableData.length === 0) return;

    $.ajax({
        url: "saveTable.action",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({ "tableData": tableData }),
        success: function() {
            alert("Data Saved Successfully!");
            // ✅ DO NOT call .empty() here manually.
            // ✅ Just call loadTable to refresh the view with real IDs from DB.
            loadTable(); 
        },
        error: function() {
            alert("Save failed!");
        }
    });
}

function loadTable() {
    $.ajax({
        url: "fetchTable.action",
        type: "GET",
        success: function(data) {
            $("#tableBody").empty();
            $.each(data, function(i, item) {
                // ✅ Pass the real item.id to the delete function
                let row = `<tr>
                            <td>${item.dropdown1}</td>
                            <td>${item.dropdown2}</td>
                            <td>${item.dropdown3}</td>
                            <td>${item.dropdown4}</td>
                            <td><button onclick="deleteRow(${item.id}, this)">Delete</button></td>
                           </tr>`;
                $("#tableBody").append(row);
            });
        }
    });
}