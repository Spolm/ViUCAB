package edu.ucab.desarrollo.viucab.common.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class ContenedorIdListaVideos extends Entity implements Serializable{
    private Integer id;
    private ArrayList<Video> listaVideos;

    public ContenedorIdListaVideos() {
    }

    public ContenedorIdListaVideos(Integer id, ArrayList<Video> listaVideos) {
        this.id = id;
        this.listaVideos = listaVideos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Video> getListaVideos() {
        return listaVideos;
    }

    public void setListaVideos(ArrayList<Video> listaVideos) {
        this.listaVideos = listaVideos;
    }
}
