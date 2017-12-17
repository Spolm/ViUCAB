package edu.ucab.desarrollo.viucab.dataAccessLayer.M011;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;

/**
 * Created by Daniel on 25/11/2017.
 */
public interface IDaoEstadistica extends IDao {

    Entity GetEstadistica1 (Entity e) throws SQLException; //throws SQLException, BdConnectException;
    Entity GetEstadistica2 (Entity e) throws SQLException;
    Entity GetEstadistica3 (Entity e) throws SQLException;
    Entity GetEstadistica4 (Entity e) throws SQLException;
    Entity GetEstadistica5 (Entity e) throws SQLException;
    Entity GetEstadistica6 (Entity e) throws SQLException;
    Entity GetEstadistica7 (Entity e) throws SQLException;
    Entity GetEstadistica8 (Entity e) throws SQLException;
    Entity GetEstadistica9 (Entity e) throws SQLException;
}
