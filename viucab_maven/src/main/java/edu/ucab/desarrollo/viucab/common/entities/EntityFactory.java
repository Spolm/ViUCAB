
package edu.ucab.desarrollo.viucab.common.entities;

import java.util.ArrayList;
import java.util.Date;
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
    static public Entity listaDeReproduccion (Integer idLista, String nombre, String descripcion, String imgUrl, Integer numReproducciones, String fechaCreacion, Integer idUsuario)
    {
        return new ListaDeReproduccion(idLista, nombre, descripcion, imgUrl, numReproducciones, fechaCreacion, idUsuario);
    }

    static public Entity getLista(Integer id_usu)
    {
        return new ListaDeReproduccion(id_usu);
    }

    static public Entity getListaEspecifica(Integer id_lista)
    {
        return new ListaDeReproduccion(id_lista, 1);
    }

    static public Entity createLista(String lis_rep_nombre, String lis_rep_descripcion, String lis_rep_img, Integer lis_rep_numrep,
                                    String lis_rep_fecha, Integer id_usu)
    {
        return new ListaDeReproduccion(lis_rep_nombre, lis_rep_descripcion, lis_rep_img, lis_rep_numrep,
        lis_rep_fecha, id_usu);
    }

    static public Entity modifyLista(Integer lis_rep_id, String lis_rep_nombre, String lis_rep_descripcion, String lis_rep_img)
    {
        return new ListaDeReproduccion(lis_rep_id, lis_rep_nombre, lis_rep_descripcion, lis_rep_img, 1,
                "2018-01-11", 4);
    }

    static public Entity deleteList(Integer lis_rep_id)
    {
        return new ListaDeReproduccion(lis_rep_id, "", "", "", 1,
                "2018-01-11", 4);
    }

    static public Entity addOrDeleteVideoToList(Integer lis_rep_id, Integer idVideo)
    {
        return new ListaDeReproduccion(lis_rep_id, idVideo);
    }

    static public Entity getVideosFromList(Integer lis_rep_id)
    {
        return new ListaDeReproduccion(lis_rep_id, null);
    }

    static public Entity video (Integer idLista, String titulo, String imgUrl, Integer numReproducciones, String fechaCreacion, String urlVideo)
    {
        return new Video(idLista, titulo, "", imgUrl, fechaCreacion, numReproducciones,  urlVideo);
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

