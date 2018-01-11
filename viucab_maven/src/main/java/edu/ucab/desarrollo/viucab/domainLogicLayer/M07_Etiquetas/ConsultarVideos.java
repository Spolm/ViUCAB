package edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video_Etiq;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M07_Etiquetas.GetEtiquetasDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ConsultarVideos extends Command{
    final static org.slf4j.Logger logger = LoggerFactory.getLogger(ConsultarVideos.class);
    private static Entity eti;
    private static List<Entity> vid;

    public ConsultarVideos(Entity e){
        this.eti = e;
    }

    @Override
    public void execute() {
        try{
            GetEtiquetasDao dao = DaoFactory.instanciateDaoEtiquetas();
            vid = new ArrayList<>();
            vid.addAll(dao.consultarVideos(eti));
        }catch(Exception e){
            logger.debug("Exception: {}", e);
        }
    }

    @Override
    public Entity Return() {

        return eti;
    }

    public List<Entity> ReturnList(){
        return vid;
    }
}
