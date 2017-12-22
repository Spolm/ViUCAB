package edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;

/**
 *
 */
public interface IDaoListaDeReproduccion extends IDao {

    Entity GetLista(Entity e) throws SQLException; //throws SQLException, BdConnectException;

}