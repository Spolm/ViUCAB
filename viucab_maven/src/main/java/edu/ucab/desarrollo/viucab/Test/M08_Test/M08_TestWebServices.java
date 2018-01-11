package edu.ucab.desarrollo.viucab.Test.M08_Test;


import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.common.exceptions.WebFaulException;
import edu.ucab.desarrollo.viucab.webService.M08_Suscripcion.M08_Suscripcion;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class M08_TestWebServices {

    /**
     * Metodo que prueba la capa de presentacion clase: M08_Suscripcion
     * y llama al metodo de GetSuscripcion. Verificando que no devuelva nulo
     * @throws VIUCABException
     * @throws WebFaulException
     */
    @Test
    public void  TestDaolistaSuscripciones() throws VIUCABException,  WebFaulException {

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
