package edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;

public interface IDaoMailNotificacion extends IDao {
    Entity mailNotificacion (Entity e, String cliente, String Suscripcion) throws SQLException;

}
