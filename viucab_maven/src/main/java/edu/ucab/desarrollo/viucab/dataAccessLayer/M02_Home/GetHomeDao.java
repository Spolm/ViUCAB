package edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.*;

import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by estefania on 13/12/2017.
 */
public class GetHomeDao extends Dao implements IDaoHome {
    Entity _entidad;

    public GetHomeDao (){

    }
    public GetHomeDao(Entity _entidad) {
        this._entidad = _entidad;
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

    /**
     * Carga los Videos Mas Vistosdel Sistema
     *
     * @param
     * @return resultlist
     */
    public ArrayList<VideoAux> listaVideoTop() {

        CallableStatement preStatement = null;
        ArrayList<VideoAux> resultlist = null;
        ResultSet resultSet = null;
        VideoAux video;
        Connection conn;

        try {
            //Creando la lista q corresponde a videos
            resultlist = new ArrayList<VideoAux>();
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m02_obtenermasvistos()}");
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("vid_id");
                String nombre = resultSet.getString("vid_titulo");
                String descripcion = resultSet.getString("vid_descripcion");
                String imagen = resultSet.getString("vid_imagen");
                String url = resultSet.getString("vid_url");
                String fecha = resultSet.getString("vid_fecha");
                int visitas = resultSet.getInt("vid_visitas");

                video = EntityFactory.homeUsuario(id, nombre, descripcion, imagen, url, fecha, visitas);
                resultlist.add(video);
                video.setListaVideo(resultlist);


            }
            resultSet.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            closeConnection();
        }
        return resultlist;
    }

    /**
     * Dado el id del usuario devuelve videos asoiados a sus preferencias
     *
     * @param idUsuario
     * @return resultlist
     */
    public ArrayList<VideoAux> listaVideoPreferencias(int idUsuario) {
        CallableStatement preStatement = null;
        ArrayList<VideoAux> resultlist = null;
        ResultSet resultSet = null;
        VideoAux video;
        Connection conn;
        try {
            //Creando la lista q corresponde a videos
            resultlist = new ArrayList<VideoAux>();
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m02_obtenerpreferencias(?)}");
            //Metiendo los parametros al SP
            preStatement.setInt(1,idUsuario);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("vid_id");
                String nombre = resultSet.getString("vid_titulo");
                String descripcion = resultSet.getString("vid_descripcion");
                String imagen = resultSet.getString("vid_imagen");
                String url = resultSet.getString("vid_url");
                String fecha = resultSet.getString("vid_fecha");
                int visitas = resultSet.getInt("vid_visitas");

                video = EntityFactory.homeUsuario(id, nombre, descripcion, imagen, url, fecha, visitas);
                resultlist.add(video);
                video.setListaVideo(resultlist);

            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return resultlist;
    }

    /**
     * Carga los ultimos videos subidos a canales a los que
     * el usuario esta suscrito
     * @param idUsuario
     * @return resultlist
     */
    public ArrayList<VideoAux> listaVideoSuscritos(int idUsuario) {
        CallableStatement preStatement = null;
        ArrayList<VideoAux> resultlist = null;
        ResultSet resultSet = null;
        VideoAux video;
        Connection conn;
        try {
            //Creando la lista q corresponde a videos
            resultlist = new ArrayList<VideoAux>();
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m02_obtenersuscripciones(?)}");
            //Metiendo los parametros al SP
            preStatement.setInt(1,idUsuario);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("vid_id");
                String nombre = resultSet.getString("vid_titulo");
                String descripcion = resultSet.getString("vid_descripcion");
                String imagen = resultSet.getString("vid_imagen");
                String url = resultSet.getString("vid_url");
                String fecha = resultSet.getString("vid_fecha");
                int visitas = resultSet.getInt("vid_visitas");

                video = EntityFactory.homeUsuario(id, nombre, descripcion, imagen, url, fecha, visitas);
                resultlist.add(video);
                video.setListaVideo(resultlist);

            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return resultlist;
    }

    /**
     * Realiza la busqueda de videos por titulo etiqueta o genero
     * @param Parametro
     * @return resultlist
     */
    public ArrayList<VideoAux> listaVideoBusqueda(String Parametro){
        CallableStatement preStatement = null;
        ArrayList<VideoAux> resultlist = null;
        ResultSet resultSet = null;
        VideoAux video;
        Connection conn;
        try {
            //Creando la lista q corresponde a videos
            resultlist = new ArrayList<VideoAux>();
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m02_buscarvideo(?)}");
            //Metiendo los parametros al SP
            preStatement.setString(1,Parametro);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("vid_id");
                String nombre = resultSet.getString("vid_titulo");
                String descripcion = resultSet.getString("vid_descripcion");
                String imagen = resultSet.getString("vid_imagen");
                String url = resultSet.getString("vid_url");
                String fecha = resultSet.getString("vid_fecha");
                int visitas = resultSet.getInt("vid_visitas");

                video = EntityFactory.homeUsuario(id, nombre, descripcion, imagen, url, fecha, visitas);
                resultlist.add(video);
                video.setListaVideo(resultlist);

            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return resultlist;

    }
}
