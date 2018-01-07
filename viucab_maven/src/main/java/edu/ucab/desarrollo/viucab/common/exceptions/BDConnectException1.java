package edu.ucab.desarrollo.viucab.common.exceptions;

/**
 * creada por M08
 */
public class BDConnectException1 extends Exception {

    //System.out.println();

    public final String ERROR_MSG = "Ha ocurrido un error con la conexión a la base de datos";


    public BDConnectException1(Exception e) {
        super(e);
        System.out.println(ERROR_MSG+e);

    }


}
