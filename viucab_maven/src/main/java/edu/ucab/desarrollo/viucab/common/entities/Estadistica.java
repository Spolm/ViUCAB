package edu.ucab.desarrollo.viucab.common.entities;

/***
 * objeto estadistica que se usara para mostrar los datos traidos de la base de datos.
 */
public class Estadistica extends Entity {

    private String username;
    private String[] label;
    private String[] data;
    private String nombre;

    /***
     * constructor
     * @param username
     * @param label
     * @param data
     */
    public Estadistica(String username, String[] label, String[] data) {

        this.username = username;
        this.label = label;
        this.data = data;

    }

    /***
     * constructor
     * @param username
     */
    public Estadistica(String username) {

        this.username = username;
    }

    /***
     * getter and setter
     * @return
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getLabel() {
        return label;
    }

    public void setLabel(String[] label) {
        this.label = label;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public void setNombre(String nombre)
    {
    this.nombre = nombre;
    }
}
