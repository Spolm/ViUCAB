package edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones;

import edu.ucab.desarrollo.viucab.common.entities.ConfiguracionNotificaciones;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoConfiguracion {

    Entity configuracion (Entity e) throws SQLException;

    ArrayList<ConfiguracionNotificaciones> getConfiguracion(Entity e) throws SQLException, VIUCABException, BDConnectException1, PLConnectException1;
    public void modificarConfiguracion(Entity e) throws SQLException, VIUCABException, BDConnectException1, PLConnectException1;

}
