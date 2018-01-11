package edu.ucab.desarrollo.viucab.webService.M09_Sugerencias;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.MessageException;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M09_Sugerencias.GetSugerenciasDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasLikeComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.LoggerM09;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/Sugerencias")
public class M09_Sugerencias {

    final org.slf4j.Logger logger = LoggerFactory.getLogger(M09_Sugerencias.class);
    LoggerM09 log = new LoggerM09();

    public M09_Sugerencias(){

    }

    @GET
    @Path("/get_sugerencias-likes")
    //@Produces("Application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSugerenciasLikes(@QueryParam("id") int id_usuario, @QueryParam("categoria") String categoria)  {

        logger.info("WS sugerenciasLike", M09_Sugerencias.class);
        log.imprimirLogger("WS SugerenciasLike", "sugerenciaslike", "INFO");

        Entity respuesta = EntityFactory.instaciateVideo(id_usuario, categoria);
        Command cmd = CommandsFactory.instaciateSugerenciasLike(respuesta);
        GetSugerenciasLikeComando comando = (GetSugerenciasLikeComando) cmd;
        Gson gson = new Gson();

          try {
              comando.execute();

              ArrayList<Entity> lista = comando.executeCommand();
              return gson.toJson(lista);
          }
          catch (SQLException es){
              logger.error("WS sugerenciasSuscripciones-SQLException", M09_Sugerencias.class);
              log.imprimirLogger("WS SugerenciasSuscripciones", "sugerenciasSuscripciones-SQLException", "ERROR");
              es.printStackTrace();
          }
          catch (MessageException m){
              respuesta.set_errorCode(m.get_code());
              respuesta.set_errorMsg(m.getMessage());
              logger.error("WS sugerenciasSuscripciones-MessageException", M09_Sugerencias.class);
              log.imprimirLogger("WS SugerenciasSuscripciones", "sugerenciasSuscripciones-MessageEQxception", "ERROR");
              return gson.toJson(respuesta);
          }
          catch (VIUCABException e){
              respuesta.set_errorCode(e.ERROR_CODE);
              respuesta.set_errorMsg(e.ERROR_MSG);
              logger.error("WS sugerenciasSuscripciones-VIUCABExcepton", M09_Sugerencias.class);
              log.imprimirLogger("WS SugerenciasSuscripciones", "sugerenciasSuscripciones-Viucabexception", "ERROR");
              return gson.toJson(respuesta);
          }

          return null;
        //Tiene que manejar esta excepcion ya que mas abajo hay metodos con SQL
        /*catch (SQLException e) {
            e.printStackTrace();
        }
        catch (MessageException ex)
        {
            //respuesta.set_errorCode(ex.getMessage());

        }*/

    }

    @GET
    @Path("/get_sugerencias-suscripciones")
    //@Produces("Application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSugerenciasSuscripciones(@QueryParam("id") int id_usuario, @QueryParam("categoria") String categoria)  {

        logger.info("WS sugerenciasSuscripciones", M09_Sugerencias.class);
        log.imprimirLogger("WS SugerenciasSuscripciones", "sugerenciasSuscripciones", "INFO");

        Entity respuesta = EntityFactory.instaciateVideo(id_usuario, categoria);
        Command cmd = CommandsFactory.instaciateSugerenciasSuscripcion(respuesta);
        GetSugerenciasSuscripcionComando comando = (GetSugerenciasSuscripcionComando) cmd;
        Gson gson = new Gson();

        try {
            comando.execute();
            ArrayList<Entity> lista = comando.executeCommand();
            return gson.toJson(lista);
        }

        catch (SQLException es){
            logger.error("WS sugerenciasSuscripciones-SQLException", M09_Sugerencias.class);
            log.imprimirLogger("WS SugerenciasSuscripciones", "sugerenciasSuscripciones-SQLException", "ERROR");
            es.printStackTrace();
        }
        catch (MessageException m){
            respuesta.set_errorCode(m.get_code());
            respuesta.set_errorMsg(m.getMessage());
            logger.error("WS sugerenciasSuscripciones-MessageException", M09_Sugerencias.class);
            log.imprimirLogger("WS SugerenciasSuscripciones", "sugerenciasSuscripciones-MessageEQxception", "ERROR");
            return gson.toJson(respuesta);
        }
        catch (VIUCABException e){
            respuesta.set_errorCode(e.ERROR_CODE);
            respuesta.set_errorMsg(e.ERROR_MSG);
            logger.error("WS sugerenciasSuscripciones-VIUCABExcepton", M09_Sugerencias.class);
            log.imprimirLogger("WS SugerenciasSuscripciones", "sugerenciasSuscripciones-Viucabexception", "ERROR");
            return gson.toJson(respuesta);
        }


        //Tiene que manejar esta excepcion ya que mas abajo hay metodos con SQL
        /*catch (SQLException e) {
            e.printStackTrace();
        }
        catch (MessageException ex)
        {
            //respuesta.set_errorCode(ex.getMessage());

        }*/
       return null;

    }
}
