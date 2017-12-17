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
     * Metodo que busca los video con mas visitas
     * @return resultlist
     * @throws SQLException
     */
    @Override
    public ArrayList<Video> GetMasVistosComando() throws SQLException {
        Video video;
        CallableStatement preStatement = null;
        ArrayList<Video> resultlist = null;
        ResultSet resultSet = null;

        Connection conn;

        try {
            //Creando la lista q corresponde a videos
            resultlist = new ArrayList<Video>();
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

                video = (Video) EntityFactory.homeUsuario(id, nombre, descripcion, imagen, url, fecha, visitas);
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
     * Obtiene en funcion del id del usuario los videos que cumplan
     * con sus preferencias
     * @param entidad
     * @return resultlist
     */
    @Override
    public ArrayList<Video> GetPreferenciasComando(Entity entidad) {
        Usuario usuario =(Usuario) entidad;
        int idU=usuario.get_id_user();
        Video video = null;
        CallableStatement preStatement = null;
        ArrayList<Video> resultlist = null;
        ResultSet resultSet = null;
        Connection conn;
        try {
            //Creando la lista q corresponde a videos
            resultlist = new ArrayList<Video>();
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m02_obtenerpreferencias(?)}");
            //Metiendo los parametros al SP
            preStatement.setInt(1,idU);
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

                video = (Video) EntityFactory.homeUsuario(id, nombre, descripcion, imagen, url, fecha, visitas);
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
     * Obtiene los ultimos videos que han sido subidos por los canales a los
     * que el usuario se encuentra suscrito
     * @param entidad
     * @return resultlist
     */
    @Override
    public ArrayList<Video> GetSuscritosComando(Entity entidad) {

        Usuario usuario =(Usuario) entidad;
        int idU=usuario.get_id_user();
        CallableStatement preStatement = null;
        ArrayList<Video> resultlist = null;
        ResultSet resultSet = null;
        Video video;
        Connection conn;
        try {
            //Creando la lista q corresponde a videos
            resultlist = new ArrayList<Video>();
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m02_obtenersuscripciones(?)}");
            //Metiendo los parametros al SP
            preStatement.setInt(1,idU);
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

                video = (Video) EntityFactory.homeUsuario(id, nombre, descripcion, imagen, url, fecha, visitas);
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
     * Realiza Busque por etiqueta titulo y/o categoria
     * @param parametro
     * @return resultlist
     */
    @Override
    public ArrayList<Video> GetBusquedaComando(String parametro) {
        CallableStatement preStatement = null;
        ArrayList<Video> resultlist = null;
        ResultSet resultSet = null;
        Video video;
        Connection conn;
        try {
            //Creando la lista q corresponde a videos
            resultlist = new ArrayList<Video>();
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m02_buscarvideo(?)}");
            //Metiendo los parametros al SP
            preStatement.setString(1,parametro);
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

                video = (Video) EntityFactory.homeUsuario(id, nombre, descripcion, imagen, url, fecha, visitas);
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
