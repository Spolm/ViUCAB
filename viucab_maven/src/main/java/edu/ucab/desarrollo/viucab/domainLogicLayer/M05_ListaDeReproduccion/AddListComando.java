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
 * Clase Comando para agregar una lista
 */
public class AddListComando extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(AddListComando.class); //seteo el logger
    private static Entity est;
    private Boolean resultado;

    /**
     * Constructor para settear entidad
     * @param est
     */
    public AddListComando(Entity est)
    {
        this.est = est;
    }


    /**
     * Constructor para setear el resultado
     * @param result
     */
    public AddListComando(Boolean result) {
        this.resultado = result;
    }

    /**
     * metodo para obtener el resultado
     * @return Boolean
     */
    public Boolean getResultado()
    {
        return resultado;
    }


    /**
     * Metodo para ejecutar el comando
     * @throws BdConnectException
     * @throws PlConnectException
     */
    @Override
    public void execute() throws BdConnectException, PlConnectException {


        try {
            GetListaDeReproduccionDao dao =  DaoFactory.instanciateDaoListaDeReproduccion(); //instancio DAO
            //ArrayList<Entity> listas = dao.GetLista(est);
            //_resultado = listas;
            resultado = dao.createLista(est); //llamo al metodo y obtengo el resultado

        }
        catch (Exception e){
            est = new Entity();
            resultado = false; //si no devuelve nada, devuelve falso

        }


    }

    /**
     * Metodo para devolver el resultado con entidad
     * @return
     */
    @Override
    public Entity Return() {
        return est;
    }


}
