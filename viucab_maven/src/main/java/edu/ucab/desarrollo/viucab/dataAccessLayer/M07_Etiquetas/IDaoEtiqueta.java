package edu.ucab.desarrollo.viucab.dataAccessLayer.M07_Etiquetas;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Etiquetas;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.List;

public interface IDaoEtiqueta extends IDao{
    Entity insertarEtiqueta(Entity e) throws SQLException, BDConnectException1, PLConnectException1;
    Entity eliminarEtiqueta(Entity e) throws SQLException, BDConnectException1, PLConnectException1;
    List<Etiquetas> consultarVideos(Entity e) throws  SQLException, BDConnectException1, PLConnectException1;
}
