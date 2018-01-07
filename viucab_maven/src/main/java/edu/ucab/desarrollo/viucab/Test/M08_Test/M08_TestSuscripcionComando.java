package edu.ucab.desarrollo.viucab.Test.M08_Test;

import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.GetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.GetUsuariosComando;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class M08_TestSuscripcionComando {

    @Test
    public  void TestGetSuscripcionComando() throws PLConnectException1, BDConnectException1 {

        Command comandSuscripcion = CommandsFactory.instanciaGetSuscripcionComando(1);
        GetSuscripcionComando cmd = (GetSuscripcionComando) comandSuscripcion;
        cmd.execute();
        ArrayList<Usuario> result = cmd.get_listUsuario();
        assertNotNull(result);

    }


    @Test
    public  void TestGetUsuariosComando() throws PLConnectException1, BDConnectException1 {
        Command comandSuscripcion = CommandsFactory.instanciaGetUsuariosComando();
        GetUsuariosComando cmd = (GetUsuariosComando) comandSuscripcion;
        cmd.execute();
        ArrayList<Usuario> result = cmd.get_listUsuario();
        assertNotNull(result);

    }


}
