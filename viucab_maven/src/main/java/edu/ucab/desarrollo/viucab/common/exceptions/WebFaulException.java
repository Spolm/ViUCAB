package edu.ucab.desarrollo.viucab.common.exceptions;

import javax.xml.ws.WebFault;

@WebFault(messageName="SimpleException")
public class WebFaulException extends Throwable {


    public WebFaulException(String mensaje) {
        super("ERROR 500 EN LA CAPA DE PRESENTACION:  "+mensaje);
        System.out.println("ERROR 500 EN LA CAPA DE PRESENTACION: "+mensaje);
    }
}
