<%-- 
    Document   : paginaInicio
    Created on : 30-oct-2017, 18:30:51
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= request.getSession().getAttribute("nombreUsuario") %></title>
    </head>

    <body>
        
        <h1>Bienvenido <%= request.getSession().getAttribute("nombreUsuario") %> </h1>
        <a href="inicioSesion.jsp">Cerrar Sesion</a>
        
    </body>
</html>
