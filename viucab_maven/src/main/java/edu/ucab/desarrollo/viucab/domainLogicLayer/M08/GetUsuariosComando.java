package edu.ucab.desarrollo.viucab.domainLogicLayer.M08;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.PlConnectException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M08.SuscripcionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.util.ArrayList;

public class GetUsuariosComando extends Command {

    ArrayList<Usuario> _resultado=null;
    private  int idSuscriptor;

    private static Entity est;
    public GetUsuariosComando() {

    }
    public GetUsuariosComando(ArrayList<Usuario> _resultado, int idSuscriptor) {
        this._resultado = _resultado;
        this.idSuscriptor = idSuscriptor;
    }
    public GetUsuariosComando(ArrayList<Usuario> _resultado) {
        this._resultado = _resultado;
    }

    public ArrayList<Usuario> get_listUsuario()
    {
        return _resultado;
    }

    //constructores:


    @Override
    public void execute() throws BdConnectException, PlConnectException {

        SuscripcionDao dao = DaoFactory.instanciateSuscripcion();
        ArrayList<Usuario> user = dao.listaUsuarios();

        //Guardamos lo que devuelve el DAO
        _resultado=user;
    }

    @Override
    public Entity Return() {
        return est; //EN ESTE RETURN ES DONDE DEBO DEVOLVER LA LISTA DE USUARIOS
    }

}