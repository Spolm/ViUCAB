package edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.*;

import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by estefania on 13/12/2017.
 */
public class GetHomeDao extends Dao implements IDaoHome {
        private static Logger logger = LoggerFactory.getLogger(GetHomeDao.class );
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
     * @throws SQLException,VIUCABException
     */
    @Override
    public ArrayList<Video> GetMasVistosComando() throws SQLException,VIUCABException {
        Video video;
        CallableStatement preStatement = null;
        ArrayList<Video> listaVideos= new ArrayList<>();
        ResultSet resultSet = null;

        Connection conn;

        try {

            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m02_obtenermasvistos()}");
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("idvideo");
                String nombre = resultSet.getString("nombrevideo");
                String descripcion = resultSet.getString("descripcionvideo");
                String imagen = resultSet.getString("imagenvideo");
                String url = resultSet.getString("urlvideo");
                String fecha = resultSet.getString("fechavideo");
                int visitas = resultSet.getInt("visitasvideo");
                String nombreusu = resultSet.getString("nombreusuario");
                String imagenusuario = resultSet.getString("imagenusuario");


                video = (Video) EntityFactory.homeVideo(id, nombre, descripcion, imagen, url, fecha, visitas,nombreusu,imagenusuario);
                listaVideos.add(video);


            }
            resultSet.close();

        }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
        catch (Exception _e) {
            logger.error( "Metodo: {} {}", "getMasVistosComando", _e.toString() );
            throw new VIUCABException( _e );
        }
         finally {
            closeConnection();
        }
        return listaVideos;

    }
/*
    /**
     * Obtiene en funcion del id del usuario los videos que cumplan
     * con sus preferencias
     * @param entidad
     * @return resultlist
     */
    @Override
    public ArrayList<Video> GetPreferenciasComando(Entity entidad) throws VIUCABException,SQLException {
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
            preStatement.setInt(1, idU);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("idvideo");
                String nombre = resultSet.getString("nombrevideo");
                String descripcion = resultSet.getString("descripcionvideo");
                String imagen = resultSet.getString("imagenvideo");
                String url = resultSet.getString("urlvideo");
                String fecha = resultSet.getString("fechavideo");
                int visitas = resultSet.getInt("visitasvideo");
                String nombreusu = resultSet.getString("nombreusuario");
                String imagenusuario = resultSet.getString("imagenusuario");


                video = (Video) EntityFactory.homeVideo(id, nombre, descripcion, imagen, url, fecha, visitas, nombreusu, imagenusuario);
                resultlist.add(video);

            }
            resultSet.close();
        }
         catch (SQLException e1) {
                e1.printStackTrace();
            }
         catch (Exception _e) {
                logger.error( "Metodo: {} {}", "getPreferenciasComando", _e.toString() );
                throw new VIUCABException( _e );
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
    public ArrayList<Video> GetSuscritosComando(Entity entidad) throws VIUCABException,SQLException{

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
                int id = resultSet.getInt("idvideo");
                String nombre = resultSet.getString("nombrevideo");
                String descripcion = resultSet.getString("descripcionvideo");
                String imagen = resultSet.getString("imagenvideo");
                String url = resultSet.getString("urlvideo");
                String fecha = resultSet.getString("fechavideo");
                int visitas = resultSet.getInt("visitasvideo");
                String nombreusu = resultSet.getString("nombreusuario");
                String imagenusuario = resultSet.getString("imagenusuario");

                //Casteo del entity a video del resultado del sp
                video = (Video) EntityFactory.homeVideo(id, nombre, descripcion, imagen, url, fecha, visitas,nombreusu,imagenusuario);
                resultlist.add(video);

            }
            resultSet.close();

        }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
        catch (Exception _e) {
            logger.error( "Metodo: {} {}", "getSuscritosComando", _e.toString() );
            throw new VIUCABException( _e );
        }finally {
            closeConnection();
        }
        return resultlist;
    }


    /**
     * Realiza Busque por etiqueta titulo y/o categoria
     * @param entidad
     * @return resultlist
     */
    @Override
    public ArrayList<Video> GetBusquedaComando(Entity entidad) throws VIUCABException {
        CallableStatement preStatement = null;
        ArrayList<Video> resultlist = null;
        ResultSet resultSet = null;
        Video param = (Video) entidad;
        String parametroBusqueda= param.getBusqueda();

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
            preStatement.setString(1,parametroBusqueda);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idvideo");
                String nombre = resultSet.getString("nombrevideo");
                String descripcion = resultSet.getString("descripcionvideo");
                String imagen = resultSet.getString("imagenvideo");
                String url = resultSet.getString("urlvideo");
                String fecha = resultSet.getString("fechavideo");
                int visitas = resultSet.getInt("visitasvideo");
                String nombreusu = resultSet.getString("nombreusuario");
                String imagenusuario = resultSet.getString("fotousuario");


                video = (Video) EntityFactory.homeVideo(id, nombre, descripcion, imagen, url, fecha, visitas,nombreusu,imagenusuario);
                resultlist.add(video);

            }
            resultSet.close();

        }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
        catch (Exception _e) {
            logger.error( "Metodo: {} {}", "getBusquedaComando", _e.toString() );
            throw new VIUCABException( _e );
        }
        finally {
            closeConnection();
        }
        return resultlist;
    }

}
