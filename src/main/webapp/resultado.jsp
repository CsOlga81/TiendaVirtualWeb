<%-- 
    Document   : resultado.jsp
    Created on : 12/01/2026, 5:02:06 p. m.
    Author     : angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Resultado del Registro Cliente</title>
    </head>
    <body>
        <h2>Datos del cliente recibidos</h2>
        
        <p><strong>Nombre:</strong> <%= request.getAttribute("nombre") %></p>
        <p><strong>Correo:</strong> <%= request.getAttribute("correo") %></p>
        <p><strong>Teléfono:</strong> <%= request.getAttribute("telefono") %></p>
</body>
</html>
