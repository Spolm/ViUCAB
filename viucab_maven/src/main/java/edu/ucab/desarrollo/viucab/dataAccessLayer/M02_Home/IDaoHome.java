package edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by estefania on 13/12/2017.
 */
public interface IDaoHome extends IDao {

    public LinkedList<Entity> GetMasVistosComando()throws SQLException;
    public LinkedList<Entity> GetPreferenciasComando(Entity entidad) throws  SQLException;
    public LinkedList<Entity> GetSuscritosComando(Entity entidad) throws  SQLException;
    public LinkedList<Entity> GetBusquedaComando(String parametro) throws SQLException;


}
