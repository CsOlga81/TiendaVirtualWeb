<%-- 
    Document   : registroProducto.jsp
    Created on : 1/02/2026, 6:51:13 p. m.
    Author     : angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registro de Producto</title>
        <link rel="stylesheet" href="../css/estilos.css">
    </head>
    <body>
        <h2 class="titulo">Registra el producto</h2>
            <div class="contenedor-formulario">     
                <form action="../RegistroProductoServlet" method="post">
            
                    <label for="nombre">Nombre del Producto:</label>
                    <input type="text" id="nombre" name="nombre" required><br><br>
            
                    <label for="descripcion">Descripción:</label>
                    <textarea id="descripcion" name="descripcion" maxlength="255"></textarea><br><br>
            
                    <label for="id_categoria">Categoría:</label>
                    <select name="id_categoria" required>
                        <option value="">Seleciones una opción</option>
                        <option value="1">Cuidado personal</option>
                        <option value="2">Maquillaje</option>
                        <option value="3">Perfumes</option>
                        <option value="4">Joyas</option>
                    </select><br><br>
                    
                    <label for="cantidad">Cantidad:</label>
                    <input type="number" id="cantidad" name="cantidad"><br><br>
                    
                    <label for="precio">Precio:</label>
                    <input type="number" id="precio" name="precio" step="0.01" required><br><br>
                    
                    <label for="genero">Genero:</label>
                    <select name="genero" required>
                        <option value="">Seleccione una opción</option>
                        <option value="Mujer">Mujer</option>
                        <option value="Hombre">Hombre</option>
                        <option value="Unisex">Niños</option>
                    </select><br><br>
            
                    <button type="submit" >Guardar Producto</button>
            
                </form>
            </div>
    </body>
</html>
