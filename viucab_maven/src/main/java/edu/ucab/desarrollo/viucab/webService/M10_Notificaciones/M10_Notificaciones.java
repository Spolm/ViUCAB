package edu.ucab.desarrollo.viucab.webService.M10_Notificaciones;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.exceptions.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones.DiscardNotificacion;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones.GetConfiguracion;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones.GetNotificaciones;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones.MailNotificacion;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.*;
import java.util.List;


@Path("/Notificaciones")
public class M10_Notificaciones {
    private static Logger logger = LoggerFactory.getLogger( M10_Notificaciones.class );
    Gson gson = new Gson();
    Connection conexion = Sql.getConInstance();
    private Response _response;

    @GET
    @Path("/notificacion")
    @Produces("application/json")
    //Recibe como parametro el id del usuario que inicio sesion
    public Response obtenerNotificacion () {
        Response.ResponseBuilder rb = Response.status(Response.Status.ACCEPTED);
        Entity notificacionObject = EntityFactory.notificacion();
        Command commandNotificacion = CommandsFactory.instanciateGetNotificaciones(notificacionObject);
        GetNotificaciones cmd = (GetNotificaciones) commandNotificacion;
        try {
            cmd.execute();
            List<Entity> result = cmd.ReturnListNot();
            rb.header("Notifications","Success");
            rb.tag("application/json");
            rb.entity(gson.toJson(result));
            //return gson.toJson(result);
        }
        catch ( VIUCABException e) {
            notificacionObject.set_errorCode(e.ERROR_CODE);
            notificacionObject.set_errorMsg(e.ERROR_MSG);
            rb.header("Notificaciones","ERROR");
        } catch (BDConnectException1 e) {
            e.printStackTrace();
        } catch (PLConnectException1 e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return rb.build();
    }

    //Desechar Notificacion
    @GET
    @Path("/notificacionDes")
    @Consumes("application/json")
    @Produces("text/plain")
    public Response desecharNotificacion (int id) {
        Response.ResponseBuilder rb = Response.status(Response.Status.ACCEPTED);
        Entity notificacionObject = EntityFactory.notificacion(id);
        Command commandNotificacion = CommandsFactory.instanciateDiscardNotificacion(notificacionObject);
        DiscardNotificacion cmd = (DiscardNotificacion) commandNotificacion;
        try {
        cmd.execute();
        Entity result = cmd.Return();
        rb.header("Notification Discarded","Success");
        rb.tag("application/json");
        rb.entity(gson.toJson(result));
        } catch (VIUCABException e) {
            notificacionObject.set_errorCode(e.ERROR_CODE);
            notificacionObject.set_errorMsg(e.ERROR_MSG);
            rb.header("Notificaciones","ERROR");
        } catch (BDConnectException1 e) {
            e.printStackTrace();
        } catch (PLConnectException1 e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public Response obtenerConfiguracion () {
        Response.ResponseBuilder rb = Response.status(Response.Status.ACCEPTED);
        Entity configuracionObject = EntityFactory.configuracionNotificaciones();
        Command commandConfiguracion = CommandsFactory.instanciateGetConfiguracion(configuracionObject);
        GetConfiguracion cmd = (GetConfiguracion) commandConfiguracion;
        try {
            cmd.execute();
            List<Entity> result = cmd.ReturnListCon();
//        System.out.println(result);
            rb.header("Notifications", "Success");
            rb.tag("application/json");
            rb.entity(gson.toJson(result));
        }
        catch (VIUCABException e) {
            configuracionObject.set_errorCode(e.ERROR_CODE);
            configuracionObject.set_errorMsg(e.ERROR_MSG);
            rb.header("Notificaciones","ERROR");
        } catch (BDConnectException1 e) {
            e.printStackTrace();
        } catch (PLConnectException1 e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @POST
    @Path("/notificacionMail")
    @Produces("application/json")
    public Response enviarMail (@QueryParam("userCliId") String userCli, @QueryParam("userSuscrId") String userSuscr){
        Response.ResponseBuilder rb = Response.status(Response.Status.ACCEPTED);
        String usuarioCliente= null;
        String correo = null;
        String usuarioSuscripcion= null;
        String video= null;
        String image= null;
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
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM video WHERE usu_id = " + userSuscr);
            if (rs2.next()){
                video = rs2.getString(2);
                image = rs2.getString(8);
            }
            MailNotificacion mail = new MailNotificacion();
            mail.enviarNotificacion(correo,"Hola " + usuarioCliente + " nos complace notificarle que sus suscripciones han generado actividad ultimamente:\n El usuario " + usuarioSuscripcion +" ha subido un nuevo video titulado: "+video,"Actividad reciente", image);
            rs.close();
            rs2.close();
            stmt.close();
            rb.header("Content-Type","application/json");
            rb.entity("El mensaje ha sido enviado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Sql.bdClose(conexion);
        }
        return rb.build();
    }
}
