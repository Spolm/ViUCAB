package edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Notificacion;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.List;

public interface IDaoNotificacion extends IDao{
    Entity notificacion(Entity e) throws SQLException;
    List<Notificacion> obtenerNotificaciones(Entity e) throws SQLException;
}
