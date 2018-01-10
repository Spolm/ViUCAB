package edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.*;

import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public class GetListaDeReproduccionDao extends Dao implements IDaoListaDeReproducciones {

    public GetListaDeReproduccionDao() {

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
     * Carga la informacion de la lista
     *
     * @param
     * @return resultlist
     */
    public ArrayList<Entity> GetLista(Entity e) throws SQLException {

        ArrayList<Entity> listaContenedora= new ArrayList<>();
        ListaDeReproduccion lista = (ListaDeReproduccion) e;
        Integer idUsuario = lista.getIdUsuario();
        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call M05_OBTENERLISTA(?)}"); //HAY QUE AGREGAR ESTE METODO A POSTGRE
            //Seteo lo que le estoy mandando al procedimiento con ese "?"
            preStatement.setInt(1,idUsuario);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {

                int idLista = resultSet.getInt("LIS_REP_ID");
                String nombre = resultSet.getString("LIS_REP_NOMBRE");
                String descripcion = resultSet.getString("LIS_REP_DESCRIPCION");
                String imagen = resultSet.getString("LIS_REP_IMG");
                String fechaCreacion = resultSet.getString("LIS_REP_FECHA");
                int numReproducciones = resultSet.getInt("LIS_REP_NUMREP");
                int idUsuarioF = resultSet.getInt("id_usu");

                lista = (ListaDeReproduccion) EntityFactory.listaDeReproduccion(idLista, nombre, descripcion, imagen, numReproducciones, fechaCreacion, idUsuarioF);
                listaContenedora.add(lista);

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
        return listaContenedora;
    }

    /**
     * Metodo DAO para obtener una lista en especifico
     * @param e
     * @return
     * @throws SQLException
     */
    public Entity GetEspecificList(Entity e) throws SQLException {

        ListaDeReproduccion lista = (ListaDeReproduccion) e;
        Integer idListaBuscada = lista.getIdLista();
        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m05_obtenerlistaespecifica(?)}"); //HAY QUE AGREGAR ESTE METODO A POSTGRE
            //Seteo lo que le estoy mandando al procedimiento con ese "?"
            preStatement.setInt(1,idListaBuscada);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {

                int idLista = resultSet.getInt("LIS_REP_ID");
                String nombre = resultSet.getString("LIS_REP_NOMBRE");
                String descripcion = resultSet.getString("LIS_REP_DESCRIPCION");
                String imagen = resultSet.getString("LIS_REP_IMG");
                String fechaCreacion = resultSet.getString("LIS_REP_FECHA");
                int numReproducciones = resultSet.getInt("LIS_REP_NUMREP");
                int idUsuario = resultSet.getInt("id_usu");

                lista = (ListaDeReproduccion) EntityFactory.listaDeReproduccion(idLista, nombre, descripcion, imagen, numReproducciones, fechaCreacion, idUsuario);

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

    /**
     * Metodo para crear una lista
     * @param e
     * @return
     * @throws SQLException
     */
    public Boolean createLista(Entity e) throws SQLException {

        /*EN LA BD LA FUNCION RECIBE ESTO =
        lis_rep_nombre character varying, lis_rep_descripcion character varying,
        list_rep_img character varying, lis_rep_numrep integer, lis_rep_fecha date, id_usu integer*/

        ListaDeReproduccion lista = (ListaDeReproduccion) e;
        String lis_rep_nombre = lista.getNombre();
        String lis_rep_descripcion = lista.getDescripcion();
        String list_rep_img = lista.getUrlImg();
        Integer lis_rep_numrep = lista.getNumReproducciones();
        String lis_rep_fecha = lista.getFechaCreacion();
        Integer idUsuario = lista.getIdUsuario();
        Boolean insertado = false;

        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m05_crearlista(?,?,?,?,?,?)}"); //HAY QUE AGREGAR ESTE METODO A POSTGRE
            //Seteo lo que le estoy mandando al procedimiento con ese "?"
            preStatement.setString(1,lis_rep_nombre);
            preStatement.setString(2,lis_rep_descripcion);
            preStatement.setString(3,list_rep_img);
            preStatement.setInt(4,lis_rep_numrep);
            preStatement.setString(5, lis_rep_fecha);
            preStatement.setInt(6,idUsuario);

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
     * Metodo para actualizar una lista de reproduccion
     * @param e
     * @return
     * @throws SQLException
     */
    public Boolean modifyLista(Entity e) throws SQLException {


        ListaDeReproduccion lista = (ListaDeReproduccion) e;
        String lis_rep_nombre = lista.getNombre();
        String lis_rep_descripcion = lista.getDescripcion();
        String list_rep_img = lista.getUrlImg();
        Integer idListaModificar = lista.getIdLista();
        Boolean modificado = false;

        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m05_modificarLista(?,?,?,?)}");
            //Seteo lo que le estoy mandando al procedimiento con ese "?"
            preStatement.setInt(1,idListaModificar);
            preStatement.setString(2,lis_rep_nombre);
            preStatement.setString(3,lis_rep_descripcion);
            preStatement.setString(4,list_rep_img);

            //Ejecucion del query
            resultSet = preStatement.executeQuery();

            if (resultSet.next())
                modificado = true;


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
        return modificado;
    }


    /**
     *
     * @param e
     * @return
     * @throws SQLException
     */
    public Boolean deleteList(Entity e) throws SQLException {


        ListaDeReproduccion lista = (ListaDeReproduccion) e;
        Integer idListaEliminar = lista.getIdLista();
        Boolean eliminado = false;

        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m05_eliminarLista(?)}");
            //Seteo lo que le estoy mandando al procedimiento con ese "?"
            preStatement.setInt(1,idListaEliminar);

            //Ejecucion del query
            resultSet = preStatement.executeQuery();

            if (resultSet.next())
                eliminado = true;


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
        return eliminado;
    }


    /**
     * Metodo para agregar un video a una lista de reproduccion
     * @param e
     * @return
     * @throws SQLException
     */
    public Boolean addVideoToList(Entity e) throws SQLException {

        ListaDeReproduccion lista = (ListaDeReproduccion) e;
        Integer idLista = lista.getIdLista();
        Integer idVideo = lista.getIdUsuario(); //el id del video se guardo en el atributo idUsuario para aprovechar el objeto
        Boolean insertado = false;

        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m05_agregarVideoLista(?,?)}");
            //Seteo lo que le estoy mandando al procedimiento con ese "?"
            preStatement.setInt(1,idVideo);
            preStatement.setInt(2,idLista);

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
     * Metodo para eliminar un video de un alista de reproduccion
     * @param e
     * @return
     * @throws SQLException
     */
    public Boolean deleteVideoToList(Entity e) throws SQLException {

        ListaDeReproduccion lista = (ListaDeReproduccion) e;
        Integer idLista = lista.getIdLista();
        Integer idVideo = lista.getIdUsuario(); //el id del video se guardo en el atributo idUsuario para aprovechar el objeto
        Boolean eliminado = false;

        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m05_eliminarVideoLista(?,?)}");
            //Seteo lo que le estoy mandando al procedimiento con ese "?"
            preStatement.setInt(1,idVideo);
            preStatement.setInt(2,idLista);

            //Ejecucion del query
            resultSet = preStatement.executeQuery();

            if (resultSet.next())
                eliminado = true;

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
        return eliminado;
    }

    public ArrayList<Entity> GetVideosFromList(Entity e) throws SQLException {

        ArrayList<Entity> listaContenedora= new ArrayList<>();
        ListaDeReproduccion lista = (ListaDeReproduccion) e;
        Video video;
        Integer idLista = lista.getIdLista();
        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m05_obtenervideoslista(?)}"); //HAY QUE AGREGAR ESTE METODO A POSTGRE
            //Seteo lo que le estoy mandando al procedimiento con ese "?"
            preStatement.setInt(1,idLista);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("vid_id");
                String nombre = resultSet.getString("vid_titulo");
                //String descripcion = resultSet.getString("vid_descripcion");
                String imagen = resultSet.getString("vid_imagen");
                String fechaCreacion = resultSet.getString("vid_fecha");
                String urlVideo = resultSet.getString("vid_url");
                int numReproducciones = resultSet.getInt("vid_visitas");
                //int idUsuarioF = resultSet.getInt("vid_usuario");

                video = (Video) EntityFactory.video(id, nombre, imagen, numReproducciones, fechaCreacion, urlVideo);
                listaContenedora.add(video);

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
        return listaContenedora;
    }
}