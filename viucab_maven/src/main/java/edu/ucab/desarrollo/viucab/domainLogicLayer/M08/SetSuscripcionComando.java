package edu.ucab.desarrollo.viucab.domainLogicLayer.M08;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M08.SuscripcionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.sql.SQLException;

public class SetSuscripcionComando extends Command {
    private static Entity est;
    private int suscriptor;
    private int suscripcion;

    public SetSuscripcionComando(int suscriptor, int suscripcion) {
        this.suscriptor = suscriptor;
        this.suscripcion = suscripcion;
    }

    @Override
    public void execute() {

        SuscripcionDao dao = DaoFactory.instanciateSuscripcion();
        dao.insertarSuscriptor(suscriptor,suscripcion);


    }

    @Override
    public Entity Return() {
        return est;
    }
}
