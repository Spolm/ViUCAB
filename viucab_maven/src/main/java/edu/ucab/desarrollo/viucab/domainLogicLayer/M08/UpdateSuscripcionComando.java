package edu.ucab.desarrollo.viucab.domainLogicLayer.M08;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.PlConnectException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M08.SuscripcionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

public class UpdateSuscripcionComando extends Command {
    private int suscriptor;
    private int suscripcion;

    public UpdateSuscripcionComando(int suscriptor, int suscripcion) {
        this.suscriptor = suscriptor;
        this.suscripcion = suscripcion;
    }



    @Override
    public void execute() throws BdConnectException , PlConnectException {
        SuscripcionDao dao = DaoFactory.instanciateSuscripcion();
        dao.eliminarSuscriptor(suscriptor,suscripcion);

    }

    @Override
    public Entity Return() {
        return null;
    }
}
