package edu.ucab.desarrollo.viucab.domainLogicLayer;



import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.PlConnectException;

import java.util.ArrayList;
import java.util.List;

/**
 * Patron Comando creada por M011
 */
public abstract class Command
{

    public abstract void execute() throws BdConnectException, PlConnectException;

    public abstract Entity Return() ;

    public abstract ArrayList<Entity> executeCommand();

}