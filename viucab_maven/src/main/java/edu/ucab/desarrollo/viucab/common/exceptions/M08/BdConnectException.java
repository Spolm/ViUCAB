package edu.ucab.desarrollo.viucab.common.exceptions.M08;

/**
 * creada por johan
 */
public class BdConnectException extends Exception {

    public final int ERROR_CODE = 551;
    public final String ERROR_MSG = "Ha ocurrido un error con la conexión a la base de datos";


    public BdConnectException( Exception e )
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
