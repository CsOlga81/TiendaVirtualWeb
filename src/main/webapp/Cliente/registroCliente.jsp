<%-- 
    Document   : registroCliente.jsp
    Created on : 26/01/2026, 6:17:25 p. m.
    Author     : angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Clientes</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
    <div class="contenedor-formulario">
        <h2>Registro de Clientes</h2>
        
        <form action="../RegistroClienteServlet" method="post">
            <label>Nombre completo: </label>
            <input type="text" name="nombre_completo"><br><br>
            
            <label>Correo electrónico:</label>
            <input type="email" name="correo_electronico"><br><br>
            
            <label>Contraseña:</label>
            <input type="password" name="contrasena"><br><br>
            
            <label>Dirección:</label>
            <input type="text" name="direccion"><br><br>
            
            <label>Ciudad:</label>
            <input type="text" name="ciudad"><br><br>
            
            <label>Teléfono:</label>
            <input type="text" name="telefono"><br><br>
            
            <label>Fecha de registro:</label>
            <input type="date" name="fecha_registro"><br><br>
            
            <button type="submit">Registrar</button>
        </form>
    </div>
    </body>
</html>
