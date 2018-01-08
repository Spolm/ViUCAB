package edu.ucab.desarrollo.viucab.common.entities;

//import java.util.Date;

public class Filtro {
    private Integer id;
    private String tipo;
    private String descripcion;

    public Filtro() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
