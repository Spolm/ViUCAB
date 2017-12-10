package edu.ucab.desarrollo.viucab.common.exceptions.M11;

/**
 * Created by Daniel on 25/11/2017. creada por M011
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

