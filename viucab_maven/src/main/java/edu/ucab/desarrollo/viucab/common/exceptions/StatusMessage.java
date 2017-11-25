package edu.ucab.desarrollo.viucab.common.exceptions;

/**
 * Created by Daniel on 25/11/2017. creada por M011
 */
public class StatusMessage {

    private int _code;
    private String _message;

    /**
     * Constructor vacio
     */
    public StatusMessage() {
    }

    /**
     * Constructor para crear el codigo de error con el mensaje
     * @param code Codigo que especifica el numero que represetara el mensaje
     * @param message Mensaje que seguira el codigo
     */
    public StatusMessage(int code, String message) {
        _code = code;
        _message = message;
    }

    public int getCode() {
        return _code;
    }

    public void setCode(int code) {
        _code = code;
    }

    public String getMessage() {
        return _message;
    }

    public void setMessage(String message) {
        _message = message;
    }
}
