package edu.ucab.desarrollo.viucab.webService.M10_Notificaciones;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Notificacion;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import javax.ws.rs.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


@Path("/Notificaciones")
public class M10_Notificaciones {
    Gson gson = new Gson();
    Connection conexion = Sql.getConInstance();


    @GET
    @Path("/notificacion")
    @Produces("application/json")
    //Recibe como parametro el id del usuario que inicio sesion
    public String obtenerNotificacion (@QueryParam("id")  int id){

        String select="SELECT * FROM notificacion WHERE (not_desechado=false)";
        String selectVideo="SELECT * FROM video WHERE (vid_id = VALUES(?));";
        try{
            ArrayList<Notificacion> listaNotificaciones= new ArrayList<>();
            Statement st = conexion.createStatement();
            ResultSet result =  st.executeQuery(select);
            Video notVideo= new Video();

            while(result.next()){
                Notificacion not = new Notificacion();
                not.setId(result.getInt("not_id"));
                not.setFecha(result.getDate("not_fecha"));
                not.setDesechado(result.getBoolean("not_desechada"));
            }

            return gson.toJson(listaNotificaciones);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Sql.bdClose(conexion);
        }
        //Mientras
        return select;
    }
}
