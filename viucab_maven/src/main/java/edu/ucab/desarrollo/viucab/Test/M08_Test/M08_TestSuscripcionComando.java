package edu.ucab.desarrollo.viucab.Test.M08_Test;

import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
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

    /**
     * Metodo ago la llamada al comando y le paso directamente un usuario,
     * deberia devolver la lista no vacia delas personas suscritas
     * @throws VIUCABException
     */
    @Test
    public  void TestGetSuscripcionComando() throws VIUCABException  {
        Command comandSuscripcion = CommandsFactory.instanciaGetSuscripcionComando(1);
        GetSuscripcionComando cmd = (GetSuscripcionComando) comandSuscripcion;
        cmd.execute();
        ArrayList<Usuario> result = cmd.get_listUsuario();
        assertNotNull(result);

    }

    /**
     * Metodo ago la llamada al comando y le paso directamente un usuario,
     * deberia devolver la lista no vacia de los usuarios
     * @throws VIUCABException
     */
    @Test
    public  void TestGetUsuariosComando() throws VIUCABException {
        Command comandSuscripcion = CommandsFactory.instanciaGetUsuariosComando(1); // probando con el usuario 1
        GetUsuariosComando cmd = (GetUsuariosComando) comandSuscripcion;
        cmd.execute();
        ArrayList<Usuario> result = cmd.get_listUsuario();
        assertNotNull(result);

    }


}
