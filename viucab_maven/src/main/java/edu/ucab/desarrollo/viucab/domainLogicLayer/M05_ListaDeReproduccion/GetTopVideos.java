package edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.PlConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class GetTopVideos extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetListaComando.class); //seteo el logger
    private static Entity est;
    ArrayList<Entity>_resultado = null;

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
    public void execute() throws VIUCABException, SQLException {

        GetListaDeReproduccionDao dao =  DaoFactory.instanciateDaoListaDeReproduccion(); //seteo el DAO
            /*ArrayList<Entity> listas = dao.getLista(est);
            _resultado = listas; */
        _resultado = dao.getTopVideos(); //llamo al metodo en dao y obtengo la lista con los resultados

        /*}
        catch (Exception e){
            est = new Entity();

        }*/


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