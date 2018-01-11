package edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by estefania on 13/12/2017.
 */
public interface IDaoHome extends IDao {
    /**
     * Metodo que se instancia en el GetHomeDao.java
     * @return
     * @throws SQLException
     * @throws BDConnectException1
     * @throws VIUCABException
     */
    public ArrayList<Video> GetMasVistosComando() throws SQLException, BDConnectException1, VIUCABException, PLConnectException1;

    /**
     * Metodo que se instancia en el GetHomeDao.java
     * @param entidad
     * @return
     * @throws SQLException
     * @throws BDConnectException1
     * @throws VIUCABException
     */
    public ArrayList<Video> GetPreferenciasComando(Entity entidad) throws SQLException, BDConnectException1, VIUCABException, PLConnectException1;

    /**
     * Metodo que se instancia en el GetHomeDao.java
     * @param entidad
     * @return
     * @throws SQLException
     * @throws BDConnectException1
     * @throws VIUCABException
     */
    public ArrayList<Video> GetSuscritosComando(Entity entidad) throws  SQLException, BDConnectException1, VIUCABException;

    /**
     * Metodo que se instancia en el GetHomeDao.java
     * @param entidad
     * @return
     * @throws SQLException
     * @throws BDConnectException1
     * @throws VIUCABException
     */
    public ArrayList<Video> GetBusquedaComando(Entity entidad) throws SQLException, BDConnectException1, VIUCABException;

}
