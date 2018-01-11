package edu.ucab.desarrollo.viucab.domainLogicLayer.M01_Login;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.PlConnectException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M01_Login.GetUsuarioDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion.GetListaComando;
import org.slf4j.LoggerFactory;

public class GetUsuarioEspecifico extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetListaComando.class);
    private static Entity est;


    public GetUsuarioEspecifico(Entity est)
    {
        this.est = est;
    }


    @Override
    public void execute() throws BdConnectException, PlConnectException {


        try {
            GetUsuarioDao dao =  DaoFactory.instanciateDaoUsuario();
            Entity  lista = dao.GetusuarioEspecifico(est);
            est = lista;

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
