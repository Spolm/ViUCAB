
package edu.ucab.desarrollo.viucab.common.entities;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Fabrica de Entidades creada por M011
 */

public class EntityFactory
{
    //region M011
    static public Entity estadisticaUsuario (String username, String [] label,String [] data)
    {
        return new Estadistica(username,label,data);
    }
    static public Entity estadistica (String username)
    {
        return new Estadistica(username);
    }
    //endregion

    //region M02

    static public Entity homeUsuario ()
    {
        return new Video();
    }
    static public Entity homeUsuario ( int idUsuario) {return new Usuario(idUsuario);}
    static public Entity homeUsuario (ArrayList<Video> listaVideos)
    {
        return new Video(listaVideos);
    }

    static public Entity homeUsuario( int id, String titulo, String descripcion,
                                     String imagen,String url, String fecha,int visitas,String nombre , String foto){
        return new Video(id,titulo,fecha,visitas,descripcion,imagen,url,nombre,foto);
    }

    static  public Entity homeUsuario(String parametro){
        return new Video();
    }
    //final M02

    //region M05

    /**
     * Factory de ListaDeReproduccion
     * @param nombre
     * @param descripcion
     * @param numReproducciones
     * @param fechaCreacion
     * @return nombre,descripcion,numReproducciones,fechaCreacion
     */
    static public Entity listaDeReproduccion (Integer idLista, String nombre, String descripcion, Integer numReproducciones, String fechaCreacion)
    {
        return new ListaDeReproduccion(idLista, nombre, descripcion, numReproducciones, fechaCreacion);
    }

    static public Entity listaDeReproduccion (String nombre, String descripcion, Integer numReproducciones, String fechaCreacion)
    {
        return new ListaDeReproduccion(nombre, descripcion, numReproducciones, fechaCreacion);
    }

    static public Entity obtenerLista(Integer id_lista, Integer id_usu)
    {
        return new ListaDeReproduccion(id_lista, id_usu);
    }

    //endregion

    //region M07

    static public Entity insertEtiqueta(String valor){
        return new Etiquetas(valor);
    }

    static public Entity eliminarEtiqueta(int id){
        return new Etiquetas(id);
    }

    static public Entity consultarVideos(int id){
        return new Etiquetas(id);
    }

    //endregion

    //region M08


   // static public Video suscripcionUsuario (ArrayList<Usuario> listaUsuarios)
    //{
     //  return new  //Usuario(listaUsuarios);
    //}
     //static public Usuario suscripcionUsuario (String login /*, Image avatar */){return new Usuario(login/*,avatar*/);  }
     static public Usuario suscripcionUsuario (int id, String login /*, Image avatar */){return new Usuario(id, login/*,avatar*/);  }
     static public Suscripcion suscripcion (int suscriptor, int suscripcion){return new Suscripcion(suscriptor,suscripcion);  }

    //final M08

}

