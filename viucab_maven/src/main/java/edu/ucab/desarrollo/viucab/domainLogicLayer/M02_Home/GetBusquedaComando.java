package edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home;


import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home.GetHomeDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created by estefania on 29/11/2017.
 */
public class GetBusquedaComando extends Command{
    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetMasVistosComando.class);
    String _criterio;
    ArrayList<Entity> resultado=null;



    public GetBusquedaComando(String criterio) {
        this._criterio=criterio;
    }


    @Override
    public void execute() {
        try {
            GetHomeDao dao =DaoFactory.instanciateGetBusquedaComando();
            ArrayList<Entity> video=dao.GetBusquedaComando(_criterio);

            resultado =video;
        }
        catch (Exception e){

        }


    }

    @Override
    public Entity Return() {
        return null;
    }
}
