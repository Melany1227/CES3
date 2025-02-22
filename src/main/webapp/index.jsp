<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<% String[] materias = {"CES", "DPAS", "DPLM"};%>

<table>
    <h1>Materias</h1>
    <tr>
        <th>ID</th>
        <th>Theme</th>
    </tr>
    <tr>
    <% for (int i =0; i < materias.length ; i++) {
        %><li><%= materias[i]  %></li><% 
        }
    %>


</table>
</body>
</html>