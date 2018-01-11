package edu.ucab.desarrollo.viucab.Test.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.ListaDeReproduccion;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.PlConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class M05_ListaDeReproduccionTest {

    @Test
    public void obtenerLista() throws VIUCABException, SQLException {

        Entity prueba = EntityFactory.getLista(4);
        GetListaComando g = (GetListaComando) CommandsFactory.instanciaGetLista(prueba);
        g.execute();
        ArrayList<Entity> result = g.getResultados();
        assertNotNull(result);
    }

    @Test
    public void agregarLista() throws VIUCABException, SQLException {

        Entity prueba = EntityFactory.createLista("prueba", "prueba", "goo.gl", 1, "2018-01-11",4);
        AddListComando g = (AddListComando) CommandsFactory.instanciaAddListComando(prueba);
        g.execute();
        Boolean result = g.getResultado();
        assertTrue(result);
    }

    @Test
    public void obtenerListaEspecifica() throws VIUCABException, SQLException {

        Entity prueba = EntityFactory.getListaEspecifica(1);
        GetEspecificListComando g = (GetEspecificListComando) CommandsFactory.instanciaGetEspecificList(prueba);
        g.execute();
        Entity result = g.Return();
        assertNotNull(result);
    }


    @Test
    public void modificarLista() throws VIUCABException, SQLException {

        Entity prueba = EntityFactory.modifyLista(1, "prueba", "descripcion", "url.com");
        ModifyListComando g = (ModifyListComando) CommandsFactory.instanciaModifyListComando(prueba);
        g.execute();
        Boolean result = g.getResultado();
        assertTrue(result);
    }

    @Test
    public void eliminarLista() throws VIUCABException, SQLException {

        Entity prueba = EntityFactory.deleteList(1);
        DeleteListComando g = (DeleteListComando) CommandsFactory.instanciaDeleteListComando(prueba);
        g.execute();
        Boolean result = g.getResultado();
        assertTrue(result);
    }

    @Test
    public void agregarVideoLista() throws VIUCABException, SQLException {

        Entity prueba = EntityFactory.addOrDeleteVideoToList(50, 10);
        AddVideoToListComando g = (AddVideoToListComando) CommandsFactory.instanciaAddVideoToListComando(prueba);
        g.execute();
        Boolean result = g.getResultado();
        assertTrue(result);
    }


    @Test
    public void eliminarVideoLista() throws VIUCABException, SQLException {

        Entity prueba = EntityFactory.addOrDeleteVideoToList(50, 10);
        DeleteVideoToListComando g = (DeleteVideoToListComando) CommandsFactory.instanciaDeleteVideoToListComando(prueba);
        g.execute();
        Boolean result = g.getResultado();
        assertTrue(result);
    }


    @Test
    public void obtenerVideosDeLista() throws VIUCABException, SQLException {

        Entity prueba = EntityFactory.getVideosFromList(4);
        GetVideosFromListComando g = (GetVideosFromListComando) CommandsFactory.instanciaGetVideosFromList(prueba);
        g.execute();
        ArrayList<Entity> result = g.getResultados();
        assertNotNull(result);
    }

}
