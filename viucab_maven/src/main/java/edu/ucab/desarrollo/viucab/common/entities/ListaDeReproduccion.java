package edu.ucab.desarrollo.viucab.common.entities;


import java.util.Date;

/**
 * Clase que extiende de entidad para lista de reproduccion
 */
public class ListaDeReproduccion extends Entity {

    private Integer idLista;
    private String nombre;
    private String descripcion;
    private String urlImg;
    private Integer numReproducciones;
    private String fechaCreacion;
    private Integer idUsuario;

    /**
     * constructor
     * @param idUsuario
     */
    public ListaDeReproduccion(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * constructor
     * @param idLista
     * @param idUsuario
     */
    public ListaDeReproduccion(Integer idLista, Integer idUsuario) {
        this.idUsuario = idUsuario;
        this.idLista = idLista;
    }

    /**
     * Constructor
     * @param lis_rep_nombre
     * @param lis_rep_descripcion
     * @param lis_rep_img
     * @param lis_rep_numrep
     * @param lis_rep_fecha
     * @param id_usu
     */
    public ListaDeReproduccion(String lis_rep_nombre, String lis_rep_descripcion, String lis_rep_img, int lis_rep_numrep,
                               String lis_rep_fecha, Integer id_usu) {
        this.nombre = lis_rep_nombre;
        this.descripcion = lis_rep_descripcion;
        this.urlImg = lis_rep_img;
        this.numReproducciones = lis_rep_numrep;
        this.fechaCreacion = lis_rep_fecha;
        this.idUsuario = id_usu;
    }

    /**
     * Constructor de ListaDeReproduccion
     * @param idLista
     * @param nombre
     * @param descripcion
     * @param numReproducciones
     * @param fechaCreacion
     */
    public ListaDeReproduccion(Integer idLista, String nombre, String descripcion, String urlImg, Integer numReproducciones, String fechaCreacion, Integer idUsuario) {
        this.idLista = idLista;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
        this.numReproducciones = numReproducciones;
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = idUsuario;
    }


    /**
     * Getter
     * @return idLista
     */
    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumReproducciones() {
        return numReproducciones;
    }

    public void setNumReproducciones(Integer numReproducciones) {
        this.numReproducciones = numReproducciones;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUrlImg() {
        return this.urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}