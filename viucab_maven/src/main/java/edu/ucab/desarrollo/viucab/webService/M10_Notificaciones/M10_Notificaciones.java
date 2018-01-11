package edu.ucab.desarrollo.viucab.webService.M10_Notificaciones;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones.DiscardNotificacion;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones.GetConfiguracion;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones.GetNotificaciones;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones.MailNotificacion;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.*;
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
    public Response obtenerNotificacion () {
        Response.ResponseBuilder rb = Response.status(Response.Status.ACCEPTED);
        Entity notificacionObject = EntityFactory.notificacion();
        Command commandNotificacion = CommandsFactory.instanciateGetNotificaciones(notificacionObject);
        GetNotificaciones cmd = (GetNotificaciones) commandNotificacion;
        cmd.execute();
        List<Entity> result = cmd.ReturnListNot();
        rb.header("Notifications","Success");
        rb.tag("application/json");
        rb.entity(gson.toJson(result));
        //return gson.toJson(result);
        return rb.build();
    }






    //Desechar Notificacion
    @GET
    @Path("/notificacionDes")
    @Consumes("application/json")
    @Produces("text/plain")
    public Response desecharNotificacion (int id) throws  SQLException {
        Response.ResponseBuilder rb = Response.status(Response.Status.ACCEPTED);
        Entity notificacionObject = EntityFactory.notificacion(id);
        Command commandNotificacion = CommandsFactory.instanciateDiscardNotificacion(notificacionObject);
        DiscardNotificacion cmd = (DiscardNotificacion) commandNotificacion;
        cmd.execute();
        Entity result = cmd.Return();
        rb.header("Notification Discarded","Success");
        rb.tag("application/json");
        rb.entity(gson.toJson(result));
        return rb.build();
        /*JsonObject jsonDatos = gson.fromJson( datos, JsonObject.class);
        PreparedStatement ps = conexion.prepareCall( "{? = CALL m10_desecharnotificacion()}");
        ps.setInt(1,jsonDatos.get("not_id").getAsInt());
        ps.executeUpdate();
        Sql.bdClose(conexion);
        return _response;*/
    }


    //Configuracion de Notificaciones
    //Configuracion de Notificaciones
    @GET
    @Path("/configuracion")
    @Produces("application/json")
    public Response obtenerConfiguracion (){
        Response.ResponseBuilder rb = Response.status(Response.Status.ACCEPTED);
        Entity configuracionObject = EntityFactory.configuracionNotificaciones();
        Command commandConfiguracion = CommandsFactory.instanciateGetConfiguracion(configuracionObject);
        GetConfiguracion cmd = (GetConfiguracion) commandConfiguracion;
        cmd.execute();
        List<Entity> result = cmd.ReturnListCon();
//        System.out.println(result);
        rb.header("Notifications","Success");
        rb.tag("application/json");
        rb.entity(gson.toJson(result));

        return (rb.build());
    }

    @POST
    @Path("/configuracion")
    @Consumes("application/json")
    @Produces("text/plain")
    //@QueryParam("id") String id

    public Response guardarConfiguracion(String datos) throws SQLException {
        Response.ResponseBuilder rb = Response.status(Response.Status.ACCEPTED);
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
        rb.header("Notifications","Success");
        rb.tag("application/json");
        rb.entity(gson.toJson(datos));
        return rb.build();

    }

}
