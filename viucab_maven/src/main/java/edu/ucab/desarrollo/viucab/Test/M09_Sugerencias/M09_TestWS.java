package edu.ucab.desarrollo.viucab.Test.M09_Sugerencias;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M09_Sugerencias.GetSugerenciasDao;
import edu.ucab.desarrollo.viucab.webService.M09_Sugerencias.M09_Sugerencias;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class M09_TestWS {

    @Test
    public void  testWSSugerenciasLike() throws PLConnectException1, BDConnectException1 {

        M09_Sugerencias ws = new M09_Sugerencias();
        Gson gson = new Gson();
        assertEquals(gson, ws.getSugerenciasLikes(3, "Deporte"));

    }

    @Test
    public void  testWSSugerenciasSuscripcion() throws PLConnectException1, BDConnectException1 {

        M09_Sugerencias ws = new M09_Sugerencias();
        Gson gson = new Gson();
        assertEquals(gson, ws.getSugerenciasSuscripciones(3, "Deporte"));

    }
}
