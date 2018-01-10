package edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.PlConnectException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

/**
 * Clase comando para modificar una lista
 */
public class ModifyListComando extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(ModifyListComando.class); //seteo el lloger
    private static Entity est;
    private Boolean resultado;


    /**
     * Constructor para setear la entidad
     * @param est
     */
    public ModifyListComando(Entity est) {
        this.est = est;
    }

    /**
     * metodo para obtener los resultados
     * @return
     */
    public Boolean getResultado() {
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
            GetListaDeReproduccionDao dao = DaoFactory.instanciateDaoListaDeReproduccion(); //instancio el DAO
            resultado = dao.modifyLista(est); //llamo al metodo de DAO y obtengo el resultado

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
