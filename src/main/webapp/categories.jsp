<%-- 
    Document   : categories
    Created on : 04-Apr-2026, 10:26:42 pm
    Author     : mounika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        
    </head>
    <body>
        
        <h2>Electronic Shop</h2>

    <label>Category:</label>
    <select id="catSelect">
        <option value="">--Select Category--</option>
        <s:iterator value="categoryList">
            <option value="<s:property value='id'/>">
                <s:property value="name"/>
            </option>
        </s:iterator>
    </select>

    <br><br>

    <label>Items:</label>
    <select id="itemSelect">
        <option value="">--Select Item--</option>
    </select><br>
    
<br><br>
<button type="button" id="saveBtn" style="padding:10px 20px; cursor:pointer;">Save to Database</button>    
    <script>
$(document).ready(function(){
    $("#catSelect").on('change', function(){
        var id = $(this).val();
        var dropdown = $('#itemSelect');
        
        if(id !== ""){
            $.ajax({
                url: 'fetchItems.action',
                type: "POST",
                data: { catId: id },
                dataType: 'json',
                success: function(response){
                    console.log("Data Received:", response); // Look at this in F12 Console
                    
                    dropdown.empty();
                    dropdown.append('<option value="">--Select Item--</option>');
                    
                    // Standard Struts 2 JSON plugin returns the list directly
                    $.each(response, function(i, item) {
                        dropdown.append('<option value="' + item.id + '">' + item.name + '</option>');
                    });
                },
                error: function(xhr, status, error) {
                    console.error("AJAX Error:", error);
                    alert("Could not fetch items. Check if the server is running.");
                }
            });
        } else {
            dropdown.empty().append('<option value="">--Select Item--</option>');
        }
    });
    
    $("#saveBtn").on('click',function(){
        var cId = $("#catSelect").val();
        var iId = $("#itemSelect").val();
        console.log(cId);
        
        $.ajax({
            url: 'saveSelection.action',
            type:"POST",
            data:{
                catId: cId,
                itemId: iId
            },
            dataType: 'json',
            success: function(responce){
                alert("saved");
            },
            error: function(xhr) {
            console.error(xhr.responseText);
            alert("Error saving data.");
        }
            
        });
    })
});



</script>
    </body>
</html>
