/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.dao;

import com.gaia.entities.SaborTipoHelado;
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
public class SaborTipoHeladoDAO {
    private Connection con;
    Conexion c;
    
    public SaborTipoHeladoDAO(){
        while(con == null){
            c = new Conexion();
            con = c.getConnection();
        }
    }
    
    public ArrayList<SaborTipoHelado> ObtenerSaboresTiposHelados(){
        ArrayList<SaborTipoHelado> saboresTiposHelados = new ArrayList<SaborTipoHelado>();
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("SELECT Id_Sabor_Tipo_Helado, Id_Tipo_Helado, Id_Sabor_Helado FROM Sabor_Tipo_Helado");
        
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                SaborTipoHelado saborTipoHelado = new SaborTipoHelado();
                saborTipoHelado.setIdSaborTipoHelado(rs.getInt("Id_Sabor_Tipo_Helado"));
                saborTipoHelado.setIdTipoHelado(rs.getInt("Id_Tipo_Helado"));
                saborTipoHelado.setIdSaborHelado(rs.getInt("Id_Sabor_Helado"));
                saboresTiposHelados.add(saborTipoHelado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaborTipoHeladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.cerrarConnection();
        }
        return saboresTiposHelados;
    }
    
    public boolean CrearSaborTipoHelado(int idTipoHelado, int idSaborHelado){
        boolean respuesta = false;
        
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("INSERT INTO Sabor_Tipo_Helado (Id_Tipo_Helado, Id_Sabor_Helado) VALUES (?, ?)");
            preparedStatement.setInt(0, idTipoHelado);
            preparedStatement.setInt(1, idSaborHelado);
            int r = preparedStatement.executeUpdate();
            
            if(r > 0){
                respuesta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaborTipoHeladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.cerrarConnection();
        }
        return respuesta;
    }
    
    public boolean ActualizarSaborTipoHelado(int idSaborTipoHelado, int idTipoHelado, int idSaborHelado){
        boolean respuesta = false;
        
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("UPDATE Sabor_Tipo_Helado SET Id_Tipo_Helado = ?, Id_sabor_Helado = ? WHERE Id_Sabor_Tipo_Helado = ?");
            preparedStatement.setInt(0, idTipoHelado);
            preparedStatement.setInt(1, idSaborHelado);
            preparedStatement.setInt(2, idSaborTipoHelado);
            int r = preparedStatement.executeUpdate();
            
            if(r > 0){
                respuesta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaborTipoHeladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.cerrarConnection();
        }
        return respuesta;
    }
    
    public boolean EliminarSaborTipoHelado(int idSaborTipoHelado){
        boolean respuesta = false;
        
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("DELETE FROM Sabor_Tipo_Helado WHERE Id_Sabor_Tipo_Helado = ?");
            preparedStatement.setInt(0, idSaborTipoHelado);
            int r = preparedStatement.executeUpdate();
            
            if(r > 0){
                respuesta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaborTipoHeladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.cerrarConnection();
        }
        return respuesta;
    }
}
