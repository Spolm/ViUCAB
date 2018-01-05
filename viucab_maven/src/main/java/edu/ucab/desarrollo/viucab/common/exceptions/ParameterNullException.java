package edu.ucab.desarrollo.viucab.common.exceptions;

/**
 * creada por johan
 */
public class ParameterNullException extends Exception {

    private String paramName;
    public ParameterNullException(String paramName) {
        this.paramName = paramName;
    }
    public ParameterNullException(String s, String paramName) {
        super(s);
        this.paramName = paramName;
    }

    @Override
    public String getMessage(){
        return "Error: el siguientes campo es null, " + paramName;
    }
}

