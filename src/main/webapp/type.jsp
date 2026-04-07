<%-- 
    Document   : type
    Created on : 26-Mar-2026, 10:56:07 pm
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
       
        <s:form action="saveRequest">
            
            <s:radio
                name="selectedType"
                list="typeList"
                ListKey="id"
                listValue="name"
                lable="Type"
             />
                            
        </s:form>
        
    </body>
</html>
