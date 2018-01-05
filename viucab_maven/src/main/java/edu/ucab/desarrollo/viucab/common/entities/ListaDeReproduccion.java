package edu.ucab.desarrollo.viucab.common.entities;


/**
 * Clase que extiende de entidad para lista de reproduccion
 */
public class ListaDeReproduccion extends Entity {

    private Integer idLista;
    private String nombre;
    private String descripcion;
    private Integer numReproducciones;
    private String fechaCreacion;
    private Integer idUsuario;

    /**
     * constructor
     * @param idLista
     */
    public ListaDeReproduccion(Integer idLista) {
        this.idLista = idLista;
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
     * Constructor de ListaDeReproduccion
     * @param idLista
     * @param nombre
     * @param descripcion
     * @param numReproducciones
     * @param fechaCreacion
     * @param idUsuario
     */
    public ListaDeReproduccion(Integer idLista, String nombre, String descripcion, Integer numReproducciones, String fechaCreacion, Integer idUsuario) {
        this.idLista = idLista;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numReproducciones = numReproducciones;
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = idUsuario;
    }

    /**
     * Constructor de ListaDeReproduccion
     * @param idLista
     * @param nombre
     * @param descripcion
     * @param numReproducciones
     * @param fechaCreacion
     */
    public ListaDeReproduccion(Integer idLista, String nombre, String descripcion, Integer numReproducciones, String fechaCreacion) {
        this.idLista = idLista;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numReproducciones = numReproducciones;
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Constructor de ListaDeReproduccion
     * @param nombre
     * @param descripcion
     * @param numReproducciones
     * @param fechaCreacion
     */
    public ListaDeReproduccion(String nombre, String descripcion, Integer numReproducciones, String fechaCreacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numReproducciones = numReproducciones;
        this.fechaCreacion = fechaCreacion;
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

    //private Object imagen; ACA DEBE IR LA IMAGEN


}