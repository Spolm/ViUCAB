package edu.ucab.desarrollo.viucab.common.entities;

<<<<<<< HEAD
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
=======


import java.util.ArrayList;

public class Suscripcion extends Entity {

    private int id;
    private int suscriptor;
    private int suscripcion;


    public Suscripcion(int id, int suscriptor, int suscripcion) {
        this.id = id;
        this.suscriptor = suscriptor;
        this.suscripcion = suscripcion;
    }
    public Suscripcion( int suscriptor, int suscripcion) {

        this.suscriptor = suscriptor;
        this.suscripcion = suscripcion;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSuscriptor() {
        return suscriptor;
    }

    public void setSuscriptor(int suscriptor) {
        this.suscriptor = suscriptor;
    }

    public int getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(int suscripcion) {
        this.suscripcion = suscripcion;
    }
}
>>>>>>> Develop
