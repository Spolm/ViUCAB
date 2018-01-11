package edu.ucab.desarrollo.viucab.dataAccessLayer.M10_Notificaciones;

import edu.ucab.desarrollo.viucab.common.entities.ConfiguracionNotificaciones;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public Entity configuracion(Entity e) throws SQLException {
        return null;
    }

    public ArrayList<ConfiguracionNotificaciones> getConfiguracion(Entity e) throws SQLException {
        ConfiguracionNotificaciones config = (ConfiguracionNotificaciones) e;
        ArrayList<ConfiguracionNotificaciones> listaConfig = new ArrayList<>();
        Connection conexion;
        ResultSet result = null;
        PreparedStatement ps = null;
        try {
            conexion = Dao.getBdConnect();
            ps = conexion.prepareCall("{ call m10_getconfiguracion(?) }");
            // id por default
            ps.setInt(1, 1);
            result = ps.executeQuery();
            while(result.next()) {
                int id = (result.getInt("con_not_id"));
                Boolean activado = (result.getBoolean("con_not_recibir"));
                Boolean boletin = (result.getBoolean("con_not_boletin"));
                Boolean subscripciones = (result.getBoolean("con_not_suscripciones"));
                Boolean etiquetados = (result.getBoolean("con_not_etiquetado"));
                Boolean estadisticas = (result.getBoolean("con_not_estadisticas"));
                Boolean preferencias = (result.getBoolean("con_not_preferencias"));
                config = new ConfiguracionNotificaciones(id, activado, boletin, subscripciones, etiquetados, estadisticas, preferencias);
                listaConfig.add(config);
                break;
            }
            result.close();
        }
        catch (SQLException error){
            error.getMessage();
        }
        finally {
            closeConnection();
        }
        return listaConfig;
    }
    // Modificar para que se traiga todos los datos correctos de Entity e
    @Override
    public void modificarConfiguracion(Entity e) throws SQLException {
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