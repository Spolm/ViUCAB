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

/*
    @GET
    @Path("/editPlaylist")
    @Produces("text/plain")
    public ListaDeReproduccion getLista(@QueryParam("id") int idLista)
    {
        try {
            Entity listaObject = EntityFactory.listaDeReproduccion(1); //SE LE ESTA PASANDO MANUALMENTE
            Command commandGetLista = CommandsFactory.instanciaGetLista(listaObject);
            GetListaComando cmd = (GetListaComando) commandGetLista;
            //return (ListaDeReproduccion) cmd.execute(); NUEVO COMENTADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO solo esta linea
            /*Entity result = cmd.Return();
            ListaDeReproduccion json = (ListaDeReproduccion) result;*/

/*

        } catch (Exception e) {//ViUCABException e) {

           //throw new WebFault(e.Mensaje, e.codigo);
        }

       
    }*/


    @GET
    @Path("/editPlaylist")
    @Produces("text/plain")
    public String obtenerLista(@QueryParam("id_usu") int id_usu)
    {
        Entity listaObject = EntityFactory.getLista(1, id_usu);
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
    @Path("/holaperra")
    @Produces("text/plain")
    public String ejemplo()
    {

        return "Soy una putica loca loca de verdad";


       
    }



}