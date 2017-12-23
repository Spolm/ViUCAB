package edu.ucab.desarrollo.viucab.common.entities;

        import java.awt.*;
        import java.io.InputStream;
<<<<<<< HEAD
=======
        import java.util.ArrayList;
>>>>>>> Develop

/**
 * Created by estefania on 10/11/2017.
 */
public class Video {

<<<<<<< HEAD
    int id;
    String nombre;
    String fecha;
    int visitas;
    String descripcion;
    String imagen;
    String url;
    String _valorCategoria;
    int usuario;
    int categoria;

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Video() {

=======
    private int id;
    private String nombre;
    private String fecha;
    private int visitas;
    private String descripcion;
    private String imagen;
    private String url;
    private String _valorCategoria;
    private String usuario;
    private ArrayList<Video> listaVideo;

    public Video() {
    }

    public Video(ArrayList<Video> listaVideo) {
        this.listaVideo = listaVideo;
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
>>>>>>> Develop
    }

    public String get_valorCategoria() {
        return _valorCategoria;
    }

    public void set_valorCategoria(String _valorCategoria) {
        this._valorCategoria = _valorCategoria;
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
<<<<<<< HEAD
=======

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Video> getListaVideo() {
        return listaVideo;
    }

    public void setListaVideo(ArrayList<Video> listaVideo) {
        this.listaVideo = listaVideo;
    }
>>>>>>> Develop
}