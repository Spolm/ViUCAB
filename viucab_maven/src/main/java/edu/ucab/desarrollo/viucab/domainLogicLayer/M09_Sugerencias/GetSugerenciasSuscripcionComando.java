package edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;

import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M09_Sugerencias.GetSugerenciasDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.GetEstadistica1;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class GetSugerenciasSuscripcionComando extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetEstadistica1.class);
    private static Entity est;
    ArrayList<Entity> e = null;

    public GetSugerenciasSuscripcionComando(Entity est){this.est = est;}

    public GetSugerenciasSuscripcionComando(ArrayList<Entity> e){this.e = e;}

    @Override
    public void execute() throws BdConnectException {
        try{
            GetSugerenciasDao dao = DaoFactory.instaciateDaoSugerencias();
            ArrayList<Entity> lista = dao.sugerenciasSuscripcion(est);
            e = lista;
        }
        catch (Exception e){
            est = new Entity();
        }
    }


    @Override
    public Entity Return() {
        return est;
    }


    public ArrayList<Entity> executeCommand(){ return e;}
}
