package edu.ucab.desarrollo.viucab.Test.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class AddListComandoTest {

    @Test
    public void execute() throws VIUCABException, SQLException {

        Entity est = EntityFactory.createLista("lista de prueba", "prueba", "prueba.com", 1, "2018-01-11", 10); //llamo a la fabrica entidad para setear lo que necesito pasar al dao
        Boolean resultadoPrueba = false;

        GetListaDeReproduccionDao dao =  DaoFactory.instanciateDaoListaDeReproduccion(); //instancio DAO
        resultadoPrueba = dao.createLista(est); //llamo al metodo y obtengo el resultado
        assertTrue(resultadoPrueba);
    }




}
