package edu.ucab.desarrollo.viucab.webService.M12_ModeracionContenido;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.ContenedorIdListaFiltros;
import edu.ucab.desarrollo.viucab.common.entities.ContenedorIdListaVideos;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M12_ModeracionContenido.*;

import javax.ws.rs.*;
import java.sql.Connection;

/**
 * Created by Pablo, Jose and Karem on 07/01/2018.
 */
@Path("/ModeracionContenido")
public class M12_ModeracionContenido {
    Entity entidad = null;
    Gson gson = new Gson();
      //Connection conn = Sql.getConInstance();

    /**
     * Devuelve todos los filtros de configuracion dado un id de Usuario
     * @Param id
     * @return lista de filtros del Usuario
     */

    @GET
    @Path("/cargarFiltros")
    @Produces("application/json")
    public String cargarFiltros(@QueryParam("id") Integer id) {

        try {
            Command commadModeracionContenido = CommandsFactory.instanciarGetFiltrosDeUsuarioComando(id);
            GetFiltrosDeUsuarioComando cmd = (GetFiltrosDeUsuarioComando) commadModeracionContenido;
            cmd.execute();
            return gson.toJson(cmd.getFiltros());

        } catch (Exception ex) {
            return gson.toJson(ex.getMessage());
        }
    }

  /**
     * Devuelve true si la contraseña ingresada coincide con la del Usuario, dado un id de Usuario y Clave obtenida desde la app
     * @Param id
     * @Param claveApp
     * @return true o false
     */
    @GET
    @Path("/validarAcceso")
    @Produces("application/json")
    public String validarAcceso (@QueryParam("id")  Integer id,@QueryParam("claveApp")  String claveApp ) {
        try {
            Command commadModeracionContenido = CommandsFactory.instanciarValidarAccesoComando(id, claveApp);
            ValidarAccesoComando cmd = (ValidarAccesoComando) commadModeracionContenido;
            cmd.execute();
            return gson.toJson(cmd.getValidacion());

        } catch (Exception ex) {
            return gson.toJson(ex.getMessage());
        }
    }


/**
     * Devuelve todos los videos permitidos segun los filtros y preferencia del Usuraio, dado un id de Usuario
     * @Param id
     * @return lista de videos permitidos
     */
    @GET
    @Path("/cargarVideosPermitidos")
    @Produces("application/json")
    public String cargarVideosPermitidos(@QueryParam("id")  Integer id){
        try {
            Command commadModeracionContenido = CommandsFactory.instanciarGetVideosPermitidosComando(id);
            GetVideosPermitidosComando cmd = (GetVideosPermitidosComando) commadModeracionContenido;
            cmd.execute();
            return gson.toJson(cmd.getVideosPermitidos());

        } catch (Exception ex) {
            return gson.toJson(ex.getMessage());
        }

    }
  /**
     * Devuelve todos los videos permitidos segun los filtros y preferencia del Usuraio,
     * dado un contenedor compuesto del id de Usuario y la lista de videos a filtrar
     * @Param contenedor
     * @return lista de videos filtrados
     */
    @POST
    @Path("/filtrarVideos")
    @Consumes("application/json")
    @Produces("application/json")
    public String filtrarVideos(ContenedorIdListaVideos contenedor){
        try {
            Command commadModeracionContenido = CommandsFactory.instanciarFiltrarVideosComando(contenedor);
            FiltrarVideosComando cmd = (FiltrarVideosComando) commadModeracionContenido;
            cmd.execute();
            return gson.toJson(cmd.getVideosFiltrados());

        } catch (Exception ex) {
            return gson.toJson(ex.getMessage());
        }
    }

/**
     * Devuelve true si pudo guardar todos los filtros del Usuraio,
     * dado un contenedor compuesto del id de Usuario y la lista de filtros a guardar
     * @Param contenedor
     * @return true si guardó los filtros con exito
     */
    @POST
    @Path("/guardarFiltros")
    @Consumes("application/json")
    @Produces("application/json")
    public String guardarFiltros(ContenedorIdListaFiltros contenedor){
        try {
            Command commadModeracionContenido = CommandsFactory.instanciarGuardarFiltrosComando(contenedor);
            GuardarFiltrosComando cmd = (GuardarFiltrosComando) commadModeracionContenido;
            cmd.execute();
            return cmd.getResultadoGuardado();

        } catch (Exception ex) {
            return gson.toJson(ex.getMessage());
        }
    }



}