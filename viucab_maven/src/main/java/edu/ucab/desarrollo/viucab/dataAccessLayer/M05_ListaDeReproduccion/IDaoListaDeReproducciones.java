package edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public interface IDaoListaDeReproducciones extends IDao {

    ArrayList<Entity> GetLista(Entity e) throws SQLException; //throws SQLException, BdConnectException;

}