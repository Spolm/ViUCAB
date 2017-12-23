package edu.ucab.desarrollo.viucab.domainLogicLayer.M11;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
<<<<<<< HEAD
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.sql.SQLException;
=======
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M011.GetEstadisticaDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;
>>>>>>> Develop

/**
 * Created by Daniel on 25/11/2017.
 */
<<<<<<< HEAD
public class GetEstadistica3 implements Command {
    public GetEstadistica3(Entity est) {
    }


    @Override
    public String execute(int usuario, String categoria) throws SQLException {
        return null;
    }
/*
    @Override
    public Entity Return() {
        return null;
    }*/
=======
public class GetEstadistica3 extends Command {
    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetEstadistica1.class);
    private static Entity est;

    public GetEstadistica3(Entity est)
    {
        this.est = est;
    }

    @Override
    public void execute() {

        try {
            GetEstadisticaDao dao =  DaoFactory.instanciateDaoEstadistica1();
            Entity  estadistica = dao.GetEstadistica3(est);
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
