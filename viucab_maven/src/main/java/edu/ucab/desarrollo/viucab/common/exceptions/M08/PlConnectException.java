package edu.ucab.desarrollo.viucab.common.exceptions.M08;

public class PlConnectException extends Exception {
    public final String ERROR_MSG = "Ha ocurrido un error el  Store Procedure que conecta con la Base de datos " +
            "Revise que este bien escrito el Store Procedure";



    public   PlConnectException()
    {
        System.out.println(ERROR_MSG);
    }



}
