package edu.ucab.desarrollo.viucab.domainLogicLayer.M08;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;

import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.PlConnectException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M08.SuscripcionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 *
 */
public class GetSuscripcionComando extends Command {

    private static Entity est;

    ArrayList<Usuario>_resultado=null;

    public GetSuscripcionComando(ArrayList<Usuario> _resultado) {
        this._resultado = _resultado;
    }

    public GetSuscripcionComando() {
        _resultado=get_listUsuario();
    }

    /**
     * Obtiene Resultaddo de las Busquedas
     * @return ListVideo
     */
    public ArrayList<Usuario> get_listUsuario()
    {
        return _resultado;
    }

    @Override
    public void execute() throws BdConnectException, PlConnectException {

    }

    /*
        @Override
        public  ArrayList<Suscripciones>  execute() {

            // Eliminar el manejo de excepciones del comando y colocarlo en presentacion


            ////Echo por bismarck
            SuscripcionDao dao = DaoFactory.instanciateSuscripcion();
            return dao.insertarSuscriptor(suscriptor,suscripcion);
            /////


               SuscripcionDao dao = DaoFactory.instanciateSuscripcion();

                ArrayList<Usuario> user = dao.listaSuscripciones(1);

               // est=

        }
    */
    @Override
    public Entity Return() {
        return est; //EN ESTE RETURN ES DONDE DEBO DEVOLVER LA LISTA DE SUSCRIPCIONES
    }
}