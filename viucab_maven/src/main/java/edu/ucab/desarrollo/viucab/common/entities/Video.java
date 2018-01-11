package edu.ucab.desarrollo.viucab.common.entities;

import edu.ucab.desarrollo.viucab.common.entities.Entity;

import java.util.Date;

public class Video extends Entity {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String imagen;
    private String url;
    private Date fecha;
    private Integer visitas;
    private Integer usuario;

    public Video() {
    }

    public Video(Integer id, String titulo, String descripcion, String imagen, String url, Date fecha, Integer visitas, Integer usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.url = url;
        this.fecha = fecha;
        this.visitas = visitas;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }
}
