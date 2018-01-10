package edu.ucab.desarrollo.viucab.common.entities;

        import java.util.LinkedList;

import java.util.ArrayList;

/**
 * Created by estefania on 10/11/2017.
 */
public class Video extends Entity{

    private int id;
    private String nombre;
    private String fecha;
    private int visitas;
    private String descripcion;
    private String imagen;
    private String url;
    private String videousu;
    private String videoima;
    private String busqueda;
    private ArrayList<Video> listaVideo;
    private String [] listaRespVideo;


    public Video() {
    }

    public Video(int id, String nombre, String fecha, int visitas, String descripcion, String imagen, String url, String videousu, String videoima) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.visitas = visitas;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.url = url;
        this.videousu = videousu;
        this.videoima = videoima;
    }

    public Video (String busqueda){
        this.busqueda=busqueda;
    }

    public Video(ArrayList listaVideo) {
        this.listaVideo = listaVideo;
    }

    public Video(String [] listaRespVideo) {
        this.listaRespVideo = listaRespVideo;
    }

    public Video(int id, String titulo, String descripcion, String imagen, String fecha, int visitas,
                 String url) {
        this.descripcion=descripcion;
        this.id=id;
        this.fecha=fecha;
        this.nombre=titulo;
        this.imagen=imagen;
        this.url=url;
        this.visitas=visitas;
    }

    public Video(int idUsuario) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
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

    public String getVideousu() {
        return videousu;
    }

    public void setVideousu(String videousu) {
        this.videousu = videousu;
    }

    public String getVideoima() {
        return videoima;
    }

    public void setVideoima(String videoima) {
        this.videoima = videoima;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public ArrayList<Video> getListaVideo() {
        return listaVideo;
    }

    public void setListaVideo(ArrayList<Video> listaVideo) {
        this.listaVideo = listaVideo;
    }

    public String[] getListaRespVideo() {
        return listaRespVideo;
    }

    public void setListaRespVideo(String[] listaRespVideo) {
        this.listaRespVideo = listaRespVideo;
    }
}