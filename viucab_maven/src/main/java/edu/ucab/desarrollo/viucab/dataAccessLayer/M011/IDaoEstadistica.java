package edu.ucab.desarrollo.viucab.dataAccessLayer.M011;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;

/**
 * Created by Daniel on 25/11/2017.
 */
public interface IDaoEstadistica extends IDao {

    Entity GetEstadistica1 (Entity e) throws SQLException; //throws SQLException, BdConnectException;
    Entity GetEstadistica2 (Entity e);
    Entity GetEstadistica3 (Entity e);
    Entity GetEstadistica4 (Entity e);
    Entity GetEstadistica5 (Entity e);
    Entity GetEstadistica6 (Entity e);
    Entity GetEstadistica7 (Entity e);
    Entity GetEstadistica8 (Entity e);
    Entity GetEstadistica9 (Entity e);
}
