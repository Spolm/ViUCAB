package edu.ucab.desarrollo.viucab.common.entities;


public class Estadistica extends Entity {

    private String username;
    private String [] label;
    private String [] data;

    public Estadistica(String username, String [] label, String [] data){

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

    public String [] getLabel() {
        return label;
    }

    public void setLabel(String [] label) {
        this.label = label;
    }

    public String [] getData() {
        return data;
    }

    public void setData(String [] data) {
        this.data = data;
    }
}
