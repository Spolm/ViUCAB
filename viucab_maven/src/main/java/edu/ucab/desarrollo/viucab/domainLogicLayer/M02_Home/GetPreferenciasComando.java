package edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.sql.SQLException;

/**
 * Created by estefania on 29/11/2017.
 */
public class GetPreferenciasComando implements Command {
    @Override
    public String execute(int usuario, String categoria) throws SQLException {
        return null;
    }

/*
    @Override
    public Entity Return() {
        return null;
    }*/
}
