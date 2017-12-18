package edu.ucab.desarrollo.viucab.webService.M10_Notificaciones;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.ConfiguracionNotificaciones;
import edu.ucab.desarrollo.viucab.common.entities.Notificacion;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import javax.ws.rs.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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


    //Configuracion de Notificaciones
    @GET
    @Path("/configuracion")
    @Produces("application/json")
//@QueryParam("id") String id
    public String obtenerConfiguracion (){

        String select="SELECT * FROM config_notificacion WHERE usu_id = ?;";
        try {
            PreparedStatement ps = conexion.prepareStatement(select);
            ps.setInt(1, 1);
            ResultSet result = ps.executeQuery();
            List<ConfiguracionNotificaciones> list = new ArrayList<ConfiguracionNotificaciones>();
            while(result.next()) {
                ConfiguracionNotificaciones config = new ConfiguracionNotificaciones();
                config.setId(result.getInt("con_not_id"));
                config.setBoletin(result.getBoolean("con_not_boletin"));
                config.setPreferencias(result.getBoolean("con_not_preferencias"));
                config.setActivado(result.getBoolean("con_not_recibir"));
                config.setSubscripciones(result.getBoolean("con_not_suscripciones"));
                config.setEtiquetados(result.getBoolean("con_not_etiquetado"));
                config.setEstadisticas(result.getBoolean("con_not_estadisticas"));
                list.add(config);
            }

            return gson.toJson(list);
        }
        catch (SQLException e){
            return e.getMessage();
        }
        finally {
            Sql.bdClose(conexion);
        }
    }
    @POST
    @Path("/configuracion")
    @Consumes("application/json")
    @Produces("text/plain")
    //@QueryParam("id") String id

    public String guardarConfiguracion(String datos){
        String select="UPDATE config_notificacion SET con_not_boletin ;";

            Sql.bdClose(conexion);
            return datos;

    }

}
