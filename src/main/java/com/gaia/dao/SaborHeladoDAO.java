/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.dao;

import com.gaia.entities.SaborHelado;
import com.gaia.utilities.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YEISSON
 */
public class SaborHeladoDAO {
    private Connection con;
    Conexion c;
    
    public SaborHeladoDAO(){
        while(con == null){
            c = new Conexion();
            con = c.getConnection();
        }
    }
    
    public ArrayList<SaborHelado> ObtenerSaboresHelados(){
        ArrayList<SaborHelado> saboresHelados = new ArrayList<SaborHelado>();
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("SELECT Id_Sabor_Helado, Descripcion_Sabor_Helado FROM Sabor_Helado");
        
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                SaborHelado saborHelado = new SaborHelado();
                saborHelado.setIdSaborHelado(rs.getInt("Id_Sabor_Helado"));
                saborHelado.setDescripcionSaborHelado(rs.getString("Descripcion_Sabor_Helado"));
                saboresHelados.add(saborHelado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaborHeladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.cerrarConnection();
        }
        return saboresHelados;
    }
    
    public boolean CrearSaborHelado(String descripcionSaborHelado){
        boolean respuesta = false;
        
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("INSERT INTO Sabor_Helado (Descripcion_Sabor_Helado) VALUES (?)");
            preparedStatement.setString(0, descripcionSaborHelado);
            int r = preparedStatement.executeUpdate();
            
            if(r > 0){
                respuesta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaborHeladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.cerrarConnection();
        }
        return respuesta;
    }
    
    public boolean ActualizarSaborHelado(int idSaborHelado, String descripcionSaborHelado){
        boolean respuesta = false;
        
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("UPDATE Sabor_Helado SET Descripcion_Sabor_Helado = ? WHERE Id_Sabor_Helado = ?");
            preparedStatement.setString(0, descripcionSaborHelado);
            preparedStatement.setInt(1, idSaborHelado);
            int r = preparedStatement.executeUpdate();
            
            if(r > 0){
                respuesta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaborHeladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.cerrarConnection();
        }
        return respuesta;
    }
    
    public boolean EliminarSaborHelado(int idSaborHelado){
        boolean respuesta = false;
        
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("DELETE FROM Sabor_Helado WHERE Id_Sabor_Helado = ?");
            preparedStatement.setInt(0, idSaborHelado);
            int r = preparedStatement.executeUpdate();
            
            if(r > 0){
                respuesta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaborHeladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.cerrarConnection();
        }
        return respuesta;
    }
}
