package edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public interface IDaoListaDeReproducciones extends IDao {

    ArrayList<Entity> getLista(Entity e) throws SQLException;

    Entity getEspecificList(Entity e) throws SQLException;

    Boolean createLista(Entity e) throws SQLException;

    Boolean modifyLista(Entity e) throws SQLException;

    Boolean deleteList(Entity e) throws SQLException;

    Boolean addVideoToList(Entity e) throws SQLException;

    Boolean deleteVideoToList(Entity e) throws SQLException;

    ArrayList<Entity> GetVideosFromList(Entity e) throws SQLException;

    ArrayList<Entity> getTopVideos() throws SQLException;


}