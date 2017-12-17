package edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home.GetHomeDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.util.ArrayList;

/**
 * Created by estefania on 29/11/2017.
 */
public class GetPreferenciasComando extends Command {

    Entity est;
    ArrayList<Entity> resultado=null;

    public GetPreferenciasComando(Entity est) {
        this.est = est;
    }

    @Override
    public void execute() {
        GetHomeDao dao =  DaoFactory.instanciateGetPreferenciasComando();
        ArrayList<Entity> video = dao.GetPreferenciasComando(est);
        resultado =video;

    }

    @Override
    public ArrayList<Entity> Return() {
        return null;
    }
}
