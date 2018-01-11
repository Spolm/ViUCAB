package edu.ucab.desarrollo.viucab.common.exceptions;

/**
 * Created by Daniel on 25/11/2017. creada por M011
 */
public class MessageException extends RuntimeException{

    private int _code = 999;
    private String _clase;
    private String _metodo;

    public MessageException(Exception error, String clase, String metodo) {
        super(error);
        _clase = clase;
        _metodo = metodo;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(_code);
        str.append(_clase);
        str.append(_metodo);
        str.append(super.toString());
        return str.toString();
    }

    public int get_code() {
        return _code;
    }

    public void set_code(int _code) {
        this._code = _code;
    }

    public String get_clase() {
        return _clase;
    }

    public void set_clase(String _clase) {
        this._clase = _clase;
    }

    public String get_metodo() {
        return _metodo;
    }

    public void set_metodo(String _metodo) {
        this._metodo = _metodo;
    }
}
