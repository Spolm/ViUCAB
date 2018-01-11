package edu.ucab.desarrollo.viucab.webService.M05_ListaDeReproduccion;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.ListaDeReproduccion;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.PlConnectException;

import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion.*;

import edu.ucab.desarrollo.viucab.webService.M02_Home.CrossOrigin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

@Path("/playlist")
/**
 * Clase del webservice Para el modulo de Lista de Reproduccion
 */
public class M05_ListaDeReproduccion {

    Gson gson = new Gson();

    private static Logger logger = LoggerFactory.getLogger( M05_ListaDeReproduccion.class ); //asigno el looger

    /**
     *  Metodo que retorna las listas de Reproduccion de la BD
     * @param id_usu
     * @return String
     */
    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/getAllPlaylist")
    @Produces("text/plain")
    public String obtenerLista(@QueryParam("id_usu") int id_usu)
    {
        Entity listaObject = EntityFactory.getLista(id_usu); //llamo a la fabrica entidad para setear lo que necesito pasar al dao
        Command commandGetLista = CommandsFactory.instanciaGetLista(listaObject); //instancio el comando necesario
        GetListaComando cmd = (GetListaComando) commandGetLista; //Inicializo el comando

        try {
            cmd.execute(); //ejecuto el comando
            ArrayList<Entity> resultados = cmd.getResultados(); //obtengo los resultados y los devuelvo en Json
            return gson.toJson(resultados);
        } catch (VIUCABException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        } catch (SQLException e) {
            e.printStackTrace();
            return gson.toJson(listaObject);
        }

    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/createPlaylist")
    @Produces("text/plain")
    /**
     * Metodo para agregar una lista a la BD
     */
    public String agregarLista(@QueryParam("id_usu") int id_usu, @QueryParam("lis_rep_nombre") String lis_rep_nombre,
                               @QueryParam("lis_rep_descripcion") String lis_rep_descripcion )
    {

        String lis_rep_img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtXnCR_ZKLXop4kwMfaIDLOxcPqco1zROOTIoEyCSP5LtBuXho";
        Integer lis_rep_numrep = 0;
        String lis_rep_fecha = LocalDate.now().toString(); //convierte la fecha de hoy la pone en string para crear la lista

        Entity listaObject = EntityFactory.createLista(lis_rep_nombre, lis_rep_descripcion, lis_rep_img, lis_rep_numrep, lis_rep_fecha, id_usu); //llamo a la fabrica entidad para setear lo que necesito pasar al dao
        Command commandAddList = CommandsFactory.instanciaAddListComando(listaObject); //instancio el comando necesario
        AddListComando cmd = (AddListComando) commandAddList; //Inicializo el comando

        try {
            cmd.execute(); //ejecuto el comando
            Boolean resultados = cmd.getResultado(); //obtengo los resultados y los devuelvo en Json
            return gson.toJson(resultados);

        } catch (VIUCABException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        } catch (SQLException e) {
            e.printStackTrace();
            return gson.toJson(listaObject);
        }

    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/getPlaylist")
    @Produces("text/plain")
    /**
     * Metodo para obtener una lista especifica
     */
    public String obtenerListaEspecifica(@QueryParam("lis_rep_id") int lis_rep_id)
    {
        Entity listaObject = EntityFactory.getListaEspecifica(lis_rep_id); //llamo a la fabrica entidad para setear lo que necesito pasar al dao
        Command commandGetEspecificList = CommandsFactory.instanciaGetEspecificList(listaObject); //instancio el comando necesario
        GetEspecificListComando cmd = (GetEspecificListComando) commandGetEspecificList; //Inicializo el comando

        try {
            cmd.execute(); //ejecuto el comando
            Entity resultados = cmd.Return(); //obtengo los resultados y los devuelvo en Json
            return gson.toJson(resultados);
        } catch (VIUCABException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        } catch (SQLException e) {
            e.printStackTrace();
            return gson.toJson(listaObject);
        }

    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/editPlaylist")
    @Produces("text/plain")
    /**
     * Metodo para modificar una lista
     */
    public String modificarLista(@QueryParam("lis_rep_id") int lis_rep_id, @QueryParam("lis_rep_nombre") String lis_rep_nombre, @QueryParam("lis_rep_descripcion") String lis_rep_descripcion, @QueryParam("list_rep_img") String list_rep_img)
    {
        Entity listaObject = EntityFactory.modifyLista(lis_rep_id, lis_rep_nombre, lis_rep_descripcion, list_rep_img); //llamo a la fabrica entidad para setear lo que necesito pasar al dao
        Command commandModifyList = CommandsFactory.instanciaModifyListComando(listaObject); //instancio el comando necesario
        ModifyListComando cmd = (ModifyListComando) commandModifyList; //Inicializo el comando

        try {
            cmd.execute(); //ejecuto el comando
            Boolean resultados = cmd.getResultado(); //obtengo los resultados y los devuelvo en Json
            return gson.toJson(resultados);

        } catch (VIUCABException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        } catch (SQLException e) {
            e.printStackTrace();
            return gson.toJson(listaObject);
        }

    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/deletePlaylist")
    @Produces("text/plain")
    /**
     * Metodo para eliminar una lista
     */
    public String eliminarLista(@QueryParam("lis_rep_id") int lis_rep_id)
    {
        Entity listaObject = EntityFactory.deleteList(lis_rep_id); //llamo a la fabrica entidad para setear lo que necesito pasar al dao
        Command commandDeleteList = CommandsFactory.instanciaDeleteListComando(listaObject); //instancio el comando necesario
        DeleteListComando cmd = (DeleteListComando) commandDeleteList; //Inicializo el comando
        Boolean resultados = false;

        try {
            cmd.execute(); //ejecuto el comando
            resultados = cmd.getResultado(); //obtengo los resultados y los devuelvo en Json
/*
        } catch (VIUCABException e) {

            listaObject.set_errorCode(e.ERROR_CODE);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);*/
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (VIUCABException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
        }
        return gson.toJson(resultados);
    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/addVideoToPlaylist")
    @Produces("text/plain")
    /**
     * Metodo para agregar un video a una lista
     */
    public String agregarVideoLista(@QueryParam("vid_id") int vid_id, @QueryParam("lis_rep_id") int lis_rep_id)
    {
        Entity listaObject = EntityFactory.addOrDeleteVideoToList(lis_rep_id, vid_id); //llamo a la fabrica entidad para setear lo que necesito pasar al dao
        Command commandAddVideoToList = CommandsFactory.instanciaAddVideoToListComando(listaObject); //instancio el comando necesario
        AddVideoToListComando cmd = (AddVideoToListComando) commandAddVideoToList; //Inicializo el comando

        try {
            cmd.execute(); //ejecuto el comando
            Boolean resultados = cmd.getResultado(); //obtengo los resultados y los devuelvo en Json
            return gson.toJson(resultados);
/*
        } catch (VIUCABException e) {

            listaObject.set_errorCode(e.ERROR_CODE);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);*/
        } catch (SQLException e) {
            e.printStackTrace();
            return gson.toJson(listaObject);
        } catch (VIUCABException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        }
    }


    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/deleteVideoFromPlaylist")
    @Produces("text/plain")
    /**
     * Metodo para eliminar un video de una lista
     */
    public String eliminarVideoLista(@QueryParam("vid_id") int vid_id, @QueryParam("lis_rep_id") int lis_rep_id)
    {
        Entity listaObject = EntityFactory.addOrDeleteVideoToList(lis_rep_id, vid_id); //llamo a la fabrica entidad para setear lo que necesito pasar al dao
        Command commandDeleteVideoToList = CommandsFactory.instanciaDeleteVideoToListComando(listaObject); //instancio el comando necesario
        DeleteVideoToListComando cmd = (DeleteVideoToListComando) commandDeleteVideoToList; //Inicializo el comando

        try {
            cmd.execute(); //ejecuto el comando
            Boolean resultados = cmd.getResultado(); //obtengo los resultados y los devuelvo en Json
            return gson.toJson(resultados);
        } catch (SQLException e) {
            e.printStackTrace();
            return gson.toJson(listaObject);
        } catch (VIUCABException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        }
    }


    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/getVideosFromPlaylist")
    @Produces("text/plain")
    /**
     * Metodo para obtener un video de una lista
     */
    public String obtenerVideosDeLista(@QueryParam("lis_rep_id") int lis_rep_id)
    {
        Entity listaObject = EntityFactory.getVideosFromList(lis_rep_id); //llamo a la fabrica entidad para setear lo que necesito pasar al dao
        Command commandGetVideosFromList = CommandsFactory.instanciaGetVideosFromList(listaObject); //instancio el comando necesario
        GetVideosFromListComando cmd = (GetVideosFromListComando) commandGetVideosFromList; //Inicializo el comando

        try {
            cmd.execute(); //ejecuto el comando
            ArrayList<Entity> resultados =cmd.getResultados(); //obtengo los resultados y los devuelvo en Json
            return gson.toJson(resultados);
        } catch (SQLException e) {
            e.printStackTrace();
            return gson.toJson(listaObject);
        } catch (VIUCABException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        }

    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/getTopVideos")
    @Produces("text/plain")
    /**
     * Metodo para obtener los videos mas vistos
     */
    public String obtenerVideosMasVistos()
    {
        Command commandGetTopVideos = CommandsFactory.instanciaGetTopVideos(); //instancio el comando necesario
        GetTopVideos cmd = (GetTopVideos) commandGetTopVideos; //Inicializo el comando

        try {
            cmd.execute(); //ejecuto el comando
            ArrayList<Entity> resultados =cmd.getResultados(); //obtengo los resultados y los devuelvo en Json
            return gson.toJson(resultados);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (VIUCABException e) {
            e.printStackTrace();
        }

        return null;
    }


    @GET
    @Path("/holamundo")
    @Produces("text/plain")
    /**
     * Metodo de ejemplo
     */
    public String ejemplo()
    {
        return "Ejemplo formal Y.E.U.P.D.V.V";

    }



}