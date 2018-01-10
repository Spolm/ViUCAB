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
 * Clase comando para obtener una lista especifica
 */
public class GetEspecificListComando extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetListaComando.class); //seteo el logger
    private static Entity est;


    /**
     * Constructor para settear entidad
     * @param est
     */
    public GetEspecificListComando(Entity est)
    {
        this.est = est;
    }


    /**
     * Metodo para ejecutar el comando
     * @throws BdConnectException
     * @throws PlConnectException
     */
    @Override
    public void execute() throws BdConnectException, PlConnectException {


        try {
            GetListaDeReproduccionDao dao =  DaoFactory.instanciateDaoListaDeReproduccion(); //seteo dao
            /*Entity  lista = dao.GetEspecificList(est);
            est = lista; //asigno el resultado a la entidad*/
            est = dao.GetEspecificList(est); //llamo al metodo de dao y obtengo el resultado

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
