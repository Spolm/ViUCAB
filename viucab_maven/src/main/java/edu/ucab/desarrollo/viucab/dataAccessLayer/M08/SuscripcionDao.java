package edu.ucab.desarrollo.viucab.dataAccessLayer.M08;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Suscripcion;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import org.postgresql.util.PSQLException;

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
     * @throws PLConnectException1 , BDConnectException1 Exepcion personalizada
     */
    public ArrayList<Usuario> listaUsuarios() throws BDConnectException1, PLConnectException1 {
        CallableStatement preStatement = null;
        //Creando la lista q corresponde a usuarios
        ArrayList<Usuario> listaUsers  = new ArrayList<>();

        ResultSet resultSet = null;
        Usuario usuario;
        Connection conn;
        try {

            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SPa
            preStatement = conn.prepareCall("{call m08_get_usuarios()}");
            //Metiendo los parametros al SP
           // preStatement.setInt(1,idUsuario);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("idusuario");
                String login = resultSet.getString("nombreusuario");
/**/
                usuario = EntityFactory.suscripcionUsuario(id, login);
                // usuario = EntityFactory.suscripcionUsuario(login);

                listaUsers.add(usuario);

                //usuario.setListaUsuario(listaSuscripcion);

            }
            resultSet.close();

        } catch (PSQLException e){   throw new PLConnectException1(e);     }
          catch (SQLException e) {   throw new BDConnectException1(e);       }
          catch (Exception e)    {   e.printStackTrace();    }
        finally {
            closeConnection();
        }
        return listaUsers;


    }
    /**
     * Carga las suscripciones de un Usuario
     *
     * @param
     * @return resultlist
     * @throws PLConnectException1 , BDConnectException1 Exepcion personalizada
     */
      public ArrayList<Usuario> listaSuscripciones(int idUsuario) throws BDConnectException1, PLConnectException1 {
        CallableStatement preStatement = null;
          //Creando la lista q corresponde a usuarios
        ArrayList<Usuario> listaSuscripcion  = new ArrayList<>();

        ResultSet resultSet = null;
        Usuario usuario;
        Connection conn;
        try {

            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m08_get_suscripciones(?)}");
            //Metiendo los parametros al SP
             preStatement.setInt(1,idUsuario);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();

            while (resultSet.next()) {

                  int id = resultSet.getInt("idusuario");
                  String login = resultSet.getString("nombreusuario");

                usuario = EntityFactory.suscripcionUsuario(id, login);

                listaSuscripcion.add(usuario);


            }
            resultSet.close();

        } catch (PSQLException e){   throw new PLConnectException1(e);     }
          catch (SQLException e) {   throw new BDConnectException1(e);       }
          catch (Exception e)    {   e.printStackTrace();    }
        finally {
            closeConnection();
        }
        return listaSuscripcion;


    }
    /**
     * Inserta una suscripcion al usuario logeado
     *
     * @param
     * @return resultlist
     * @throws PLConnectException1 , BDConnectException1 Exepcion personalizada
     */
    public String insertarSuscriptor (int idUsuario, int idsuscripcion) throws BDConnectException1, PLConnectException1 {
        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Suscripcion suscrip;
        Connection conn;
        String respuesta=null;
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
            return respuesta="lo inserto";
        }
          catch (PSQLException e){   throw new PLConnectException1(e);     }
          catch (SQLException e) {   throw new BDConnectException1(e);       }
          catch (Exception e)    {   e.printStackTrace();    }
        finally {
            closeConnection();
            if(respuesta==null) respuesta="ya esta insertado";
            return respuesta;
        }

    }

    /**
     * Elimina una suscripcion al usuario logeado
     *
     * @param
     * @return resultlist
     * @throws PLConnectException1 , BDConnectException1 Exepcion personalizada
     */
    public String eliminarSuscriptor (int idUsuario, int idsuscripcion) throws BDConnectException1, PLConnectException1 {
        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Suscripcion suscrip;
        Connection conn;
        String respuesta=null;
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
            return respuesta="lo elimino";

        }  catch (PSQLException e){   throw new PLConnectException1(e);     }
           catch (SQLException e) {   throw new BDConnectException1(e);       }
           catch (Exception e)    {   e.printStackTrace();    }
            finally {
            closeConnection();

            return respuesta;

        }

    }

    @Override
    public Entity suscripcion(Entity e) throws SQLException, BDConnectException1 {
        return null;
    }

    @Override
    public void agregarsuscripcion(int suscriptor, int suscripcion) throws SQLException, BDConnectException1 {

    }

    @Override
    public void eliminarsuscripcion(int suscriptor, int suscripcion) throws SQLException, BDConnectException1 {

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
