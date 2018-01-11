package edu.ucab.desarrollo.viucab.webService.M01_Login;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.PlConnectException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M01_Login.*;
import edu.ucab.desarrollo.viucab.webService.M02_Home.CrossOrigin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.time.LocalDate;
import java.util.ArrayList;

@Path("/Login")
public class M01_Login {

    Gson gson = new Gson();

    private static Logger logger = LoggerFactory.getLogger( M01_Login.class );



    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/RegistrarUsuario")
    @Produces("text/plain")

    public String agregaUsuario(@QueryParam("username") String username,@QueryParam("claveusu") String claveusu,@QueryParam("correousu") String correousu)
    {

        Entity UsuarioObjet = EntityFactory.addUsuario(username, claveusu, correousu);
        Command commandAddUsuario = CommandsFactory.instanciateGetUsuarioComando(UsuarioObjet);
        GetUsuarioComando cmd = (GetUsuarioComando) commandAddUsuario;

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
            UsuarioObjet.set_errorCode(550);
            UsuarioObjet.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(UsuarioObjet);
        } catch (BdConnectException e) {
            e.printStackTrace();
            UsuarioObjet.set_errorCode(550);
            UsuarioObjet.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(UsuarioObjet);
        }

    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/verUsuarios")
    @Produces("text/plain")
    public String verusuarios()
    {
        Entity UsuarioObjet = EntityFactory.verUusuario();
        Command commandGetUsuarios = CommandsFactory.instanciateVerUsuariosComando(UsuarioObjet);
        VerUsuariosComando cmd = (VerUsuariosComando) commandGetUsuarios;

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
            UsuarioObjet.set_errorCode(550);
            UsuarioObjet.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(UsuarioObjet);
        } catch (BdConnectException e) {
            e.printStackTrace();
            UsuarioObjet.set_errorCode(550);
            UsuarioObjet.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(UsuarioObjet);
        }

    }



    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/usuarioEspecifco")
    @Produces("text/plain")
    public String usuarioEspecifico(@QueryParam("usucorreo") String usucorreo)
    {
        Entity UsuarioObject = EntityFactory.getUsuarioEspecifico(usucorreo);
        Command commandGetUsuarioEspecifico = CommandsFactory.instanciateGetUsuarioEspecifico(UsuarioObject);
        GetUsuarioEspecifico cmd = (GetUsuarioEspecifico) commandGetUsuarioEspecifico;

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
            UsuarioObject.set_errorCode(550);
            UsuarioObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(UsuarioObject);
        } catch (BdConnectException e) {
            e.printStackTrace();
            UsuarioObject.set_errorCode(550);
            UsuarioObject.set_errorMsg(e.ERROR_MSG);
            logger.error("Metodo: {} {}", "getTrainingDetail", e.toString());
            return gson.toJson(UsuarioObject);
        }

    }

}