package edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias;

import edu.ucab.desarrollo.viucab.ViUcab;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.MessageException;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M09_Sugerencias.GetSugerenciasDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.GetEstadistica1;
import javafx.scene.media.MediaException;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class GetSugerenciasLikeComando extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetSugerenciasLikeComando.class);
    public LoggerM09 log = new LoggerM09();
    private static Entity est;
    ArrayList<Entity> e = null;

    public GetSugerenciasLikeComando(Entity est){this.est = est;}

    public GetSugerenciasLikeComando(){this.e = e;}

    @Override
    public void execute() throws VIUCABException, SQLException, MessageException {

        logger.info("execute GetSugerenciasLikeComando", GetSugerenciasLikeComando.class);
        log.imprimirLogger("GetSugerenciasLikeComando", "execute", "INFO");

        GetSugerenciasDao dao = DaoFactory.instaciateDaoSugerencias();
                    ArrayList<Entity> lista = dao.sugerenciasLike(est);
                    e = lista;

    }

    @Override
    public Entity Return() {
        return est;
    }

   /* @Override
    public ArrayList<Entity> executeCommand() {

        return e;
    }*/

   public ArrayList<Entity> executeCommand(){ return e;}
}
