package edu.ucab.desarrollo.viucab.webService.M09_Sugerencias;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasLikeComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasSuscripcionesComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.sql.*;
import java.util.ArrayList;

@Path("/Sugerencias")
public class M09_Sugerencias {

    Gson gson = new Gson();
    Connection con;

    @GET
    @Path("/get_sugerencias-likes")
    @Produces("Application/json")
    public String getSugerenciasLikes(@QueryParam("id") int id_usuario, @QueryParam("categoria") String categoria) throws SQLException {
        GetSugerenciasLikeComando g = new GetSugerenciasLikeComando();
        return g.execute(id_usuario, categoria);
    }

    @GET
    @Path("/get_sugerencias-suscripciones")
    @Produces("Application/json")
    public String getSugerenciasSuscripciones(@QueryParam("id") int id_usuario, @QueryParam("categoria") String categoria) throws SQLException {
        GetSugerenciasSuscripcionesComando g = new GetSugerenciasSuscripcionesComando();
        return g.execute(id_usuario, categoria);
    }
}
