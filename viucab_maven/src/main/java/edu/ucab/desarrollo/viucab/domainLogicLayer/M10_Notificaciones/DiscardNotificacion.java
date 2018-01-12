package edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones.GetNotificacionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

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
    public void execute() throws VIUCABException, SQLException, PLConnectException1, BDConnectException1 {

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
