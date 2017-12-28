package edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M07_Etiquetas.GetEtiquetasDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;


public class EliminarEtiqueta extends Command {
    final static org.slf4j.Logger logger = LoggerFactory.getLogger(EliminarEtiqueta.class);
    private static Entity eti;

    public EliminarEtiqueta(Entity etiqueta){
        this.eti = etiqueta;
    }

    @Override
    public void execute() {
        try{
            GetEtiquetasDao dao = DaoFactory.instanciateDaoEtiquetas();
            Entity etiqueta = dao.eliminarEtiqueta(eti);
            eti = etiqueta;
        }catch(Exception e){
            eti = new Entity();
            logger.debug("Exception: {}", e);
        }

    }

    @Override
    public Entity Return() {
        return eti;
    }
}
