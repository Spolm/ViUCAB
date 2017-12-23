package edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

<<<<<<< HEAD
import java.sql.SQLException;

/**
 * Created by estefania on 29/11/2017.
 */
public class GetSuscritosComando implements Command {
    @Override
    public String execute(int usuario, String categoria) throws SQLException {
        return null;
    }


   /* @Override
    public Entity Return() {
        return null;
    }*/
=======
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
>>>>>>> Develop
}
