package edu.ucab.desarrollo.viucab.dataAccessLayer.M08;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Suscripcion;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.PlConnectException;
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
     * @throws PlConnectException , BdConnectException Exepcion personalizada
     */
    public ArrayList<Usuario> listaUsuarios() throws BdConnectException, PlConnectException {
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
                System.out.println("ESTO ES LO QUE TIENE EL OBJETO usuario"+usuario.get_name_user());
                listaUsers.add(usuario);
                System.out.println("ESTE ES LA LISTA-->  "+listaUsers);
                //usuario.setListaUsuario(listaSuscripcion);

            }
            resultSet.close();

        } catch (PSQLException e){
            e.printStackTrace();
            // throw new PlConnectException(e);
            //e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            // throw new BdConnectException (e);

        }
        catch (Exception e)
        {e.printStackTrace();
            // throw new BdConnectException (e);
        }
        finally {
            closeConnection();
        } System.out.println("AQUI IMPRIME EL RETURN DEL METODO OSEA LA LISTA"+listaUsers);
        return listaUsers;


    }
    /**
     * Carga las suscripciones de un Usuario
     *
     * @param
     * @return resultlist
     * @throws PlConnectException , BdConnectException Exepcion personalizada
     */
      public ArrayList<Usuario> listaSuscripciones(int idUsuario) throws BdConnectException, PlConnectException {
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

                 // Byte avatar = resultSet.getByte("imagenusuario");
                  //String avatar = resultSet.getString("USU_AVATAR");
                System.out.println("ESTO ES LO QUE ARROJA LA COSNSULTA---> "+ login);

/**/
                usuario = EntityFactory.suscripcionUsuario(id, login);
               // usuario = EntityFactory.suscripcionUsuario(login);
                System.out.println("ESTO ES LO QUE TIENE EL OBJETO usuario"+usuario.get_name_user());
                listaSuscripcion.add(usuario);
                System.out.println("ESTE ES LA LISTA-->  "+listaSuscripcion);
                //usuario.setListaUsuario(listaSuscripcion);

            }
            resultSet.close();

        } catch (PSQLException e){
            e.printStackTrace();
           // throw new PlConnectException(e);
            //e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
           // throw new BdConnectException (e);

        }
        catch (Exception e)
        {e.printStackTrace();
           // throw new BdConnectException (e);
        }
        finally {
            closeConnection();
        } System.out.println("AQUI IMPRIME EL RETURN DEL METODO OSEA LA LISTA"+listaSuscripcion);
        return listaSuscripcion;


    }
    /**
     * Inserta una suscripcion al usuario logeado
     *
     * @param
     * @return resultlist
     * @throws PlConnectException , BdConnectException Exepcion personalizada
     */
    public void insertarSuscriptor (int idUsuario, int idsuscripcion) throws BdConnectException, PlConnectException{
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

            throw new PlConnectException(e); //Excepcion si ocuerre algun error con el SP
            //e.printStackTrace();
        } catch (SQLException e) {

            throw new BdConnectException (e);//Excepcion si ocuerre algun error con la BD

        }
        catch (Exception e)
        {
            throw new BdConnectException (e); //Excepcion si ocuerre algun error con el SP
        } finally {
            closeConnection();
        }

    }

    /**
     * Elimina una suscripcion al usuario logeado
     *
     * @param
     * @return resultlist
     * @throws PlConnectException , BdConnectException Exepcion personalizada
     */
    public void eliminarSuscriptor (int idUsuario, int idsuscripcion) throws BdConnectException, PlConnectException{
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

            throw new PlConnectException(e); //Excepcion si ocuerre algun error con el SP
            //e.printStackTrace();
        } catch (SQLException e) {

            throw new BdConnectException (e);//Excepcion si ocuerre algun error con la BD

        }
        catch (Exception e)
        {
            throw new BdConnectException (e); //Excepcion si ocuerre algun error con el SP
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
