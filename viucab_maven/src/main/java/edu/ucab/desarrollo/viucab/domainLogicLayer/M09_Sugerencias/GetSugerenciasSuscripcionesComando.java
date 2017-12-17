package edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias;

import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.sql.SQLException;

public class GetSugerenciasSuscripcionesComando implements Command {

    @Override
    public String execute(int usuario, String categoria) throws SQLException {
        Dao dao = new Dao();
        return dao.getSugerenciasLike(usuario, categoria);
    }

}
