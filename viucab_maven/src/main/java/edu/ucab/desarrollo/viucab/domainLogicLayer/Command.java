package edu.ucab.desarrollo.viucab.domainLogicLayer;



import edu.ucab.desarrollo.viucab.common.entities.Entity;

import java.util.List;

/**
 * Patron Comando creada por M011
 */
public abstract class Command
{

    /***
     * metodo abstracto que es extendido en las clases particulares  de patrones
     */
    public abstract void execute() ;

    /***
     * metodo abstracto que es extendido en las clases particulares  de patrones
     */
    public abstract Entity Return() ;


}