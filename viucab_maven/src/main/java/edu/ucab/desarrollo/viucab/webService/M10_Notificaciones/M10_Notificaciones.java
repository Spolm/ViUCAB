package edu.ucab.desarrollo.viucab.webService.M10_Notificaciones;

import com.google.gson.*;
import edu.ucab.desarrollo.viucab.common.entities.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones.GetNotificaciones;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones.MailNotificacion;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Path("/Notificaciones")
public class M10_Notificaciones {
    Gson gson = new Gson();
    Connection conexion = Sql.getConInstance();
    private Response _response;
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

        Entity notificacionObject = EntityFactory.notificacion();
        Command commandNotificacion = CommandsFactory.instanciateGetNotificaciones(notificacionObject);
        GetNotificaciones cmd = (GetNotificaciones) commandNotificacion;
        cmd.execute();
        List<Entity> result = cmd.ReturnListNot();
        //List<Video_Etiq> json = new ArrayList<Video_Etiq>();
        //json.addAll((Collection<? extends Video_Etiq>) result);
        return gson.toJson(result);
    }

    /** Metodo que desecha la notificacion una vez se ha interactuado con ella
     *
     * @param datos
     * @return YES
     * @throws SQLException
     */
    //Desechar Notificacion
    @GET
    @Path("/notificacionDes")
    @Consumes("application/json")
    @Produces("text/plain")
    public Response desecharNotificacion (String datos) throws  SQLException {
        JsonObject jsonDatos = gson.fromJson( datos, JsonObject.class);
        PreparedStatement ps = conexion.prepareCall( "{? = CALL m10_desecharnotificacion()}");
        ps.setInt(1, 1/*jsonDatos.get("not_id").getAsInt()*/);
        ps.executeUpdate();
        Sql.bdClose(conexion);
        return _response;
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
        ps.executeUpdate();
        Sql.bdClose(conexion);
        return datos;

    }

}
