package edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.PlConnectException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 *
 */
public class GetListaComando extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetListaComando.class);
    private static Entity est;
    ArrayList<Entity>_resultado = null;

    public GetListaComando(Entity est)
    {
        this.est = est;
    }


    public GetListaComando(ArrayList<Entity> resultado) {
        this._resultado = resultado;
    }

    public ArrayList<Entity> getResultados()
    {
        return _resultado;
    }


    @Override
    public void execute() throws BdConnectException, PlConnectException {


        try {
            GetListaDeReproduccionDao dao =  DaoFactory.instanciateDaoListaDeReproduccion();
            ArrayList<Entity> listas = dao.GetLista(est);
            //Entity  lista = dao.GetLista(est);
            _resultado = listas;

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
