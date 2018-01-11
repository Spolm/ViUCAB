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

/**
 * Clase comando para obtener todos los videos de una lista
 */
public class GetVideosFromListComando extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetVideosFromListComando.class); //seteo el logger
    private static Entity est;
    ArrayList<Entity> _resultado = null;

    /**
     * Constructor para settear entidad
     * @param est
     */
    public GetVideosFromListComando(Entity est)
    {
        this.est = est;
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
    public void execute() throws VIUCABException, SQLException {


            GetListaDeReproduccionDao dao =  DaoFactory.instanciateDaoListaDeReproduccion(); //seteo dao
            //ArrayList<Entity> listas = dao.GetVideosFromList(est); //llamo al metodo en dao y obtengo la lista con respuestas
            //Entity  lista = dao.GetLista(est);
            _resultado = dao.GetVideosFromList(est); //llamo al metodo en dao y obtengo la lista con respuestas
/*
        }
        catch (Exception e){
            est = new Entity();

        }
*/

    }


    @Override
    public Entity Return() {
        return est;
    }
}
