package edu.ucab.desarrollo.viucab.common.entities;

//import java.util.Date;

import edu.ucab.desarrollo.viucab.common.entities.Entity;

import java.io.Serializable;

public class Filtro extends Entity {
    private Integer id;
    private String tipo;
    private String descripcion;
    private boolean valor;

    public Filtro() {

    }

    public Filtro(Integer id, String tipo, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;

    }

    public Filtro(Integer id, String tipo, String descripcion, boolean valor) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.valor = valor;
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

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }
}
