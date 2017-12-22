package edu.ucab.desarrollo.viucab.dataAccessLayer.M07_Etiquetas;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video_Etiq;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.List;

public interface IDaoEtiqueta extends IDao{
    Entity insertarEtiqueta(Entity e) throws SQLException;
    Entity eliminarEtiqueta(Entity e) throws SQLException;
    List<Video_Etiq> consultarVideos(Entity e) throws  SQLException;
}
