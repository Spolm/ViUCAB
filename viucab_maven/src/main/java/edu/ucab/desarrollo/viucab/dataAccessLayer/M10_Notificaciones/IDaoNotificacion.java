package edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Notificacion;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoNotificacion extends IDao{
    Entity notificacion(Entity e) throws SQLException;
    ArrayList<Notificacion> obtenerNotificaciones(Entity e) throws SQLException;
    int descartarNotificacion (Entity e) throws  SQLException;
}
