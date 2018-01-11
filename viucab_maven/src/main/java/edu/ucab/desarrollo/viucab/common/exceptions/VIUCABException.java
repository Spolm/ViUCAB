package edu.ucab.desarrollo.viucab.common.exceptions;

import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

/**
 * Created by Daniel on 30/11/2017.
 * excepcion que sera manipulada
 * por el flujo
 */

public class VIUCABException extends Exception {

    public final int ERROR_CODE = 550;
    public final String ERROR_MSG = "Ha ocurrido un error ";
    private String _clase;
    private String _metodo;


    /**
     * excepcion personalizada para el agregar
     */
    public VIUCABException(Exception error, String clase, String metodo) {
        super(error);
        _clase = clase;
        _metodo = metodo;
    }

    public VIUCABException(String error) {
        super(error);

    }

    public VIUCABException(Exception error) {
        super(error);

    }

    public VIUCABException(String descripcion,Exception error) {
        super(descripcion+" "+ error);

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