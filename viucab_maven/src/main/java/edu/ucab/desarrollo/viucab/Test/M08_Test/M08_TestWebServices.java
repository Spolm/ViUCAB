package edu.ucab.desarrollo.viucab.Test.M08_Test;


import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.PlConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.WebFaulException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M08.SuscripcionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.webService.M08_Suscripcion.M08_Suscripcion;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import java.util.ArrayList;

public class M08_TestWebServices {

    @Test
    public void  TestDaolistaSuscripciones() throws PlConnectException, BdConnectException, WebFaulException {

        M08_Suscripcion a = new  M08_Suscripcion();
        assertNotNull(a.GetSuscripcion(1));
    }

/*              Command comandSuscripcion = CommandsFactory.instanciaGetUsuariosComando();
                GetUsuariosComando cmd = (GetUsuariosComando) comandSuscripcion;
                cmd.execute();
                ArrayList<Usuario> result = cmd.get_listUsuario();
                return   gson.toJson(result);*/


/*    @Test
    void execute() throws Exception {
        try {
        Entity userObject = EntityFactory.createUser("karo","1234");
        Command _command = CommandsFactory.instanciateCheckUserCmd(userObject);
        CheckUserCommand cmd = (CheckUserCommand) _command;
        cmd.execute();
        User result = (User) CheckUserCommand.getUserLogin();

            assertNotNull(result.get_id());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (LoginUserException e) {
            e.printStackTrace();
        }

    }*/

}
