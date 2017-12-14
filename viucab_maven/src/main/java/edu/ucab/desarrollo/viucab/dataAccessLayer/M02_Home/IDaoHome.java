package edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by estefania on 13/12/2017.
 */
public interface IDaoHome extends IDao {

    public ArrayList<Entity> GetMasVistosComando()throws SQLException;
    public ArrayList<Entity> GetPreferenciasComando(Entity entidad);
    public ArrayList<Entity> GetSuscritosComando(Entity entidad);
    public ArrayList<Entity> GetBusquedaComando(String parametro) ;


}
