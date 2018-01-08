package edu.ucab.desarrollo.viucab.webService.M12_ConfiguracionContenido;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetPreferenciasComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import edu.ucab.desarrollo.viucab.webService.M02_Home.CrossOrigin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by estefania on 27/11/2017.
 */

@Path("/Moderacion")

public class M12_ConfiguracionContenido{

    Gson gson = new Gson();
    Connection conn= Sql.getConInstance();

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/prueba")
    @Produces("application/json")
    /**
     * @Param id
     * Devuelve todos los Videos dado un id
     */
    public String prueba (){
        String query = "select * from usuario";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario u = null;
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
             u = new Usuario();
            while(rs.next()){
                u.set_id(rs.getInt("usu_id"));
                u.set_name_user(rs.getString("usu_login"));
            }
        } catch (SQLException e) {
            return (gson.toJson("error"));
        }
        finally {
            Sql.bdClose(conn);
        }
        
    return gson.toJson(u);

    }


}
