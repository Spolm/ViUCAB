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
 * Clase comando para obtener todas las listas
 */
public class GetListaComando extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetListaComando.class); //seteo el logger
    private static Entity est;
    ArrayList<Entity>_resultado = null;

    /**
     * Constructor para settear entidad
     * @param est
     */
    public GetListaComando(Entity est)
    {
        this.est = est;
    }

    /**
     * constructor para setear el resultado
     * @param
     */
    public GetListaComando(ArrayList<Entity> resultado) {
        this._resultado = resultado;
    }

    /**
     * metodo para obtener el resultado
     * @return Boolean
     */
    public ArrayList<Entity> getResultados()
    {
        return _resultado;
    }

    /**
     * Metodo para ejecutar el comando
     * @throws BdConnectException
     * @throws PlConnectException
     */
    @Override
    public void execute() throws BdConnectException, PlConnectException {


        try {
            GetListaDeReproduccionDao dao =  DaoFactory.instanciateDaoListaDeReproduccion(); //seteo el DAO
            /*ArrayList<Entity> listas = dao.GetLista(est);
            _resultado = listas; */
            _resultado = dao.GetLista(est); //llamo al metodo en dao y obtengo la lista con los resultados

        }
        catch (Exception e){
            est = new Entity();

        }


    }

    /**
     * Metodo para devolver el resultado con entidad
     * @return Entity
     */
    @Override
    public Entity Return() {
        return est;
    }
}
