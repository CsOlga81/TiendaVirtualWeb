/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.tiendavirtualweb;

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author angel
 */
@WebServlet(name = "RegistroProductoServlet", urlPatterns = {"/RegistroProductoServlet"})
public class RegistroProductoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistroProductoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistroProductoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*processRequest(request, response);*/
        /*Recibir datos del formulario*/
        String nombre = request.getParameter("nombre");
        String precio = request.getParameter("precio");
        String descripcion = request.getParameter("descripcion");
        String cantidad = request.getParameter("cantidad");
        String genero = request.getParameter("genero");
        String idCategoria = request.getParameter("id_categoria");
        
        
        response.setContentType("text/html; charset=UTF-8");
        
        response.getWriter().println("Nombre: " + nombre + "<br>");
        response.getWriter().println("Precio: " + precio + "<br>");
        response.getWriter().println("Descripcion: " + descripcion + "<br>");
        response.getWriter().println("Cantidad: " + cantidad + "<br>");
        response.getWriter().println("Categoría: " + idCategoria + "<br>");
        response.getWriter().println("Conexión a MySQL exitosa");

         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            /*Datos de conexión a mysql*/
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tienda_virtual?useSSL=false&serverTimezone=UTC",
                    "root",
                    "011203"
            );
            String sql = "INSERT INTO producto "
                    + "(nombre, precio, descripcion, cantidad, genero, id_categoria) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

             PreparedStatement ps = con.prepareStatement(sql);
             
            /*Se asignan valores*/
            ps.setString(1, nombre);
            ps.setDouble(2, Double.parseDouble(precio)); /*convierte el string a número*/
            ps.setString(3, descripcion);
            ps.setString(4, cantidad);
            ps.setString(5, genero);
            ps.setString(6, idCategoria);

            ps.executeUpdate(); /*para ejecutar*/
            
            response.getWriter().println("<h3 style='color:green;'>Producto registrado correctamente</h3>");
        
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error de conexión: " + e.getMessage());
       
        }
    }
}
 


