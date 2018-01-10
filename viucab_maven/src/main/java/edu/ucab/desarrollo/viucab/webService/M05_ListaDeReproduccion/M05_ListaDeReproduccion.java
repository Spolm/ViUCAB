package edu.ucab.desarrollo.viucab.webService.M05_ListaDeReproduccion;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.ListaDeReproduccion;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.PlConnectException;

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
import java.time.LocalDate;
import java.util.ArrayList;

@Path("/playlist")
public class M05_ListaDeReproduccion {

    Gson gson = new Gson();

    private static Logger logger = LoggerFactory.getLogger( M05_ListaDeReproduccion.class );

    private int usuarioPrueba = 4;


    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/getAllPlaylist")
    @Produces("text/plain")
    public String obtenerLista(@QueryParam("id_usu") int id_usu)
    {
        Entity listaObject = EntityFactory.getLista(id_usu);
        Command commandGetLista = CommandsFactory.instanciaGetLista(listaObject);
        GetListaComando cmd = (GetListaComando) commandGetLista;

        try {
            cmd.execute();
            /*Entity result = cmd.Return();
            ListaDeReproduccion json = (ListaDeReproduccion) result;*/
            ArrayList<Entity> resultados =cmd.getResultados();
            return gson.toJson(resultados);
/*
        } catch (VIUCABException e) {

            listaObject.set_errorCode(e.ERROR_CODE);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);*/
        } catch (PlConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        } catch (BdConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        }

    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/createPlaylist")
    @Produces("text/plain")
    public String agregarLista(@QueryParam("id_usu") int id_usu, @QueryParam("lis_rep_nombre") String lis_rep_nombre,
                               @QueryParam("lis_rep_descripcion") String lis_rep_descripcion )
    {

        String lis_rep_img = "";
        Integer lis_rep_numrep = 0;
        String lis_rep_fecha = LocalDate.now().toString(); //convierte la fecha de hoy la pone en string para crear la lista

        Entity listaObject = EntityFactory.createLista(lis_rep_nombre, lis_rep_descripcion, lis_rep_img, lis_rep_numrep, lis_rep_fecha, id_usu);
        Command commandAddList = CommandsFactory.instanciaAddListComando(listaObject);
        AddListComando cmd = (AddListComando) commandAddList;

        try {
            cmd.execute();
            Boolean resultados = cmd.getResultado();
            return gson.toJson(resultados);
/*
        } catch (VIUCABException e) {

            listaObject.set_errorCode(e.ERROR_CODE);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);*/
        } catch (PlConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        } catch (BdConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        }

    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/getPlaylist")
    @Produces("text/plain")
    public String obtenerListaEspecifica(@QueryParam("lis_rep_id") int lis_rep_id)
    {
        Entity listaObject = EntityFactory.getListaEspecifica(lis_rep_id);
        Command commandGetEspecificList = CommandsFactory.instanciaGetEspecificList(listaObject);
        GetEspecificListComando cmd = (GetEspecificListComando) commandGetEspecificList;

        try {
            cmd.execute();
            /*Entity result = cmd.Return();
            ListaDeReproduccion json = (ListaDeReproduccion) result;*/
            Entity resultados = cmd.Return();
            return gson.toJson(resultados);
/*
        } catch (VIUCABException e) {

            listaObject.set_errorCode(e.ERROR_CODE);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);*/
        } catch (PlConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        } catch (BdConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        }

    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/editPlaylist")
    @Produces("text/plain")
    public String modificarLista(@QueryParam("lis_rep_id") int lis_rep_id, @QueryParam("lis_rep_nombre") String lis_rep_nombre, @QueryParam("lis_rep_descripcion") String lis_rep_descripcion, @QueryParam("list_rep_img") String list_rep_img)
    {
        Entity listaObject = EntityFactory.modifyLista(lis_rep_id, lis_rep_nombre, lis_rep_descripcion, list_rep_img);
        Command commandModifyList = CommandsFactory.instanciaModifyListComando(listaObject);
        ModifyListComando cmd = (ModifyListComando) commandModifyList;

        try {
            cmd.execute();
            Boolean resultados = cmd.getResultado();
            return gson.toJson(resultados);
/*
        } catch (VIUCABException e) {

            listaObject.set_errorCode(e.ERROR_CODE);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);*/
        } catch (PlConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        } catch (BdConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        }

    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/deletePlaylist")
    @Produces("text/plain")
    public String eliminarLista(@QueryParam("lis_rep_id") int lis_rep_id)
    {
        Entity listaObject = EntityFactory.deleteList(lis_rep_id);
        Command commandDeleteList = CommandsFactory.instanciaDeleteListComando(listaObject);
        DeleteListComando cmd = (DeleteListComando) commandDeleteList;

        try {
            cmd.execute();
            Boolean resultados = cmd.getResultado();
            return gson.toJson(resultados);
/*
        } catch (VIUCABException e) {

            listaObject.set_errorCode(e.ERROR_CODE);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);*/
        } catch (PlConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        } catch (BdConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        }
    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/addVideoToPlaylist")
    @Produces("text/plain")
    public String agregarVideoLista(@QueryParam("vid_id") int vid_id, @QueryParam("lis_rep_id") int lis_rep_id)
    {
        Entity listaObject = EntityFactory.addOrDeleteVideoToList(lis_rep_id, vid_id);
        Command commandAddVideoToList = CommandsFactory.instanciaAddVideoToListComando(listaObject);
        AddVideoToListComando cmd = (AddVideoToListComando) commandAddVideoToList;

        try {
            cmd.execute();
            Boolean resultados = cmd.getResultado();
            return gson.toJson(resultados);
/*
        } catch (VIUCABException e) {

            listaObject.set_errorCode(e.ERROR_CODE);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);*/
        } catch (PlConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        } catch (BdConnectException e) {
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
    public String eliminarVideoLista(@QueryParam("vid_id") int vid_id, @QueryParam("lis_rep_id") int lis_rep_id)
    {
        Entity listaObject = EntityFactory.addOrDeleteVideoToList(lis_rep_id, vid_id);
        Command commandDeleteVideoToList = CommandsFactory.instanciaDeleteVideoToListComando(listaObject);
        DeleteVideoToListComando cmd = (DeleteVideoToListComando) commandDeleteVideoToList;

        try {
            cmd.execute();
            Boolean resultados = cmd.getResultado();
            return gson.toJson(resultados);
/*
        } catch (VIUCABException e) {

            listaObject.set_errorCode(e.ERROR_CODE);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);*/
        } catch (PlConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        } catch (BdConnectException e) {
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
    public String obtenerVideosDeLista(@QueryParam("lis_rep_id") int lis_rep_id)
    {
        Entity listaObject = EntityFactory.getVideosFromList(lis_rep_id);
        Command commandGetVideosFromList = CommandsFactory.instanciaGetVideosFromList(listaObject);
        GetVideosFromListComando cmd = (GetVideosFromListComando) commandGetVideosFromList;

        try {
            cmd.execute();
            /*Entity result = cmd.Return();
            ListaDeReproduccion json = (ListaDeReproduccion) result;*/
            ArrayList<Entity> resultados =cmd.getResultados();
            return gson.toJson(resultados);
/*
        } catch (VIUCABException e) {

            listaObject.set_errorCode(e.ERROR_CODE);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);*/
        } catch (PlConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        } catch (BdConnectException e) {
            e.printStackTrace();
            listaObject.set_errorCode(550);
            listaObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(listaObject);
        }

    }


    @GET
    @Path("/holaperra")
    @Produces("text/plain")
    public String ejemplo()
    {

        return "Soy una putica loca loca de verdad";


       
    }



}