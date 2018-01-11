package edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones.GetNotificacionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

/**
 * Created by Luis Miguel on 10/01/2018.
 */
public class DiscardNotificacion extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetNotificaciones.class);
    private static Entity nt;
    public Entity not;
    public int id;
    public DiscardNotificacion (Entity n){
        this.nt = n;
    }



    @Override
    public void execute() {

        try {
            GetNotificacionDao dao = DaoFactory.instanciateDaonotificacion();
            not =  nt;
            dao.descartarNotificacion(not);
        }
        catch (Exception e){
            logger.debug("Exception: {}", e);
        }

    }

    @Override
    public Entity Return() {
        return nt;
    }
}
