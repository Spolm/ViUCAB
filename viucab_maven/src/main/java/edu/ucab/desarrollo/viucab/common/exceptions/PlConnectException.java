package edu.ucab.desarrollo.viucab.common.exceptions;

public class PlConnectException extends Exception {
    public final String ERROR_MSG = "Ha ocurrido un error el  Store Procedure en la Base de datos";


    public PlConnectException( Exception e )
    {
        super(e);
    }

    @Override
    public String toString()
    {
        StringBuilder str = null;

        str.append( ERROR_MSG + "\n" );
        str.append( super.toString() );

        return str.toString();
    }
}