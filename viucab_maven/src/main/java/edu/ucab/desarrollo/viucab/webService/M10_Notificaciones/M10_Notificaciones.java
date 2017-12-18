package edu.ucab.desarrollo.viucab.webService.M10_Notificaciones;

import com.google.gson.*;
import edu.ucab.desarrollo.viucab.common.entities.ConfiguracionNotificaciones;
import edu.ucab.desarrollo.viucab.common.entities.Notificacion;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones.MailNotificacion;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import javax.ws.rs.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


                @Path("/Notificaciones")
                public class M10_Notificaciones {
                    Gson gson = new Gson();
                    Connection conexion = Sql.getConInstance();

                    @POST
                    @Path("/notificacionMail")
                    @Produces("text/plain")
                    public String obtenerWebo (@QueryParam("userCliId") String userCli, @QueryParam("userSuscrId") String userSuscr){

                        String usuarioCliente= null;
                        String correo = null;
                        String usuarioSuscripcion= null;
                        try{
                            Statement stmt = conexion.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE usu_id = " + userCli);
                            if(rs.next()){
                                usuarioCliente = rs.getString(2);
                                correo = rs.getString(6);
                            }
                            rs = stmt.executeQuery("SELECT * FROM usuario WHERE usu_id = " + userSuscr);
                            if(rs.next()){
                                usuarioSuscripcion = rs.getString(2);
                            }
            MailNotificacion mail = new MailNotificacion();
            mail.enviarNotificacion(correo,"Hola " + usuarioCliente + " nos complace notificarle que sus suscripciones han generado actividad ultimamente:\n El usuario " + usuarioSuscripcion +" ha subido un nuevo video titulado: Vamos a pasar desarrollo verdad?","Actividad reciente");
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Sql.bdClose(conexion);
        }
        return "Holiwis\n";
    }


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

    public String guardarConfiguracion(String datos) throws SQLException {
        JsonObject jsonDatos = gson.fromJson( datos, JsonObject.class);
        PreparedStatement ps = conexion.prepareStatement(
                "UPDATE config_notificacion SET " +
                        "con_not_boletin = ?, con_not_recibir =? , " +
                        "con_not_preferencias = ?, con_not_suscripciones = ?, " +
                        "con_not_etiquetado = ?, con_not_estadisticas =? " +
                        "WHERE con_not_id = ?;");
        ps.setBoolean(1,jsonDatos.get("boletin").getAsBoolean());
        ps.setBoolean(2,jsonDatos.get("notificaciones").getAsBoolean());
        ps.setBoolean(3,jsonDatos.get("recomendados").getAsBoolean());
        ps.setBoolean(4,jsonDatos.get("subscripciones").getAsBoolean());
        ps.setBoolean(5,jsonDatos.get("etiquetados").getAsBoolean());
        ps.setBoolean(6, jsonDatos.get("estadisticas").getAsBoolean());
        ps.setInt(7, jsonDatos.get("id").getAsInt());
        ps.executeQuery();
        Sql.bdClose(conexion);
        return datos;

    }

}
