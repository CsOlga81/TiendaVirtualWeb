/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author angel
 */
@WebServlet(urlPatterns = {"/RegistroClienteServlet"})
public class RegistroClienteServlet extends HttpServlet {

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
            out.println("<title>Servlet RegistroClienteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistroClienteServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);

        //Aqui se reciben los datos del formulario:
        String nombreCompleto = request.getParameter("nombre_completo");
        String correo = request.getParameter("correo_electronico");
        String contrasena = request.getParameter("contrasena");
        String direccion = request.getParameter("direccion");
        String ciudad = request.getParameter("ciudad");
        String telefono = request.getParameter("telefono");
        
        //Pongo esta validación para que no ingrese datos si falta el nombreCompleto
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty() ||
           correo == null || correo.trim().isEmpty() ||
           contrasena == null || contrasena.trim().isEmpty() ||
           direccion == null || direccion.trim().isEmpty() ||
           ciudad == null || ciudad.trim().isEmpty() ||
           telefono == null || telefono.trim().isEmpty()){
           
           response.getWriter().println("Todos los campos son obligatorios");
           return; //para detener el registro y no guardar en la BD
        }

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("Nombre recibido: " + nombreCompleto);
        response.getWriter().println("<br>");
        response.getWriter().println("Correo recibido: " + correo);
        response.getWriter().println("<br>");
        response.getWriter().println("Dirección recibida: " + direccion);
        response.getWriter().println("<br>");
        response.getWriter().println("Ciudad recibida: " + ciudad);
        response.getWriter().println("<br>");
        response.getWriter().println("Teléfono recibido: " + telefono);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tienda_virtual?useSSL=false&serverTimezone=UTC",
                    "root",
                    "011203"
            );
            String sql = "INSERT INTO cliente "
                    + "(nombre_completo, correo_electronico, contrasena, direccion, ciudad, telefono) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreCompleto);
            ps.setString(2, correo);
            ps.setString(3, contrasena);
            ps.setString(4, direccion);
            ps.setString(5, ciudad);
            ps.setString(6, telefono);

            ps.executeUpdate();

            response.getWriter().println("Conexión a MySQL exitosa");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            
            if (e.getMessage().contains("{Duplicate entry")) {
                response.getWriter().println("<hr><p style='color:green; font-weigh:bold;'>El correo ya está registrado. Intente con otr correo.</p>");
            } else {
                response.getWriter().println("Error en la base de datos: " + e.getMessage());
            }
        }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}


