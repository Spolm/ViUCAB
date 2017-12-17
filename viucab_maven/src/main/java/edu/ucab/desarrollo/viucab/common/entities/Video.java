package edu.ucab.desarrollo.viucab.common.entities;

        import java.util.LinkedList;

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
    private String _valorCategoria;
    private String usuario;
    private LinkedList<Entity> listaVideo;
    private String [] listaRespVideo;


    public Video() {
    }

    public Video(LinkedList listaVideo) {
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LinkedList<Entity> getListaVideo() {
        return listaVideo;
    }

    public void setListaVideo(LinkedList<Entity> listaVideo) {
        this.listaVideo = listaVideo;
    }

    public String[] getListaRespVideo() {
        return listaRespVideo;
    }

    public void setListaRespVideo(String[] listaRespVideo) {
        this.listaRespVideo = listaRespVideo;
    }
}