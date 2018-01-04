package edu.ucab.desarrollo.viucab.common.exceptions.M08;

/**
 * creada por johan
 */
public class BdConnectException extends Exception {

    //System.out.println();

    public final String ERROR_MSG = "Ha ocurrido un error con la conexión a la base de datos";


    public BdConnectException(Exception e) {
        super(e);
        System.out.println(ERROR_MSG+e);

    }


}
