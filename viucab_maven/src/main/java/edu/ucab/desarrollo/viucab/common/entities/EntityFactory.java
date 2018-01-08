
package edu.ucab.desarrollo.viucab.common.entities;

import java.util.ArrayList;

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

    static public VideoAux homeUsuario ()
    {
        return new VideoAux();
    }
    static public VideoAux homeUsuario (ArrayList<VideoAux> listaVideos)
    {
        return new VideoAux(listaVideos);
    }

    static public VideoAux homeUsuario( int id, String titulo, String descripcion,
                                     String imagen,String url, String fecha,int visitas){
        return new VideoAux(id,titulo,descripcion,imagen,fecha,visitas,url);
    }
    //final M02

    //Modulo 3

    static public Video instantiateVideo(int videoId, String titulo, String descripcion, String imgUrl){
        return new Video(videoId,titulo,descripcion,imgUrl);
    }

    static public Video instantiateVideo(String titulo, String descripcion,String imgUrl, String url, int usuario ){
        return new Video(titulo,descripcion,imgUrl,url,usuario);
    }

    static public Video instantiateVideo(int id, String titulo, String descripcion, String imgUrl,String url, String fecha, int visitas){
        return new Video(id,titulo,descripcion,imgUrl,url,fecha,visitas);
    }

    static public Video instantiateVideo( ){
        return new Video();
    }
    //End Modulo 3

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
     static public Usuario suscripcionUsuario (String login /*, Image avatar */){return new Usuario(login/*,avatar*/);  }

     static public Suscripcion suscripcion (int suscriptor, int suscripcion){return new Suscripcion(suscriptor,suscripcion);  }

    //final M08

}

