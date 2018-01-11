package edu.ucab.desarrollo.viucab.common.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name="SimpleException")
public class WebFaulException extends Throwable {


    public WebFaulException(String mensaje) {
        super(mensaje);
        System.out.println("ERROR 500 EN LA CAPA DE PRESENTACION: "+mensaje);
    }
}
