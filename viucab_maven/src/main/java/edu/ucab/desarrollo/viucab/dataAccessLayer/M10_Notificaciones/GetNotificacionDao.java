package edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import edu.ucab.desarrollo.viucab.common.entities.*;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;

import java.sql.*;
import java.util.ArrayList;


public class GetNotificacionDao extends Dao implements IDaoNotificacion {
    @Override
    public Entity notificacion(Entity e) throws SQLException {
        return null;
    }

    public Entity getNotificacion (Entity n) throws SQLException {
        Notificacion not = (Notificacion) n;

        Video vid = new Video();
        Usuario usu = new Usuario();

        try{
            Connection conn = getBdConnect();
            PreparedStatement st = conn.prepareCall("{call m10_getnotificaciones(?)}");

            st.setInt(1, 1);

            ResultSet result = st.executeQuery();

            while (result.next()) {
                int id = (result.getInt("n.not_id"));
                Date fecha = (result.getDate("n.not_fecha"));
                boolean desechado = (result.getBoolean("n.not_desechado"));

                String nombreUsu = (result.getString("u.usu_login"));
                String nombreVid = (result.getString("v.vid_titulo"));
                String descripcion = (result.getString("v.vid_descripcion"));
                String url = (result.getString("v.vid_url"));
                String imagen = (result.getString("v.vid_imagen"));
                usu.set_name_user(nombreUsu);
                vid.setNombre(nombreVid);
                vid.setDescripcion(descripcion);
                vid.setUrl(url);
                vid.setImagen(imagen);
                not = EntityFactory.notificacion(id, vid, usu, desechado, fecha);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        } System.out.println(not);
        return not;
    }

    /**Metodo para obtener todas las notificaciones para un usuario loggeado
     *
     * @param n
     * @return ArrayList<Notificacion>
     * @throws SQLException
     */

    @Override
    public ArrayList<Notificacion> obtenerNotificaciones(Entity n) throws SQLException {
        Notificacion not = (Notificacion) n;
        ArrayList<Notificacion> listaNotif = new ArrayList<>();
        PreparedStatement preStatement;
        ResultSet result;
    try {
        Connection conexion = Dao.getBdConnect();

        //Invocando el SP
        preStatement = conexion.prepareCall("{call m10_getnotificaciones(?)}");
        //Metiendo los parametros al SP
        preStatement.setInt(1, 1);
        //Ejecucion del query
        result = preStatement.executeQuery();
        while(result.next()){
            int _idNot = result.getInt("not_id");
            Date _fechaNot = result.getDate("not_fecha");
            Boolean _desechado = result.getBoolean("not_desechado");
            String _tituloVid = result.getString("vid_titulo");
            String _imagenVid = result.getString("vid_imagen");
            String _descripcionVid = result.getString("vid_descripcion");
            String _urlVid = result.getString("vid_url");
            String _userName = result.getString("usu_login");
            Video vid = new Video();
            Usuario usu = new Usuario();
            vid.setImagen(_imagenVid);
            vid.setUrl(_urlVid);
            vid.setDescripcion(_descripcionVid);
            vid.setNombre(_tituloVid);
            usu.set_name_user(_userName);
            Notificacion notif = EntityFactory.notificacion(_idNot, vid, usu, _desechado, _fechaNot);
            listaNotif.add(notif);
        }
        result.close();
    }
    catch (SQLException e) {
        e.printStackTrace();
        }
    finally {
        closeConnection();
        }
        return listaNotif;
    }

    public int descartarNotificacion (Entity n) throws SQLException {
        Gson gson = new Gson();
        Connection conexion = Dao.getBdConnect();
        JsonObject jsonDatos = gson.fromJson( String.valueOf(n), JsonObject.class);
        PreparedStatement ps = conexion.prepareCall( "{? = CALL m10_desecharnotificacion()}");
        int id = jsonDatos.get("not_id").getAsInt();
        ps.setInt(1, id );
        ps.executeQuery();
        int result = jsonDatos.get("not_id").getAsInt();
        closeConnection();
        return  result;
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
