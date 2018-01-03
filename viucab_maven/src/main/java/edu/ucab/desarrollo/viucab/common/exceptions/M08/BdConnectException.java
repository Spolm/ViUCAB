package edu.ucab.desarrollo.viucab.common.exceptions.M08;

/**
 * creada por johan
 */
public class BdConnectException extends Exception {


    public final String ERROR_MSG = "Ha ocurrido un error con la conexión a la base de datos";


    public BdConnectException() {
        System.out.println(ERROR_MSG);
    }


}
