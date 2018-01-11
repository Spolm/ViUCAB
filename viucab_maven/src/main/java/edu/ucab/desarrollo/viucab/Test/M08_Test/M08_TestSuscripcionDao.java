package edu.ucab.desarrollo.viucab.Test.M08_Test;

import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M08.SuscripcionDao;
import org.junit.Test;
import org.postgresql.util.PSQLException;

import static edu.ucab.desarrollo.viucab.dataAccessLayer.Dao.getBdConnect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class M08_TestSuscripcionDao {

    /**
     * Probando metodo del DAO suscripcion: el cual devuelve la lista de
     * suscripciones
     * @throws VIUCABException
     */
    @Test
    public void  TestlistaSuscripciones() throws VIUCABException  {

        SuscripcionDao dao = DaoFactory.instanciateSuscripcion();
        ArrayList<Usuario> user = dao.listaSuscripciones(1);
        assertNotNull(user);
    }

    /**
     * Probando metodo del DAO suscripcion: el cual devuelve la lista de
     * usuarios
     * @throws VIUCABException
     */

    @Test
    public void  TestlistaUsuarios() throws VIUCABException {

        SuscripcionDao dao = DaoFactory.instanciateSuscripcion();
        ArrayList<Usuario> user = dao.listaUsuarios(1); // probando con el usuario 1
        assertNotNull(user);
    }

    /**
     * Prueba que evaluo la efectividad de la exception si hay algun error en el PL.
     * Para este caso lo escribo mal.
     * @throws VIUCABException
     * @throws SQLException
     */

    @Test(expected = VIUCABException.class)
    public void testPlConnectException() throws VIUCABException, SQLException {
        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;
        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            //Invocando el SP
            preStatement = conn.prepareCall("{call /*m*/08_get_suscripciones(?)}"); //Error del PL, le quite la "m"
            //Metiendo los parametros al SP
            preStatement.setInt(1,1); //aqui lo cableo
            //Ejecucion del query
            resultSet = preStatement.executeQuery();
            resultSet.close();

        } catch (PSQLException e){throw new VIUCABException(e); }

    }



}
