package edu.ucab.desarrollo.viucab.domainLogicLayer.M08;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;

import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M08.SuscripcionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.util.ArrayList;

/**
 *
 */
public class GetSuscripcionComando extends Command {

    private static Entity est;

    ArrayList<Usuario>_resultado=null;
    private  int idSuscriptor;

    //Constructores:
    public GetSuscripcionComando(int idSuscriptor) {
        this.idSuscriptor = idSuscriptor;
    }

    public GetSuscripcionComando(ArrayList<Usuario> _resultado) {
        this._resultado = _resultado;
    }

    public GetSuscripcionComando() {
        _resultado=get_listUsuario();
    }



        /**
         * Metoto que Devuelve la lista de Suscricpiones de un Usuario
         *
         */
    public ArrayList<Usuario> get_listUsuario()
    {
        return _resultado;
    }

    /**
     * Obtiene Resultaddo de las Busquedas
     * @return ListVideo
     */

    @Override
    public void execute() throws BDConnectException1, PLConnectException1 {

        SuscripcionDao dao = DaoFactory.instanciateSuscripcion();
        ArrayList<Usuario> user = dao.listaSuscripciones(idSuscriptor);

        //Guardamos lo que devuelve el DAO
        _resultado=user;
    }


    @Override
    public Entity Return() {
        return est;
    }
}