package edu.ucab.desarrollo.viucab.Test.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class DeleteVideoToListComandoTest {

    @Test
    public void execute() throws VIUCABException, SQLException {

        Entity est = EntityFactory.addOrDeleteVideoToList(60, 7);
        Boolean resultadoPrueba = false;

        GetListaDeReproduccionDao dao =  DaoFactory.instanciateDaoListaDeReproduccion(); //instancio DAO
        resultadoPrueba = dao.deleteVideoToList(est); //llamo al metodo y obtengo el resultado
        assertTrue(resultadoPrueba);
    }
}

