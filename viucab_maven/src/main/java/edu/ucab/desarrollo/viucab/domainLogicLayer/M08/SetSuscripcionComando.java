package edu.ucab.desarrollo.viucab.domainLogicLayer.M08;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.PlConnectException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M08.SuscripcionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.sql.SQLException;
import java.util.ArrayList;

public class SetSuscripcionComando extends Command {
    private static Entity est;
    private int suscriptor;
    private int suscripcion;
    private String resp;

    public SetSuscripcionComando(String resp) {
        this.resp = resp;
    }

    public SetSuscripcionComando(int suscriptor, int suscripcion) {
        this.suscriptor = suscriptor;
        this.suscripcion = suscripcion;
    }

    public SetSuscripcionComando() {
        resp = ObtenerRespuesta();
    }

    public String ObtenerRespuesta(){return resp; };


    @Override
    public void execute() throws BdConnectException , PlConnectException {

        SuscripcionDao dao = DaoFactory.instanciateSuscripcion();
         resp= dao.insertarSuscriptor(suscriptor,suscripcion);


    }


    @Override
    public Entity Return() {
        return est;
    }
}
