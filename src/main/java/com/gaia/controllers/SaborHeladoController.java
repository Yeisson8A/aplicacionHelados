/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.controllers;

import com.gaia.dao.SaborHeladoDAO;
import com.gaia.entities.SaborHelado;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author YEISSON
 */
@Path("SaborHeladoController")
public class SaborHeladoController {
    @GET
    @Path("/getSaboresHelados")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<SaborHelado> ObtenerSaboresHelados(){
        SaborHeladoDAO dao = new SaborHeladoDAO();
        ArrayList<SaborHelado> saborHelado = dao.ObtenerSaboresHelados();
        return saborHelado;
    }
    
    @POST
    @Path("/createSaborHelado")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean CrearSaborHelado(String descripcionSaborHelado){
        SaborHeladoDAO dao = new SaborHeladoDAO();
        boolean respuesta = dao.CrearSaborHelado(descripcionSaborHelado);
        return respuesta;
    }
    
    @DELETE
    @Path("/deleteSaborHelado/{idSaborHelado}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean EliminarSaborHelado(@PathParam("idSaborHelado") int idSaborHelado){
        SaborHeladoDAO dao = new SaborHeladoDAO();
        boolean respuesta = dao.EliminarSaborHelado(idSaborHelado);
        return respuesta;
    }
    
    @POST
    @Path("/updateSaborHelado")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean ActualizarSaborHelado(int idSaborHelado, String descripcionSaborHelado){
        SaborHeladoDAO dao = new SaborHeladoDAO();
        boolean respuesta = dao.ActualizarSaborHelado(idSaborHelado, descripcionSaborHelado);
        return respuesta;
    }
}
