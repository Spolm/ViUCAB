package edu.ucab.desarrollo.viucab.common.entities;


import java.util.ArrayList;

public class Estadistica extends Entity {

    private String username;
    private ArrayList<String> label;
    private ArrayList<String> data;

    public Estadistica(String username,  ArrayList<String> label, ArrayList<String> data){

        this.username = username;
        this.label = label;
        this.data = data;
    }

    public Estadistica(String username){

        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getLabel() {
        return label;
    }

    public void setLabel(ArrayList<String> label) {
        this.label = label;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}
