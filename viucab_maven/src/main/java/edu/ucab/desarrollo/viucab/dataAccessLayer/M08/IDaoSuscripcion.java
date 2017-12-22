package edu.ucab.desarrollo.viucab.dataAccessLayer.M08;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;

import java.sql.SQLException;

public interface IDaoSuscripcion extends IDao {


    Entity suscripcion (Entity e) throws SQLException, BdConnectException;

    public void agregarsuscripcion (int suscriptor,int suscripcion) throws SQLException, BdConnectException;
    public void eliminarsuscripcion (int suscriptor, int suscripcion ) throws SQLException, BdConnectException;
   // public List<int> listasuscripcion(int suscriptor) throws SQLException, BdConnectException;



}
