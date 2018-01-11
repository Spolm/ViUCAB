package edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home.GetHomeDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by estefania on 29/11/2017.
 */
public class GetPreferenciasComando extends Command {

    Entity est;
    ArrayList<Video> _resultado=null;

    public GetPreferenciasComando(Entity est) {
        this.est = est;
    }


    public ArrayList<Video> get_listVideo()
    {
        return _resultado;
    }

    /**
     * Metodo que realiza la llamada a el patron DAO en la clase GetHomeDAO
     * para almacenar los datos obtenidos en la fabrica
     */
    @Override
    public void execute() throws VIUCABException, SQLException, PLConnectException1, BDConnectException1 {

        GetHomeDao dao =  DaoFactory.instanciateGetPreferenciasComando();
        ArrayList<Video> video = dao.GetPreferenciasComando(est);
        _resultado =video;

    }

    @Override
    public Entity Return() {
        return null;
    }
}
