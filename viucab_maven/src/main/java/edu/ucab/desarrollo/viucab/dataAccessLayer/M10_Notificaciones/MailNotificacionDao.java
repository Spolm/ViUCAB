package edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones;

import edu.ucab.desarrollo.viucab.common.entities.*;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;

import java.sql.*;

public class MailNotificacionDao extends Dao implements IDaoMailNotificacion {

    @Override
    public Notificacion mailNotificacion (Entity e, String cliente, String suscripcion) throws SQLException{
        Notificacion mailNot = (Notificacion) e;
        Video vid = new Video();
        Usuario client = new Usuario();
        Usuario suscript = new Usuario();

        String usuarioCliente= null;
        String correo = null;
        String usuarioSuscripcion= null;
        String video= null;
        String image= null;
        try{
            Connection conexion = getBdConnect();
            Statement stmt = conexion.createStatement();
            PreparedStatement st = conexion.prepareCall("{ call m10_sendmailnotificacion(?) }");
            st.setInt(1, Integer.parseInt(cliente));
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                usuarioCliente = rs.getString(2);
                correo = rs.getString(6);
            }
            st.setInt(1,Integer.parseInt(suscripcion));
            rs = st.executeQuery();
            if(rs.next()){
                usuarioSuscripcion = rs.getString(2);
            }
            st = conexion.prepareCall( "{ call m10_sendvideonotificacion(?)}");
            st.setInt(1, Integer.parseInt(suscripcion));
            ResultSet rs2 = st.executeQuery();
            if (rs2.next()){
                video = rs2.getString(2);
                image = rs2.getString(8);
            }
            client.set_name_user(usuarioCliente);
            client.set_email_user(correo);
            suscript.set_name_user(usuarioSuscripcion);
            vid.setNombre(video);
            vid.setImagen(image);
            /*MailNotificacion mail = new MailNotificacion();
            mail.enviarNotificacion(correo,"Hola " + usuarioCliente + " nos complace notificarle que sus suscripciones han generado actividad ultimamente:\n El usuario " + usuarioSuscripcion +" ha subido un nuevo video titulado: "+video,"Actividad reciente", image);*/
            rs.close();
            rs2.close();
            stmt.close();
            mailNot = EntityFactory.notificacionCorreo(client,suscript,vid);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return mailNot;
    }

    @Override
    public Entity create(Entity e) {
        return null;
    }

    @Override
    public Entity read(Entity e) {
        return null;
    }

    @Override
    public Entity update(Entity e) {
        return null;
    }
}
