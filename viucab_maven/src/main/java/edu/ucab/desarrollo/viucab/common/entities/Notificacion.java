package edu.ucab.desarrollo.viucab.common.entities;

import java.util.Date;

public class Notificacion extends Entity {
    private int id;
    private Video video;
    private Usuario usuario;
    private boolean desechado;
    private Date fecha;

    public Notificacion(int id) {
        this.id = id;
    }


    public Notificacion(int id, Video video, Usuario usuario, boolean desechado, Date fecha) {
        this.id = id;
        this.video = video;
        this.usuario = usuario;
        this.desechado = desechado;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isDesechado() {
        return desechado;
    }

    public void setDesechado(boolean desechado) {
        this.desechado = desechado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Notificacion(){

    }

}
