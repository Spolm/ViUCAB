package edu.ucab.desarrollo.viucab.domainLogicLayer.M08;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M08.SuscripcionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.util.ArrayList;

public class GetUsuariosComando extends Command {

    ArrayList<Usuario> _resultado=null;
    private  int idSuscriptor;

    private static Entity est;

    //constructores:
    public GetUsuariosComando() {

    }
    public GetUsuariosComando(ArrayList<Usuario> _resultado, int idSuscriptor) {
        this._resultado = _resultado;
        this.idSuscriptor = idSuscriptor;
    }

    public GetUsuariosComando(ArrayList<Usuario> _resultado) {
        this._resultado = _resultado;
    }

    public GetUsuariosComando(int idSuscriptor)  {
        this.idSuscriptor = idSuscriptor;
    }



    /**
     * Metoto que Devuelve la lista de  Usuarios
     *
     */

    public ArrayList<Usuario> get_listUsuario()
    {
        return _resultado;
    }




    @Override
    public void execute() throws VIUCABException  {

        SuscripcionDao dao = DaoFactory.instanciateSuscripcion();
        ArrayList<Usuario> user = dao.listaUsuarios(idSuscriptor);

        //Guardamos lo que devuelve el DAO
        _resultado=user;
    }

    @Override
    public Entity Return() {
        return est;
    }

}
