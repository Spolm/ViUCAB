package edu.ucab.desarrollo.viucab.common.exceptions.M11;

/**
 * Created by Daniel on 25/11/2017. creada por M011
 */
public class ParametersNullException extends Exception {

    private String paramName;
    private final int status = 501;
    /**
     * Constructor que recibe el nombre del parametro nulo
     * @param paramName nombre del parametro obligatorio que es nulo
     */
    public ParametersNullException(String paramName) {
        this.paramName = paramName;
    }

    public ParametersNullException(String s, String paramName) {
        super(s);
        this.paramName = paramName;
    }

    /**
     * Getter que obtiene el estatus del error
     * @return _status
     */
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage(){
        return "Error: el siguientes campo es null, " + paramName;
    }

}
