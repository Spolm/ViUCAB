package edu.ucab.desarrollo.viucab.webService.M09_Sugerencias;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.common.exceptions.MessageException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.FabricaComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasLikeComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasSuscripcionesComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;

@Path("/Sugerencias")
public class M09_Sugerencias {

    Gson gson = new Gson();
    Connection con;

    @GET
    @Path("/get_sugerencias-likes")
    //@Produces("Application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSugerenciasLikes(@QueryParam("id") int id_usuario, @QueryParam("categoria") String categoria) {

        Entity respuesta = new Entity();
        try {
            FabricaComando fabrica = new FabricaComando();
            GetSugerenciasLikeComando comando = fabrica.FabricarComando1();
            return comando.execute(id_usuario, categoria);
        }
        //Tiene que manejar esta excepcion ya que mas abajo hay metodos con SQL
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (MessageException ex)
        {
            //respuesta.set_errorCode(ex.getMessage());

        }

    }

    @GET
    @Path("/get_sugerencias-suscripciones")
    //@Produces("Application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSugerenciasSuscripciones(@QueryParam("id") int id_usuario, @QueryParam("categoria") String categoria)  {
        try {
            FabricaComando fabrica = new FabricaComando();
            GetSugerenciasSuscripcionesComando comando2 = fabrica.FabricarComando3();
            return comando2.execute(id_usuario, categoria);
        }
        //Tiene que manejar esta excepcion ya que mas abajo hay metodos con SQL
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
