package edu.ucab.desarrollo.viucab.common.exceptions;

/**
 * creada por johan
 */
public class ParameterNotValidException extends Exception {

    private String paramName;
    public ParameterNotValidException(String paramName) {
        this.paramName = paramName;
    }
    public ParameterNotValidException(String s, String paramName) {
        super(s);
        this.paramName = paramName;
    }

    @Override
    public String getMessage(){
        return "Error: el campo "+ paramName +" es invalido.";
    }
}
