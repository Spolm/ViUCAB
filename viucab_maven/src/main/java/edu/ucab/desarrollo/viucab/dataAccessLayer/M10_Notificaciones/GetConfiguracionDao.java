package edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones;

import edu.ucab.desarrollo.viucab.common.entities.ConfiguracionNotificaciones;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetConfiguracionDao extends Dao implements IDaoConfiguracion  {

    public GetConfiguracionDao(){

    }

    @Override
    public Entity create(Entity e) {
        return null;
    }

    @Override
    public Entity read(Entity e) {
        return null;
    }

    @Override
    public Entity update(Entity e) {
        return null;
    }

    //Metodo que obtiene la configuracion de notificaciones de la BDD
    @Override
    public Entity configuracion(Entity e) throws SQLException, BdConnectException {
        Connection conexion;
        ResultSet result = null;
        String select="SELECT * FROM config_notificacion WHERE usu_id = ?;";
        PreparedStatement ps = null;
        Entity config = null;
        try {
            conexion = getBdConnect();
            ps = conexion.prepareStatement(select);
            // id por default
            ps.setInt(1, 1);
            result = ps.executeQuery();
            int id = (result.getInt("con_not_id"));
            boolean boletin = (result.getBoolean("con_not_boletin"));
            boolean preferencias = (result.getBoolean("con_not_preferencias"));
            boolean activado = (result.getBoolean("con_not_recibir"));
            boolean subscripciones = (result.getBoolean("con_not_suscripciones"));
            boolean etiquetados = (result.getBoolean("con_not_etiquetado"));
            boolean estadisticas = (result.getBoolean("con_not_estadisticas"));
            config = EntityFactory.configuracionNotificaciones(id,activado,boletin,subscripciones,etiquetados,estadisticas,preferencias);
            result.close();
        }
        catch (SQLException error){
            error.getMessage();
        }
        finally {
            closeConnection();
        }
        return config;
    }
    // Modificar para que se traiga todos los datos correctos de Entity e
    @Override
    public void modificarConfiguracion(Entity e) throws SQLException, BdConnectException {
        Connection conexion;
        ResultSet result = null;
        String select= "UPDATE config_notificacion SET " +
                "con_not_boletin = ?, con_not_recibir =? , " +
                "con_not_preferencias = ?, con_not_suscripciones = ?, " +
                "con_not_etiquetado = ?, con_not_estadisticas =? " +
                "WHERE con_not_id = ?;";
        PreparedStatement ps = null;
        Entity config = (ConfiguracionNotificaciones) e;
        try {
            conexion = getBdConnect();
            ps = conexion.prepareStatement(select);
           ps.setInt(1, config.get_id());
        }
        catch (SQLException error){
            error.printStackTrace();
        }
        finally {
            closeConnection();
        }
    }
}
//