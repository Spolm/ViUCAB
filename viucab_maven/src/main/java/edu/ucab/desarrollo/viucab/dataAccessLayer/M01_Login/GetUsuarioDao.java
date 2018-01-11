package edu.ucab.desarrollo.viucab.dataAccessLayer.M01_Login;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M01_Login.IDaoUsuarios;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public class GetUsuarioDao extends Dao implements IDaoUsuarios {

    public GetUsuarioDao() {

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
     * Metodo para Agregar un usuario y devolver t o f
     * @param e
     * @return
     * @throws SQLException
     */
    public Boolean addUsuario (Entity e) throws SQLException {

        /*EN LA BD LA FUNCION RECIBE ESTO =
        username character varying, claveusu character varying, correousu character varying*/

        Usuario usu = (Usuario) e;
        String username = usu.get_name_user();
        String claveusu = usu.get_pass_user();
        String correousu = usu.get_email_user();

        Boolean insertado = false;

        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m01_agregarusuario(?,?,?)}"); //HAY QUE AGREGAR ESTE METODO A POSTGRE
            //Seteo lo que le estoy mandando al procedimiento con ese "?"
            preStatement.setString(1,username);
            preStatement.setString(2,claveusu);
            preStatement.setString(3,correousu);

            //Ejecucion del query
            resultSet = preStatement.executeQuery();

            if (resultSet.next())
                insertado = true;


            resultSet.close();

        } catch (SQLException e1) {
            //throw new ViUcabException(e1.mensaje, e1.codigo);

            System. out. println(e1.getMessage());
        }
        catch(Exception ex)
        {
            //throw new ViUcabException(e1.mensaje, e1.codigo);
        }
        finally {
            closeConnection();
        }
        return insertado;
    }


    /**
     * Metodo DAO para Mostrar todos los usuarios
     * @param e
     * @return
     * @throws SQLException
     */
    public ArrayList<Entity> verusuario(Entity e) throws SQLException {

        ArrayList<Entity> lista1= new ArrayList<>();
        Usuario usu = (Usuario) e;
        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m01_verusuarios}"); //HAY QUE AGREGAR ESTE METODO A POSTGRE
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {

                String username = resultSet.getString("usu_login");
                String claveusu = resultSet.getString("usu_clave");
                String correousu = resultSet.getString("usu_correo");
                usu = (Usuario) EntityFactory.addUsuario(username,claveusu,correousu);

            }
            resultSet.close();

        } catch (SQLException e1) {
            //throw new ViUcabException(e1.mensaje, e1.codigo);

            System. out. println(e1.getMessage());
        }
        catch(Exception ex)
        {
            //throw new ViUcabException(e1.mensaje, e1.codigo);
        }
        finally {
            closeConnection();
        }
        return lista1;
    }


    /**
     * Metodo DAO para obtener una lista en especifico
     * @param e
     * @return
     * @throws SQLException
     */
    public Entity GetusuarioEspecifico (Entity e) throws SQLException {

        Usuario lista = (Usuario) e;
        String correoUsuarioBuscado = lista.get_email_user();
        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m01_usuarioespecifico(?)}"); //HAY QUE AGREGAR ESTE METODO A POSTGRE
            //Seteo lo que le estoy mandando al procedimiento con ese "?"
            preStatement.setString(1,correoUsuarioBuscado);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {

                String usucorreo = resultSet.getString("usu_correo");


                lista = (Usuario) EntityFactory.getUsuarioEspecifico(usucorreo);

            }
            resultSet.close();

        } catch (SQLException e1) {
            //throw new ViUcabException(e1.mensaje, e1.codigo);

            System. out. println(e1.getMessage());
        }
        catch(Exception ex)
        {
            //throw new ViUcabException(e1.mensaje, e1.codigo);
        }
        finally {
            closeConnection();
        }
        return lista;
    }




}