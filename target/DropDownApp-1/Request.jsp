<%-- 
    Document   : Request
    Created on : 25-Mar-2026, 7:59:20 pm
    Author     : mounika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>request entry</h1>
        <s:form action="saveRequest">

    <s:textfield name="title" label="Request Title" />

    <s:select 
        name="systemTypeId"
        label="System Type"
        list="systemTypeList"
        listKey="id"
        listValue="name"
        headerKey=""
        headerValue="-- Select System Type --"
    />

    <s:submit value="Save" />

</s:form>
    </body>
</html>
