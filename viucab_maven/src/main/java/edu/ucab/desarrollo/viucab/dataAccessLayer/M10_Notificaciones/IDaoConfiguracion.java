package edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;

import java.sql.SQLException;

public interface IDaoConfiguracion {

    Entity configuracion (Entity e) throws SQLException, BdConnectException;

    public void modificarConfiguracion(Entity e) throws SQLException, BdConnectException;

}
