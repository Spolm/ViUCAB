package edu.ucab.desarrollo.viucab.domainLogicLayer.M12_ModeracionContenido;


import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M12_ModeracionContenido.GetModeracionContenidoDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.util.ArrayList;

/**
 * Created by jose on 08/11/2017.
 */
public class ValidarAccesoComando extends Command {

    Integer id;
    String claveApp;
    Entity est;
    boolean _resultado;

    public ValidarAccesoComando(Integer id, String claveApp) {
        this.id=id;
        this.claveApp=claveApp;
    }

    public boolean getValidacion()
    {
        return _resultado;
    }


    @Override
    public void execute() {
        try {
            GetModeracionContenidoDao dao =  DaoFactory.instanciarModeracionContenidoDao();
            _resultado = dao.compararPassword(id, claveApp);

        }
        catch (Exception e){

        }

    }
    @Override
    public Entity Return() {
        return est;
    }

}
