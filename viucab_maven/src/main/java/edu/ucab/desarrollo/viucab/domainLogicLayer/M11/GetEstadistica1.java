package edu.ucab.desarrollo.viucab.domainLogicLayer.M11;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
<<<<<<< HEAD
import edu.ucab.desarrollo.viucab.common.exceptions.MessageException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * Created by Daniel on 25/11/2017.
 */
public class GetEstadistica1 implements Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetEstadistica1.class);

    public GetEstadistica1(Entity est) {
    }

    @Override
    public String execute(int usuario, String categoria) throws SQLException {
        return null;
    }
/*
    @Override
    public void execute() {

        try {

        }
        catch (Exception e){

            MessageException error = new MessageException(e, this.getClass().getSimpleName(),
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            logger.debug("Debug: ", error);
            logger.error("Error: ", error);
        }
    }*/
/*
    @Override
    public Entity Return() {
        return null;
    }*/
=======
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M011.GetEstadisticaDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

/**
 * Created by Daniel on 25/11/2017.
 */
public class GetEstadistica1 extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetEstadistica1.class);
    private static Entity est;

    public GetEstadistica1(Entity est)
    {
        this.est = est;
    }

    @Override
    public void execute() {

        try {
            GetEstadisticaDao dao =  DaoFactory.instanciateDaoEstadistica1();
         Entity  estadistica = dao.GetEstadistica1(est);
         est =estadistica;


        }
        catch (Exception e){
            est = new Entity();

        }
    }

    @Override
    public Entity Return() {
        return est;
    }
>>>>>>> Develop
}
