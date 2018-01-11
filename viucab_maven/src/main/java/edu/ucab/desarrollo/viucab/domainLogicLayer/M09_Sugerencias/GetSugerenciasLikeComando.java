package edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
<<<<<<< HEAD
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.PlConnectException;
=======
>>>>>>> Develop
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M09_Sugerencias.GetSugerenciasDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.GetEstadistica1;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class GetSugerenciasLikeComando extends Command {

<<<<<<< HEAD
    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetSugerenciasLikeComando.class);
=======
    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetEstadistica1.class);
>>>>>>> Develop
    private static Entity est;
    ArrayList<Entity> e = null;

    public GetSugerenciasLikeComando(Entity est){this.est = est;}

    public GetSugerenciasLikeComando(){this.e = e;}

    @Override
<<<<<<< HEAD
    public void execute()  {
=======
    public void execute() {
>>>>>>> Develop
                try{
                    GetSugerenciasDao dao = DaoFactory.instaciateDaoSugerencias();
                    ArrayList<Entity> lista = dao.sugerenciasLike(est);
                    e = lista;
<<<<<<< HEAD
                } catch (Exception e){
                    est = new Entity();
                }

=======
                }
                catch (Exception e){
                    est = new Entity();
                }
>>>>>>> Develop
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
   /* @Override
    public ArrayList<Entity> executeCommand() {

        return e;
    }*/

   public ArrayList<Entity> executeCommand(){ return e;}
>>>>>>> Develop
}
