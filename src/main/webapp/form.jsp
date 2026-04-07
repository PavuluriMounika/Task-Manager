<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<body>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<h2>Form</h2>
<s:if test="%{#parameters.name != null}">
    <h3 style="color:green;">Data Saved Successfully!</h3>
</s:if>
<s:form action="saveData">

<lable>Name: </lable><s:textfield name="name"/><br><br>
    Password: <s:textfield name="password"/><br><br>
    
    <button type="button" id="addBtn">Add</button><br>

    <div id="conditions"></div>

    <br>
    <s:submit value="Save"/>
    

</s:form>
    <s:iterator value="conditions" status="stat">

    <div class="row">

        <select name="conditions[%{#stat.index}].field">
            <option value="Age">Age</option>
            <option value="Salary">Salary</option>
            <option value="Experience">Experience</option>
        </select>

        <input type="text"
               name="conditions[%{#stat.index}].value"
               value="%{value}" />

        <button type="button" class="removeBtn">Remove</button>

    </div>

</s:iterator>


<script>

let index = 0;

// Add row
$("#addBtn").click(function(){

    let row = `
        <div class="row">

            <select name="conditions[`+index+`].field">
                <option value="Age">Age</option>
                <option value="Salary">Salary</option>
                <option value="Experience">Experience</option>
            </select>

            <input type="text" name="conditions[`+index+`].value"/>

            <!-- hidden flag -->
            <input type="hidden" name="conditions[`+index+`].deleted" value="false"/>

            <button type="button" class="removeBtn">Remove</button>

        </div>
    `;

    $("#conditions").append(row);

    index++;
});


// ? REMOVE = HIDE ONLY (not delete)
$(document).on("click", ".removeBtn", function(){

    let row = $(this).closest(".row");

    row.hide(); // hide UI

    // mark as deleted
    row.find("input[type='hidden']").val("true");
});

</script>
</body>
</html>