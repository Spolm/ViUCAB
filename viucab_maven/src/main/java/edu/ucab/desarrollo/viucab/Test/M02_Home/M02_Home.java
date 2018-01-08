package edu.ucab.desarrollo.viucab.Test.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetMasVistosComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetPreferenciasComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetSuscritosComando;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

/**
 * Created by estefania on 07/01/2018.
 */
public class M02_Home {

    @Test
    public void prueba1(){

    }
    @Test
    public void obtenerPreferencia() throws Exception {

        Entity prueba = EntityFactory.homeVideo(1);
        GetPreferenciasComando g = (GetPreferenciasComando) CommandsFactory.instanciateGetPreferenciasComando(prueba);
        g.execute();
        ArrayList<Video> result = g.get_listVideo();
        assertNotNull(result);

    }

    @Test
    public void obtenerMasVistos() throws Exception {

        //Entity prueba = EntityFactory.homeVideo(1);
        GetMasVistosComando g = (GetMasVistosComando) CommandsFactory.instanciateGetMasVistosComando();
        g.execute();
        ArrayList<Video> result = g.get_listVideo();
        assertNotNull(result);

    }

    @Test
    public void obtenerVideosSuscritos() throws Exception {

        Entity prueba = EntityFactory.homeVideo(1);
        GetSuscritosComando g = (GetSuscritosComando) CommandsFactory.instanciateGetSuscritosComando(prueba);
        g.execute();
        ArrayList<Video> result = g.get_listVideo();
        assertNotNull(result);

    }

    @Test
    public void busquedaVideos() throws Exception {



    }



}
