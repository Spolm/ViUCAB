package edu.ucab.desarrollo.viucab.Test.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.ListaDeReproduccion;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static edu.ucab.desarrollo.viucab.dataAccessLayer.Dao.getBdConnect;
import static org.junit.Assert.assertNotNull;

public class GetListaDeReproduccionDaoTest {


    @Test
    public void getLista() throws SQLException, VIUCABException {
        /*----------------------------------------------*/
        ArrayList<Entity> listaContenedora= new ArrayList<>();
        Entity lista = new Entity();
        Integer idUsuario = 10;
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
            assertNotNull(listaContenedora);
        }
    }


}

