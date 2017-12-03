package edu.ucab.desarrollo.viucab.common.entities;


import java.util.ArrayList;

public class Estadistica extends Entity {

    private String username;
    private ArrayList<String> tags;
    private ArrayList<String> nombreVideos;
    private ArrayList<String> likes;
    private ArrayList<String> seguidos;
    private ArrayList<String> teSiguen;
    private ArrayList<String> visualizacionesVideos;
    private ArrayList<String> fecha;

    public Estadistica(){


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<String> getNombreVideos() {
        return nombreVideos;
    }

    public void setNombreVideos(ArrayList<String> nombreVideos) {
        this.nombreVideos = nombreVideos;
    }

    public ArrayList<String> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<String> likes) {
        this.likes = likes;
    }

    public ArrayList<String> getSeguidos() {
        return seguidos;
    }

    public void setSeguidos(ArrayList<String> seguidos) {
        this.seguidos = seguidos;
    }

    public ArrayList<String> getTeSiguen() {
        return teSiguen;
    }

    public void setTeSiguen(ArrayList<String> teSiguen) {
        this.teSiguen = teSiguen;
    }

    public ArrayList<String> getVisualizacionesVideos() {
        return visualizacionesVideos;
    }

    public void setVisualizacionesVideos(ArrayList<String> visualizacionesVideos) {
        this.visualizacionesVideos = visualizacionesVideos;
    }

    public ArrayList<String> getFecha() {
        return fecha;
    }

    public void setFecha(ArrayList<String> fecha) {
        this.fecha = fecha;
    }
}
