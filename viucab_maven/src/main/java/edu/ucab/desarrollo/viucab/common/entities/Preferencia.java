package edu.ucab.desarrollo.viucab.common.entities;

public class Preferencia {

    int id_usuario;
    int id_categoria;

    public Preferencia(){

    }

    public Preferencia(int id_usuario, int categoria){
        this.id_usuario = id_usuario;
        this.id_categoria = categoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
