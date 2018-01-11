package edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones.GetConfiguracionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GetConfiguracion extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetConfiguracion.class);
    private static Entity nt;
    public List<Entity> not;
    public GetConfiguracion(Entity entity){
        this.nt = entity;
    }

    @Override
    public void execute() {
        try {
            GetConfiguracionDao dao = DaoFactory.instanciateDaoConfiguracion();
            not = new ArrayList<>();
            not.addAll(dao.getConfiguracion(nt));

        }
        catch (Exception e){
            logger.debug("Exception: {}", e);
        }
    }

    @Override
    public Entity Return() {
        return nt;
    }

    public List<Entity> ReturnListCon(){
        return not;
    }
}
