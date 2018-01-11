package edu.ucab.desarrollo.viucab.domainLogicLayer.M01_Login;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.PlConnectException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M01_Login.GetUsuarioDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class VerUsuariosComando extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(VerUsuariosComando.class);
    private static Entity est;
    ArrayList<Entity>__resultado = null;

    public VerUsuariosComando(Entity est)
    {
        this.est = est;
    }


    public VerUsuariosComando(ArrayList<Entity> resultado) {
        this.__resultado = resultado;
    }

    public ArrayList<Entity> getResultados()
    {
        return __resultado;
    }


    @Override
    public void execute() throws BdConnectException, PlConnectException {


        try {
            GetUsuarioDao dao =  DaoFactory.instanciateDaoUsuario();
            ArrayList<Entity> ususu = dao.verusuario(est);
            //Entity  lista = dao.GetLista(est);
            __resultado = ususu;

        }
        catch (Exception e){
            est = new Entity();

        }


    }


    @Override
    public Entity Return() {
        return est;
    }
}
