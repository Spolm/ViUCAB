package edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.PlConnectException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

public class DeleteListComando extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(DeleteListComando.class);
    private static Entity est;
    private Boolean resultado;


    public DeleteListComando(Entity est) {
        this.est = est;
    }


    public Boolean getResultado() {
        return resultado;
    }


    @Override
    public void execute() throws BdConnectException, PlConnectException {


        try {
            GetListaDeReproduccionDao dao = DaoFactory.instanciateDaoListaDeReproduccion();
            resultado = dao.deleteList(est);

        } catch (Exception e) {
            est = new Entity();
            resultado = false;

        }


    }


    @Override
    public Entity Return() {
        return est;
    }
}
