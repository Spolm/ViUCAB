package edu.ucab.desarrollo.viucab.domainLogicLayer.M12_ModeracionContenido;



import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M12_ModeracionContenido.GetModeracionContenidoDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.util.ArrayList;

/**
 * Created by Pablo, Jose and Karem on 07/01/2018.
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

    /**
     * Obtiene resultado booleano de la validacion de contraseña, guardado en la variable _resultado
     * @return true o false
     */
    public boolean getValidacion()
    {
        return _resultado;
    }

    /**
     * Metodo que realiza la llamada a el patron DAO en la clase GetModeracionContenidoDao
     * para almacenar los datos obtenidos en la fabrica
     */
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
