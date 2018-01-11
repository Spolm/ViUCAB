package edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
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
public class GetSuscritosComando extends Command {
    int _idUsuario;
    Entity est;
    ArrayList<Video> _resultado=null;

    public GetSuscritosComando(Entity est) {
        this.est = est;
    }

    /**
     * Obtiene la lista resultante de las suscripciones
     * @return
     */
    public ArrayList<Video> get_listVideo()
    {
        return _resultado;
    }

    @Override
    public void execute() throws VIUCABException , SQLException{

        GetHomeDao dao =  DaoFactory.instanciateGetSuscritosComando();
        ArrayList<Video> video = dao.GetSuscritosComando(est);
        _resultado = video;

    }

    @Override
    public Entity Return() {
        return null;
    }
}
