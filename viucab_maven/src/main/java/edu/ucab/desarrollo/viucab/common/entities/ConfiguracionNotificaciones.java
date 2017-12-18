package edu.ucab.desarrollo.viucab.common.entities;

public class ConfiguracionNotificaciones {
    private int id;
    private boolean activado;
    private boolean boletin;
    private boolean subscripciones;
    private boolean etiquetados;
    private boolean estadisticas;
    private boolean preferencias;

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
