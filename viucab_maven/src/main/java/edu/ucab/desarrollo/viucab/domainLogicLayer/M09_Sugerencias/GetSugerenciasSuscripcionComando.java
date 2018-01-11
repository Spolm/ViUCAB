package edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
<<<<<<< HEAD
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.PlConnectException;
=======
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;

>>>>>>> Develop
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
<<<<<<< HEAD
    public void execute() throws BdConnectException, PlConnectException {
=======
    public void execute() throws BdConnectException {
>>>>>>> Develop
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

<<<<<<< HEAD
    @Override
    public ArrayList<Entity> executeCommand() {
        return e;
    }
=======

    public ArrayList<Entity> executeCommand(){ return e;}
>>>>>>> Develop
}
