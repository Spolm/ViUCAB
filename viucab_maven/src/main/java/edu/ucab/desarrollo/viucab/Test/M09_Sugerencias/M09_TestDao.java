package edu.ucab.desarrollo.viucab.Test.M09_Sugerencias;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;

import edu.ucab.desarrollo.viucab.dataAccessLayer.M09_Sugerencias.GetSugerenciasDao;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class M09_TestDao {

    @Test
    public void  testGetSugerenciasLikeDao() throws PLConnectException1, BDConnectException1 {

        //Valores predeterminados que si traen videos
        Entity video = EntityFactory.instaciateVideo(3, "Deporte");
        //Con esta prueba se hacen dos prueba, esta instanciacion y ver si la lista es nula
        GetSugerenciasDao dao = DaoFactory.instaciateDaoSugerencias();
        try {
            ArrayList<Entity> lista = dao.sugerenciasLike(video);
            assertNotNull(lista);
        }
        catch (VIUCABException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void  testGetSugerenciasSuscripcionDao() throws PLConnectException1, BDConnectException1 {

        Entity video = EntityFactory.instaciateVideo(1, "Arte");
        GetSugerenciasDao dao = DaoFactory.instaciateDaoSugerencias();
        try {
            ArrayList<Entity> lista = dao.sugerenciasSuscripcion(video);
            assertNotNull(lista);
        }
        catch (VIUCABException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
