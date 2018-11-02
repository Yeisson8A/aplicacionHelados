/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.dao;

import com.gaia.entities.TipoHelado;
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
public class TipoHeladoDAO {
    private Connection con;
    Conexion c;
    
    public TipoHeladoDAO(){
        while(con == null){
            c = new Conexion();
            con = c.getConnection();
        }
    }
    
    public ArrayList<TipoHelado> ObtenerTiposHelados(){
        ArrayList<TipoHelado> tiposHelados = new ArrayList<TipoHelado>();
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("SELECT Id_Tipo_Helado, Descripcion_Tipo_Helado FROM Tipo_Helado");
        
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                TipoHelado tipoHelado = new TipoHelado();
                tipoHelado.setIdTipoHelado(rs.getInt("Id_Tipo_Helado"));
                tipoHelado.setDescripcionTipoHelado(rs.getString("Descripcion_Tipo_Helado"));
                tiposHelados.add(tipoHelado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoHeladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.cerrarConnection();
        }
        return tiposHelados;
    }
    
    public boolean CrearTipoHelado(String descripcionTipoHelado){
        boolean respuesta = false;
        
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("INSERT INTO Tipo_Helado (Descripcion_Tipo_Helado) VALUES (?)");
            preparedStatement.setString(0, descripcionTipoHelado);
            int r = preparedStatement.executeUpdate();
            
            if(r > 0){
                respuesta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoHeladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.cerrarConnection();
        }
        return respuesta;
    }
    
    public boolean ActualizarTipoHelado(int idTipoHelado, String descripcionTipoHelado){
        boolean respuesta = false;
        
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("UPDATE Tipo_Helado SET Descripcion_Tipo_Helado = ? WHERE Id_Tipo_Helado = ?");
            preparedStatement.setString(0, descripcionTipoHelado);
            preparedStatement.setInt(1, idTipoHelado);
            int r = preparedStatement.executeUpdate();
            
            if(r > 0){
                respuesta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoHeladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.cerrarConnection();
        }
        return respuesta;
    }
    
    public boolean EliminarTipoHelado(int idTipoHelado){
        boolean respuesta = false;
        
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("DELETE FROM Tipo_Helado WHERE Id_Tipo_Helado = ?");
            preparedStatement.setInt(0, idTipoHelado);
            int r = preparedStatement.executeUpdate();
            
            if(r > 0){
                respuesta = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoHeladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.cerrarConnection();
        }
        return respuesta;
    }
}
