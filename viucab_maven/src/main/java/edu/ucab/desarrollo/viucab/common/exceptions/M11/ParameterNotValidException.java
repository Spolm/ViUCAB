package edu.ucab.desarrollo.viucab.common.exceptions.M11;

/**
 * Created by Daniel on 25/11/2017. creada por M011
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
