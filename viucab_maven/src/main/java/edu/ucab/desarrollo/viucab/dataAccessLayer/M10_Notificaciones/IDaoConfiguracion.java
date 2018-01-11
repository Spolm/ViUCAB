package edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones;

import edu.ucab.desarrollo.viucab.common.entities.ConfiguracionNotificaciones;
import edu.ucab.desarrollo.viucab.common.entities.Entity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoConfiguracion {

    Entity configuracion (Entity e) throws SQLException;

    ArrayList<ConfiguracionNotificaciones> getConfiguracion(Entity e) throws SQLException;
    public void modificarConfiguracion(Entity e) throws SQLException;

}
