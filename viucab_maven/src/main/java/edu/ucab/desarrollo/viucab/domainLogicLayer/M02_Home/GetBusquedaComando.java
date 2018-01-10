package edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home;


import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home.GetHomeDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by estefania on 29/11/2017.
 */
public class GetBusquedaComando extends Command{
    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetMasVistosComando.class);
    ArrayList<Video>_resultado=null;
    Entity est;

    public GetBusquedaComando(Entity est) {
        this.est = est;
    }

    /**
     * Obtiene Resultaddo de las Busquedas
     * @return ListVideo
     */
    public ArrayList<Video> get_listVideo() {return _resultado;}


    @Override
    public void execute() throws VIUCABException,SQLException {
            GetHomeDao dao =  DaoFactory.instanciateGetBusquedaComando();
            ArrayList<Video> video = dao.GetBusquedaComando(est);
            _resultado = video;
    }




    @Override
    public Entity Return() {
        return null;
    }
}
