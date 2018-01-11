package edu.ucab.desarrollo.viucab.common.exceptions;
/**
 * creada por M08
 */
public class PLConnectException1 extends Exception {

    public final String ERROR_MSG = "Ha ocurrido un error el  Store Procedure que conecta con la Base de datos " +
            "Revise que este bien escrito el Store Procedure";



    public PLConnectException1(Exception e)
    {
        super(e);
        System.out.println(ERROR_MSG+e);
    }



}
