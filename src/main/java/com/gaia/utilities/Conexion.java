/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YEISSON
 */
public class Conexion {
    private Connection con = null;
    
    public Conexion(){
        try {
            con = DriverManager.getConnection("jdbc:derby:memory:db_Helados;create=true");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método para obtener la conexión creada
     * @return Connection
     */
    public Connection getConnection(){
        return con;
    }
    
    /**
     * Método para cerrar la conexión creada
     */
    public void cerrarConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
