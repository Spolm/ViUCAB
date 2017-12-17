package edu.ucab.desarrollo.viucab.domainLogicLayer;



import edu.ucab.desarrollo.viucab.common.entities.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * Patron Comando creada por M011
 */
public interface  Command
{

    public String execute(int usuario, String categoria) throws SQLException;

    //public abstract Entity Return() ;


}