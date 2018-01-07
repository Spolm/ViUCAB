package edu.ucab.desarrollo.viucab.webService.M10_Notificaciones;

import com.google.gson.*;
import edu.ucab.desarrollo.viucab.common.entities.ConfiguracionNotificaciones;
import edu.ucab.desarrollo.viucab.common.entities.Notificacion;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones.MailNotificacion;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import org.apache.http.client.HttpClient;
import org.apache.http.protocol.HTTP;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Path("/Notificaciones")
public class M10_Notificaciones {
    Gson gson = new Gson();
    Connection conexion = Sql.getConInstance();

    @POST
    @Path("/notificacionMail")
    @Produces("application/json")
    public Response enviarMail (@QueryParam("userCliId") String userCli, @QueryParam("userSuscrId") String userSuscr){
        Response.ResponseBuilder rb = Response.status(Response.Status.ACCEPTED);
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
            rb.header("El webo","Peludo?");
            rb.tag("mochalo");
            rb.entity("Me pica elwe");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Sql.bdClose(conexion);
        }
        return rb.build();
    }


    @GET
    @Path("/notificacion")
    @Produces("application/json")
    //Recibe como parametro el id del usuario que inicio sesion
    public String obtenerNotificacion (){

        String select="SELECT n.not_id, n.not_fecha, n.not_desechado, v.vid_url, v.vid_imagen, v.vid_titulo, " +
                "v.vid_descripcion, u.usu_login " +
                "FROM notificacion n, video v, usuario u " +
                "WHERE (not_desechado=false and n.vid_id=v.vid_id and n.usu_id=1 and v.usu_id= u.usu_id) " +
                "ORDER BY not_fecha DESC";

        try{
            ArrayList<Notificacion> listaNotificaciones = new ArrayList<>();
            Statement st = conexion.createStatement();
            ResultSet result =  st.executeQuery(select);


            while(result.next()){
                Notificacion not = new Notificacion();
                Video vid= new Video();
                Usuario usu = new Usuario();
                vid.setUrl(result.getString( "vid_url"));
                vid.setDescripcion(result.getString("vid_descripcion"));
                vid.setImagen(result.getString("vid_imagen"));
                vid.setNombre(result.getString("vid_titulo"));
                usu.set_name_user(result.getString("usu_login"));
                not.setId(result.getInt("not_id"));
                not.setVideo(vid);
                not.setUsuario(usu);
                not.setFecha(result.getDate("not_fecha"));
                not.setDesechado(result.getBoolean("not_desechado"));
                listaNotificaciones.add(not);

            }

            return gson.toJson(listaNotificaciones);

        } catch (SQLException e) {
            return e.getMessage();
        } finally {
            Sql.bdClose(conexion);
        }
    }

    //Desechar Notificacion
    @GET
    @Path("/notificacionDes")
    @Produces("application/json")
    public String desecharNotificacion ( String datos) throws  SQLException {
        JsonObject jsonDatos = gson.fromJson( datos, JsonObject.class);
        PreparedStatement ps = conexion.prepareStatement( "UPDATE notificacion SET not_desechado = true " +
                                                                "WHERE not_id = ?;");
        ps.setInt(1, jsonDatos.get("not_id").getAsInt());
        ps.executeQuery();
        Sql.bdClose(conexion);
        return datos;
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
                ConfiguracionNotificaciones config = new ConfiguracionNotificaciones(0,true,true,true,true,true,true);
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
