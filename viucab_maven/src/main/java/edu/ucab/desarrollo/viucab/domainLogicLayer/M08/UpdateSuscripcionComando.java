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
    private String resp;

    public UpdateSuscripcionComando(String resp) {
        this.resp = resp;
    }

    public UpdateSuscripcionComando(int suscriptor, int suscripcion) {
        this.suscriptor = suscriptor;
        this.suscripcion = suscripcion;
    }
    public UpdateSuscripcionComando() {
        resp = ObtenerRespuesta();
    }
    public String ObtenerRespuesta(){return resp; };

    @Override
    public void execute() throws BdConnectException , PlConnectException {
        SuscripcionDao dao = DaoFactory.instanciateSuscripcion();
        resp= dao.eliminarSuscriptor(suscriptor,suscripcion);
        System.out.println("ESOOO ES LOO Q AROOOJAAAAA DIABLON"+resp);

    }

    @Override
    public Entity Return() {
        return null;
    }
}
