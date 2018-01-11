package edu.ucab.desarrollo.viucab.Test.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ModifyListComandoTest {

    @Test
    public void execute() throws VIUCABException, SQLException {

        Entity est = EntityFactory.modifyLista(10, "superGraduandos", "nos fuimos",  "goo.gl");
        Boolean resultadoPrueba = false;

        GetListaDeReproduccionDao dao =  DaoFactory.instanciateDaoListaDeReproduccion(); //instancio DAO
        resultadoPrueba = dao.modifyLista(est); //llamo al metodo y obtengo el resultado
        assertTrue(resultadoPrueba);
    }
}
