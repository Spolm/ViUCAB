package edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

/**
 * Created by estefania on 29/11/2017.
 */
public class GetSuscritosComando extends Command {
    int _idUsuario;

    public GetSuscritosComando(int idUsuario) {
        this._idUsuario=idUsuario;
    }

    @Override
    public void execute() {

    }

    @Override
    public Entity Return() {
        return null;
    }
}
