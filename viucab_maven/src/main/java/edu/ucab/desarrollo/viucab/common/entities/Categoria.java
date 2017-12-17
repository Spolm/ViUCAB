package edu.ucab.desarrollo.viucab.common.entities;

public class Categoria {

    int id;
    String valor;

    public Categoria(){

    }

    public Categoria(int id, String valor){

        this.id = id;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
