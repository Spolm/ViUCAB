package edu.ucab.desarrollo.viucab.dataAccessLayer.M08;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Suscripcion;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import org.postgresql.util.PSQLException;

import java.awt.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public class SuscripcionDao extends Dao implements IDaoSuscripcion {
    public SuscripcionDao(Entity est) {
    }

    public SuscripcionDao() {

    }

    /**
     * Carga las suscripciones de un Usuario
     *
     * @param
     * @return resultlist
     */
      public ArrayList<Usuario> listaSuscripciones(int idUsuario) {
        CallableStatement preStatement = null;
        ArrayList<Usuario> resultlist = null;
        ResultSet resultSet = null;
        Usuario usuario;
        Connection conn;
        try {
            //Creando la lista q corresponde a usuarios
            resultlist = new ArrayList<Usuario>();
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m08_get_suscripciones(?)}");
            //Metiendo los parametros al SP
             preStatement.setInt(1,idUsuario);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
             
                  String login = resultSet.getString("USU_LOGIN");
                  //String avatar = resultSet.getString("USU_AVATAR");

/**/
                 usuario = EntityFactory.suscripcionUsuario(login /*, avatar*/);
                 resultlist.add(usuario);
                 usuario.setListaUsuario(resultlist);

            }
            resultSet.close();

        } catch (PSQLException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return resultlist;

    }
    /**
     * Inserta una suscripcion al usuario logeado
     *
     * @param
     * @return resultlist
     */
    public void insertarSuscriptor (int idUsuario, int idsuscripcion){
        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Suscripcion suscrip;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m08_set_Subscritor(?,?)}");
            //Metiendo los parametros al SP
            preStatement.setInt(1,idUsuario);
            preStatement.setInt(2,idsuscripcion);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();

            resultSet.close();

        } catch (PSQLException e){
            e.printStackTrace(); //Excepcion si ocuerre algun error con el SP
        } catch (SQLException e) {
            e.printStackTrace(); //Excepcion si ocuerre algun error con la BD
        } catch (Exception e){
            e.printStackTrace(); //Excepcion GENERICA
        } finally {
            closeConnection();
        }

    }

    /**
     * Elimina una suscripcion al usuario logeado
     *
     * @param
     * @return resultlist
     */
    public void eliminarSuscriptor (int idUsuario, int idsuscripcion){
        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Suscripcion suscrip;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m08_update_Subscritor(?,?)}");
            //Metiendo los parametros al SP
            preStatement.setInt(1,idUsuario);
            preStatement.setInt(2,idsuscripcion);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();

            resultSet.close();

        } catch (PSQLException e){
            e.printStackTrace(); //Excepcion si ocuerre algun error con el SP
        } catch (SQLException e) {
            e.printStackTrace(); //Excepcion si ocuerre algun error con la BD
        } catch (Exception e){
            e.printStackTrace(); //Excepcion GENERICA
        } finally {
            closeConnection();
        }

    }

    @Override
    public Entity suscripcion(Entity e) throws SQLException, BdConnectException {
        return null;
    }

    @Override
    public void agregarsuscripcion(int suscriptor, int suscripcion) throws SQLException, BdConnectException {

    }

    @Override
    public void eliminarsuscripcion(int suscriptor, int suscripcion) throws SQLException, BdConnectException {

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
