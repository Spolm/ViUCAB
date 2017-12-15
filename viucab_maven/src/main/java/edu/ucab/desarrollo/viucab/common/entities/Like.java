package edu.ucab.desarrollo.viucab.common.entities;

public class Like {

    int id_usuario;
    int id_video;

    public Like(){

    }

    public Like(int usuario, int id_video){
        this.id_usuario = usuario;
        this.id_video = id_video;
    }

    public int getId_usuario(){
        return this.id_usuario;
    }

    public int getId_video(){
        return this.id_video;
    }

    public void setId_usuario(int usuario){
        this.id_usuario = usuario;
    }

    public void setId_video(int video){
        this.id_video = video;
    }
}

