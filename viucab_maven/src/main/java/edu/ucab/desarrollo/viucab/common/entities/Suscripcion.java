package edu.ucab.desarrollo.viucab.common.entities;

public class Suscripcion {

    int id_suscriptor;
    int id_suscripcion;

    public Suscripcion(){

    }

    public Suscripcion(int suscriptor, int suscripcion){
        this.id_suscripcion = suscripcion;
        this.id_suscriptor = suscriptor;
    }

    public int getId_suscriptor(){
        return this.id_suscriptor;
    }

    public void setId_suscriptor(int suscriptor){
        this.id_suscriptor = suscriptor;
    }

    public void setId_suscripcion(int suscripcion){
        this.id_suscripcion = suscripcion;
    }
}
