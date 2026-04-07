<%@ taglib prefix="s" uri="/struts-tags" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Table Page</title>
</head>
<body>

    <h3>Dynamic Dropdown Table</h3>

    <label>Name</label>
    <select id="id1"></select><br><br>

    <label>Type</label>
    <select id="id2"></select><br><br>

    <label>Station</label>
    <select id="id3"></select><br><br>

    <label>Equipment</label>
    <select id="id4"></select><br><br>

    <button onclick="addRow()">Add</button>
    <button onclick="saveTable()">Save</button>


    <br><br>

    <table border="1" id="myTable">
        <thead>
            <tr>
                <th>Dropdown1</th>
                <th>Dropdown2</th>
                <th>Dropdown3</th>
                <th>Dropdown4</th>
                <th>Action</th>
            </tr>
        </thead>

        <!-- 🔥 IMPORTANT -->
        <tbody id="tableBody"></tbody>
    </table><br>
        <script src="table.js"></script>

</body>
</html>