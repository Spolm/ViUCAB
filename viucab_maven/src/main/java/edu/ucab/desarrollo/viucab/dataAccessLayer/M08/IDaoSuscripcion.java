package edu.ucab.desarrollo.viucab.dataAccessLayer.M08;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;

public interface IDaoSuscripcion extends IDao {


    Entity suscripcion (Entity e) throws SQLException, BDConnectException1;

    public void agregarsuscripcion (int suscriptor,int suscripcion) throws SQLException, BDConnectException1;
    public void eliminarsuscripcion (int suscriptor, int suscripcion ) throws SQLException, BDConnectException1;
   // public List<int> listasuscripcion(int suscriptor) throws SQLException, BDConnectException1;



}
