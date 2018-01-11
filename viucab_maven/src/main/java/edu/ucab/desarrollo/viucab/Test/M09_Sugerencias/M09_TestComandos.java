package edu.ucab.desarrollo.viucab.Test.M09_Sugerencias;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;

import edu.ucab.desarrollo.viucab.dataAccessLayer.M09_Sugerencias.GetSugerenciasDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasLikeComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasSuscripcionComando;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class M09_TestComandos {



    @Test
    public void  testGetSugerenciasLikeComando() throws PLConnectException1, BDConnectException1 {

        Entity video = EntityFactory.instaciateVideo(3, "Deporte");
        Command cmd = CommandsFactory.instaciateSugerenciasLike(video);
        GetSugerenciasLikeComando c = (GetSugerenciasLikeComando) cmd;

        try {
            c.execute();
            ArrayList<Entity> lista = c.executeCommand();
            assertNotNull(lista);
        } catch (VIUCABException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void  testGetSugerenciasSuscripcionesComando() throws PLConnectException1, BDConnectException1 {

        Entity video = EntityFactory.instaciateVideo(3, "Deporte");
        Command cmd = CommandsFactory.instaciateSugerenciasSuscripcion(video);
        GetSugerenciasSuscripcionComando c = (GetSugerenciasSuscripcionComando) cmd;

        try {
            c.execute();
            ArrayList<Entity> lista = c.executeCommand();
            assertNotNull(lista);
        } catch (VIUCABException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
