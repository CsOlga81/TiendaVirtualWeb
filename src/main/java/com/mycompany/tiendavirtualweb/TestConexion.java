/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendavirtualweb;

import java.sql.Connection;
        
public class TestConexion {
    public static void main (String[] args) {
        Connection con = ConexionBD.getConexion();
        
        if (con != null) {
            System.out.println("Prueba Ok: Conexión establecida");
        } else {
            System.out.println("Fallo prueba: no hay conexión");
        }
    }
    
}
