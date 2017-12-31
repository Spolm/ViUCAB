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
                //String imagen = resultSet.getString("LIS_REP_IMG");   AUN NO ESTA IMPLEMENTADO QUE SE TRAIGA LA IMAGEN
                String fechaCreacion = resultSet.getString("LIS_REP_FECHA");
                int numReproducciones = resultSet.getInt("LIS_REP_NUMREP");

                lista = (ListaDeReproduccion) EntityFactory.listaDeReproduccion(idLista, nombre, descripcion, numReproducciones, fechaCreacion);
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
}