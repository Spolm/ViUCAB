package edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home;


import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

/**
 * Created by estefania on 29/11/2017.
 */
public class GetBusquedaComando extends Command{
    String _criterio;


    public GetBusquedaComando(String criterio) {
        this._criterio=criterio;
    }


    @Override
    public void execute() {


    }

    @Override
    public Entity Return() {
        return null;
    }
}
