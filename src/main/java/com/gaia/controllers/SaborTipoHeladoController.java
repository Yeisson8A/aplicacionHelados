/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.controllers;

import com.gaia.dao.SaborTipoHeladoDAO;
import com.gaia.entities.SaborTipoHelado;
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
@Path("SaborTipoHeladoController")
public class SaborTipoHeladoController {
    @GET
    @Path("/getSaboresTiposHelados")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<SaborTipoHelado> ObtenerSaboresHelados(){
        SaborTipoHeladoDAO dao = new SaborTipoHeladoDAO();
        ArrayList<SaborTipoHelado> saborTipoHelado = dao.ObtenerSaboresTiposHelados();
        return saborTipoHelado;
    }
    
    @POST
    @Path("/createSaborTipoHelado")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean CrearSaborTipoHelado(int idTipoHelado, int idSaborHelado){
        SaborTipoHeladoDAO dao = new SaborTipoHeladoDAO();
        boolean respuesta = dao.CrearSaborTipoHelado(idTipoHelado, idSaborHelado);
        return respuesta;
    }
    
    @DELETE
    @Path("/deleteSaborTipoHelado/{idSaborTipoHelado}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean EliminarSaborTipoHelado(@PathParam("idSaborTipoHelado") int idSaborTipoHelado){
        SaborTipoHeladoDAO dao = new SaborTipoHeladoDAO();
        boolean respuesta = dao.EliminarSaborTipoHelado(idSaborTipoHelado);
        return respuesta;
    }
    
    @POST
    @Path("/updateSaborTipoHelado")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean ActualizarSaborTipoHelado(int idSaborTipoHelado, int idTipoHelado, int idSaborHelado){
        SaborTipoHeladoDAO dao = new SaborTipoHeladoDAO();
        boolean respuesta = dao.ActualizarSaborTipoHelado(idSaborTipoHelado, idTipoHelado, idSaborHelado);
        return respuesta;
    }
}
