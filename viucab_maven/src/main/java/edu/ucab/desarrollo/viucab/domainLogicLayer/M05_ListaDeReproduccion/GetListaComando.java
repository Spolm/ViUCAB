package edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

/**
 * 
 */
public class GetListaComando extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetEstadistica1.class);
    private static Entity est;

    public GetListaComando(Entity est)
    {
        this.est = est;
    }

    @Override
    public void execute() {

        try {
            GetListaDeReproduccionDao dao =  DaoFactory.instanciateDaoListaDeReproduccion();
            Entity  lista = dao.GetLista(est);
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
