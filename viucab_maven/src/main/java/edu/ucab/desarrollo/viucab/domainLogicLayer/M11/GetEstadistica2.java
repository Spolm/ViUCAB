package edu.ucab.desarrollo.viucab.domainLogicLayer.M11;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M011.GetEstadisticaDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

/**
 * Created by Daniel on 25/11/2017.
 */
public class GetEstadistica2 extends Command {
    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetEstadistica1.class);
    private static Entity est;

    public GetEstadistica2(Entity est) {
        this.est = est;
    }

    /***
     * metodo execute que llama al dao para guardar los datos de la fabrica
     */
    @Override
    public void execute() {
        try {
            GetEstadisticaDao dao =  DaoFactory.instanciateDaoEstadistica1();
            Entity  estadistica = dao.GetEstadistica2(est);
            est =estadistica;


        }
        catch (Exception e){
            est = new Entity();

        }

    }
    /***
     * metodo execute que llama al dao para obtener los datos
     */
    @Override
    public Entity Return() {
        return est;
    }
}
