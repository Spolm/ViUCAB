package edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M07_Etiquetas.GetEtiquetasDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.GetEstadistica1;
import org.slf4j.LoggerFactory;

import java.util.List;


public class InsertarEtiqueta extends Command{

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetEstadistica1.class);
    private static Entity eti;

    public InsertarEtiqueta(Entity etiqueta) {
        this.eti = etiqueta;
    }

    @Override
    public void execute() {
        try{
            GetEtiquetasDao dao = DaoFactory.instanciateDaoEtiquetas();
            Entity etiquetas = dao.insertarEtiqueta(eti);
            eti = etiquetas;

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
