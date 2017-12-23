package edu.ucab.desarrollo.viucab.domainLogicLayer;



import edu.ucab.desarrollo.viucab.common.entities.Entity;
<<<<<<< HEAD

import java.sql.SQLException;
=======
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.PlConnectException;

>>>>>>> Develop
import java.util.List;

/**
 * Patron Comando creada por M011
 */
<<<<<<< HEAD
public interface  Command
{

    public String execute(int usuario, String categoria) throws SQLException;

    //public abstract Entity Return() ;
=======
public abstract class Command
{

    public abstract void execute() throws BdConnectException, PlConnectException;

    public abstract Entity Return() ;
>>>>>>> Develop


}