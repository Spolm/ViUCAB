package edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by estefania on 13/12/2017.
 */
public interface IDaoHome extends IDao {

    public ArrayList<Video> GetMasVistosComando()throws SQLException;
    public ArrayList<Video> GetPreferenciasComando(Entity entidad) throws  SQLException;
    public ArrayList<Video> GetSuscritosComando(Entity entidad) throws  SQLException;
    public ArrayList<Video> GetBusquedaComando(String parametro) throws SQLException;


}
