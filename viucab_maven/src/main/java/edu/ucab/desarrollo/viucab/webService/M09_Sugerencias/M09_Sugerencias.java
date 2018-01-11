package edu.ucab.desarrollo.viucab.webService.M09_Sugerencias;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasLikeComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasSuscripcionComando;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/Sugerencias")
public class M09_Sugerencias {

    @GET
    @Path("/get_sugerencias-likes")
    //@Produces("Application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSugerenciasLikes(@QueryParam("id") int id_usuario, @QueryParam("categoria") String categoria)  {

        Entity respuesta = EntityFactory.instaciateVideo(id_usuario, categoria);
        Command cmd = CommandsFactory.instaciateSugerenciasLike(respuesta);
        GetSugerenciasLikeComando comando = (GetSugerenciasLikeComando) cmd;



           comando.execute();
           Entity result = cmd.Return();
           Gson gson = new Gson();
           Video v = (Video) result;
            ArrayList<Entity> lista =  comando.executeCommand();
            return gson.toJson(lista);

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
        Entity respuesta = EntityFactory.instaciateVideo(id_usuario, categoria);
        Command cmd = CommandsFactory.instaciateSugerenciasSuscripcion(respuesta);
        GetSugerenciasSuscripcionComando comando = (GetSugerenciasSuscripcionComando) cmd;

        try {
            comando.execute();
            Entity result = cmd.Return();
            Gson gson = new Gson();
            Video v = (Video) result;
            ArrayList<Entity> lista = comando.executeCommand();
            return gson.toJson(lista);
        } catch (BdConnectException e) {
            e.printStackTrace();
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
