package edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas;

import java.util.List;

/**
 * Clase para las etiquetas con su relacion con la tabla video
 * @author Daniel Da Silva y Luis Martinez Mod 7
 */

public class Etiquetas {
    private int id;
    private List<Video_Etiq> videoEtiqList;
    private List<Cat_Fil_Etiq> catFilEtiqList;
    private String valor;

    public Etiquetas(int id, List<Video_Etiq> videoEtiqList, List<Cat_Fil_Etiq> catFilEtiqList, String valor) {
        this.id = id;
        this.videoEtiqList = videoEtiqList;
        this.catFilEtiqList = catFilEtiqList;
        this.valor = valor;
    }

    public Etiquetas(String valor){
        this.valor = valor;
    }

    public Etiquetas(int id){
        this.id = id;
    }

    public Etiquetas(int id, String valor){
        this.id = id;
        this.valor = valor;
    }

    public Etiquetas(){}

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public List<Video_Etiq> getVideoEtiqList() {
        return videoEtiqList;
    }

    public void setVideoEtiqList(List<Video_Etiq> videoEtiqList) {
        this.videoEtiqList = videoEtiqList;
    }

    public List<Cat_Fil_Etiq> getCatFilEtiqList() {
        return catFilEtiqList;
    }

    public void setCatFilEtiqList(List<Cat_Fil_Etiq> catFilEtiqList) {
        this.catFilEtiqList = catFilEtiqList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
