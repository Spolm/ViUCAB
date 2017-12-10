package edu.ucab.desarrollo.viucab.common.exceptions.M11;

/**
 * Created by Daniel on 25/11/2017. creada por M011
 */
public class ListAllException extends Exception {

    public final int ERROR_CODE = 552;
    public final String ERROR_MSG = "Ha ocurrido un error consultado";

    public ListAllException( Exception e )
    {
        super( e );
    }

    @Override
    public String toString()
    {
        StringBuilder str = null;


        str = new StringBuilder( ERROR_CODE + "\n" );
        str.append( ERROR_MSG + "\n" );
        str.append( super.toString() );

        return str.toString();
    }
}
