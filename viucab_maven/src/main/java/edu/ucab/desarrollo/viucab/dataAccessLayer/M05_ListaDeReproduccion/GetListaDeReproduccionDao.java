package edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.*;

import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;

import java.sql.SQLException;

/**
 *
 */
public class GetListaDeReproduccionDao extends Dao implements IDaoListaDeReproduccion {

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
    public Entity GetLista(Entity e) throws SQLException {

        ListaDeReproduccion lista = (ListaDeReproduccion) e;
        Integer idLista = lista.getIdLista();
        Entity listaRecibida = null;
        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call m05_obtenerListaDeReproduccion(?)}"); //HAY QUE AGREGAR ESTE METODO A POSTGRE
            //Seteo lo que le estoy mandando al procedimiento con ese "?"
            preStatement.setInt(1,idLista);
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {

                int idLista = resultSet.getInt("LIS_REP_ID");
                String nombre = resultSet.getString("LIS_REP_NOMBRE");
                String descripcion = resultSet.getString("LIS_REP_DESCRIPCION");
                //String imagen = resultSet.getString("LIS_REP_IMG");   AUN NO ESTA IMPLEMENTADO QUE SE TRAIGA LA IMAGEN
                String fechaCreacion = resultSet.getString("LIS_REP_FECHA");
                int numReproducciones = resultSet.getInt("LIS_REP_NUMREP");

                listaRecibida = EntityFactory.listaDeReproduccion(idLista, nombre, descripcion, numReproducciones, fechaCreacion);

            }
            resultSet.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            closeConnection();
        }
        return listaRecibida;
    }
}