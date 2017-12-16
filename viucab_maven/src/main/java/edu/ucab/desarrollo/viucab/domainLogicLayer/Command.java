package edu.ucab.desarrollo.viucab.domainLogicLayer;



import edu.ucab.desarrollo.viucab.common.entities.Entity;

import java.util.List;

/**
 * Patron Comando creada por M011
 */
public abstract class Command
{

    public abstract void execute() ;

    public abstract Entity Return() ;


}