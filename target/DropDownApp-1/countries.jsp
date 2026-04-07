<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cascading Dropdown</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h3>Select Location</h3>

    <label>Country:</label>
    <s:select id="country" name="countryId" 
              list="countryList" listKey="id" listValue="name" 
              headerKey="-1" headerValue="-- Select Country --" />
    <br><br>

    <label>State:</label>
    <s:select id="state" name="stateId" list="{}" 
              headerKey="-1" headerValue="-- Select State --" />
    <br><br>

    <label>Village:</label>
    <s:select id="village" name="villageId" list="{}" 
              headerKey="-1" headerValue="-- Select Village --" />
<script type="text/javascript">
$(document).ready(function() {
    
    $('#country').change(function() {
        var cid = $(this).val();
        $('#state').html('<option value="-1">-- Loading --</option>');
        $('#village').html('<option value="-1">-- Select Village --</option>');

        if (cid != "-1") {
            // Added .action suffix to the URL
            $.getJSON('getStates.action', { countryId: cid }, function(data) {
                console.log("States Data:", data);
                $('#state').empty().append('<option value="-1">-- Select State --</option>');
                $.each(data, function(i, item) {
                    $('#state').append('<option value="' + item.id + '">' + item.name + '</option>');
                });
            });
        }
    });

    $('#state').change(function() {
        var sid = $(this).val();
        $('#village').html('<option value="-1">-- Loading --</option>');

        if (sid != "-1") {
            // Added .action suffix to the URL
            $.getJSON('getVillages.action', { stateId: sid }, function(data) {
                console.log("Villages Data:", data);
                $('#village').empty().append('<option value="-1">-- Select Village --</option>');
                $.each(data, function(i, item) {
                    $('#village').append('<option value="' + item.id + '">' + item.name + '</option>');
                });
            });
        }
    });
});
</script>
</body>
</html>