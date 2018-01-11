package edu.ucab.desarrollo.viucab.common.entities;

public class ConfiguracionNotificaciones extends Entity{
    private int id;
    private boolean activado;
    private boolean boletin;
    private boolean subscripciones;
    private boolean etiquetados;
    private boolean estadisticas;
    private boolean preferencias;

    public ConfiguracionNotificaciones(int id, boolean activado, boolean boletin, boolean subscripciones,
                                       boolean etiquetados, boolean estadisticas, boolean preferencias) {
        this.id = id;
        this.activado = activado;
        this.boletin = boletin;
        this.subscripciones = subscripciones;
        this.etiquetados = etiquetados;
        this.estadisticas = estadisticas;
        this.preferencias = preferencias;
    }

    public ConfiguracionNotificaciones() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    public boolean isBoletin() {
        return boletin;
    }

    public void setBoletin(boolean boletin) {
        this.boletin = boletin;
    }

    public boolean isSubscripciones() {
        return subscripciones;
    }

    public void setSubscripciones(boolean subscripciones) {
        this.subscripciones = subscripciones;
    }

    public boolean isEtiquetados() {
        return etiquetados;
    }

    public void setEtiquetados(boolean etiquetados) {
        this.etiquetados = etiquetados;
    }

    public boolean isEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(boolean estadisticas) {
        this.estadisticas = estadisticas;
    }

    public boolean isPreferencias() {
        return preferencias;
    }

    public void setPreferencias(boolean preferencias) {
        this.preferencias = preferencias;
    }
}
