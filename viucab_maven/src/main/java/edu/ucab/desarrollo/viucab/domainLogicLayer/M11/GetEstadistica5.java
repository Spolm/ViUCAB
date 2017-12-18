package edu.ucab.desarrollo.viucab.domainLogicLayer.M11;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.sql.SQLException;

/**
 * Created by Daniel on 25/11/2017.
 */
public class GetEstadistica5 implements Command {

    public GetEstadistica5(Entity est) {
    }



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
