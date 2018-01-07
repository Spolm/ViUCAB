package edu.ucab.desarrollo.viucab.common.entities;



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