<%-- 
    Document   : registroUsuario
    Created on : 30-oct-2017, 18:24:33
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Usuario</title>
    </head>
    <body>   
        
        <form method="POST" action="ServletRegistro">
            
            <h1>Crear Usuario</h1>
            Usuario: 
            <br><input type="Text" name="nombreNuevo" style="font-family: Arial; font-size: 12pt;width:210px;height:20px;text-align:left"><br><br>
            Clave:
            <br><input type="Password" name="claveNueva" style="font-family: Arial; font-size: 12pt;width:210px;height:20px;text-align:left"><br><br>
            <input type="Submit" name="crear" value="Crear Usuario">
            
        </form>
        
        <% if(request.getSession().getAttribute("mensaje3") != null) { %>
            <h1 style="color: red">
            <%= request.getSession().getAttribute("mensaje3") %>
            </h1>
        <% } %>
        
    </body>
</html>
