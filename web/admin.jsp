<%-- 
    Document   : admin
    Created on : 01-nov-2017, 19:35:28
    Author     : Asus
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= request.getSession().getAttribute("nombreUsuario") %></title>
    </head>

    <body>
        
        <h1><font face="impact" color="blue">Bienvenido <%= request.getSession().getAttribute("nombreUsuario") %> </font></h1><br>
        <h2> <font face="arial black">Lista de usuarios registrados</font></h2>
        <table border="1">
            <tr>
            <td>Id</td>
            <td>Nombre</td>
            <td>Apellido</td>
            </tr>
            <%
            List<Usuario> lista = (List<Usuario>) request.getSession().getAttribute("lista");
            for (Usuario u : lista){
               out.println("<tr>");
               out.println("<td>"+u.getIdUsuario()+"</td>");
               out.println("<td>"+u.getNombreUsuario()+"</td>");
               out.println("<td>"+u.getClaveUsuario()+"</td>");
               out.println("</tr>");
            }
            %>
        </table>

        <form method="POST" action="ServletAdmin">
            <br>
            <h3><font face="arial black">Ingrese un nombre:</font></h3>
            <input type="text" name="elimUsuario" id="claveInicio" style="font-family: Arial; font-size: 12pt;width:210px;height:20px;text-align:left">
            <input type="Submit" name="eliminar" value="Eliminar">
            
        </form>
        
        <br><br>
        <a href="inicioSesion.jsp">Cerrar Sesion</a>
        
    </body>
</html>
