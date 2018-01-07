package edu.ucab.desarrollo.viucab.domainLogicLayer;



import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;

/**
 * Patron Comando creada por M011
 */
public abstract class Command
{

    public abstract void execute() throws BDConnectException1, PLConnectException1;

    public abstract Entity Return() ;


}