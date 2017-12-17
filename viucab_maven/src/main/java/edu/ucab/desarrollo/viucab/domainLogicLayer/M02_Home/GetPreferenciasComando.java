package edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home.GetHomeDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.util.ArrayList;

/**
 * Created by estefania on 29/11/2017.
 */
public class GetPreferenciasComando extends Command {

    Video est;
    ArrayList<Video> _resultado=null;

    public GetPreferenciasComando(Video est) {
        this.est = est;
    }


    public ArrayList<Video> get_listVideo()
    {
        return _resultado;
    }
    @Override
    public void execute() {
        GetHomeDao dao =  DaoFactory.instanciateGetPreferenciasComando();
        ArrayList<Video> video = dao.GetPreferenciasComando(est);
        _resultado =video;

    }

    @Override
    public Entity Return() {
        return null;
    }
}
