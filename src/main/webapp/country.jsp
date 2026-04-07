<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<body>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<h2>Select Country</h2>

<s:form>
    <s:select 
        id="countryDropdown"
        name="countryId"
        list="countryList"
        listKey="id"
        listValue="name"
        headerValue="--Select Country--"/>
</s:form>

<select id="stateDropdown">
    <option>Select State</option>
</select>

<script>
$(document).ready(function(){

    $("#countryDropdown").change(function(){

        var countryId = $(this).val();

        $.ajax({
            url: "getStates.action",
            type: "GET",
            data: { countryId: countryId },

            success: function(data){

                var stateDropdown = $("#stateDropdown");
                stateDropdown.empty();

                stateDropdown.append("<option>Select State</option>");

                $.each(data, function(i, state){
                    stateDropdown.append(
                        "<option value='"+state.id+"'>"+state.name+"</option>"
                    );
                });
            },
            error: function(){
                alert("Error loading states");
            }
        });

    });

});
</script>
</body>

</html>