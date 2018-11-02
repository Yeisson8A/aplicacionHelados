/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.controllers;

import com.gaia.dao.TipoHeladoDAO;
import com.gaia.entities.TipoHelado;
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
@Path("TipoHeladoController")
public class TipoHeladoController {    
    @GET
    @Path("/getTiposHelados")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<TipoHelado> ObtenerTiposHelados(){
        TipoHeladoDAO dao = new TipoHeladoDAO();
        ArrayList<TipoHelado> tipoHelado = dao.ObtenerTiposHelados();
        return tipoHelado;
    }
    
    @POST
    @Path("/createTipoHelado")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean CrearTipoHelado(String descripcionTipoHelado){
        TipoHeladoDAO dao = new TipoHeladoDAO();
        boolean respuesta = dao.CrearTipoHelado(descripcionTipoHelado);
        return respuesta;
    }
    
    @DELETE
    @Path("/deleteTipoHelado/{idTipoHelado}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean EliminarTipoHelado(@PathParam("idTipoHelado") int idTipoHelado){
        TipoHeladoDAO dao = new TipoHeladoDAO();
        boolean respuesta = dao.EliminarTipoHelado(idTipoHelado);
        return respuesta;
    }
    
    @POST
    @Path("/updateTipoHelado")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean ActualizarTipoHelado(int idTipoHelado, String descripcionTipoHelado){
        TipoHeladoDAO dao = new TipoHeladoDAO();
        boolean respuesta = dao.ActualizarTipoHelado(idTipoHelado, descripcionTipoHelado);
        return respuesta;
    }
}
