package edu.ucab.desarrollo.viucab.common.exceptions.M08;

import javax.xml.ws.WebFault;

@WebFault(name="SimpleException")
public class WebFaulException extends Throwable {


    public WebFaulException(String mensaje) {
        super(mensaje);
    }
}
