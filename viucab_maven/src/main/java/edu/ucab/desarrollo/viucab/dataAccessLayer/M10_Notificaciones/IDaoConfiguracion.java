package edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones;

import edu.ucab.desarrollo.viucab.common.entities.Entity;

import java.sql.SQLException;

public interface IDaoConfiguracion {

    Entity configuracion (Entity e) throws SQLException;

    public void modificarConfiguracion(Entity e) throws SQLException;

}
