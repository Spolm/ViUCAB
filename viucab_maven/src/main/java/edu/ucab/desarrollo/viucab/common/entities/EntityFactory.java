
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

    static public Entity homeVideo(int idUsuario) {return new Usuario(idUsuario);}


    //final M02

    //Modulo 3

    static public VideoEntity instantiateVideoEntity(int videoId, String titulo, String descripcion, String imgUrl){
        return new VideoEntity(videoId,titulo,descripcion,imgUrl);
    }

    static public VideoEntity instantiateVideoEntity(String titulo, String descripcion, String imgUrl, String url, int usuario ){
        return new VideoEntity(titulo,descripcion,imgUrl,url,usuario);
    }

    static public VideoEntity instantiateVideoEntity(int id, String titulo, String descripcion, String imgUrl, String url, String fecha, int visitas){
        return new VideoEntity(id,titulo,descripcion,imgUrl,url,fecha,visitas);
    }

    static public VideoEntity instantiateVideoEntity( ){
        return new VideoEntity();
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


    //endregion

    //region M07

    static public Entity insertEtiqueta(String valor, int idVid){
        Video_Etiq vid = new Video_Etiq(idVid);
        return new Etiquetas(valor, vid);
    }

    static public Entity eliminarEtiqueta(int idVid, String valor){
        Video_Etiq vid = new Video_Etiq(idVid);
        return new Etiquetas(valor, vid);
    }

    static public Entity consultarVideos(int id){
        Video_Etiq vid = new Video_Etiq(id);
        Etiquetas eti = new Etiquetas();
        eti.setVideoEtiqList(vid);
        return eti;
    }

    //endregion

    //region M08


   // static public Video suscripcionUsuario (ArrayList<Usuario> listaUsuarios)
    //{
     //  return new  //Usuario(listaUsuarios);
    //}
     static public Usuario suscripcionUsuario (int id,String login /*, Image avatar */){return new Usuario(id, login/*,avatar*/);  }

     static public Suscripcion suscripcion (int suscriptor, int suscripcion){return new Suscripcion(suscriptor,suscripcion);  }

    //final M08

    //M12

    static public Entity filtro (int id, String tipo, String descripcion){
        return new Filtro(id,tipo,descripcion);
    }

    static public Entity filtro (int id, String tipo, String descripcion, boolean valor){
        return new Filtro(id,tipo,descripcion,valor);
    }

    static public Entity video(Integer id, String titulo, String descripcion, String imagen, String url, Date fecha, Integer visitas, Integer usuario){
        return new Video(id, titulo, descripcion, imagen, url, fecha, visitas, usuario);
    }

    static public Entity contenedorIdListaFiltros(Integer id, ArrayList<Filtro> listaFiltros){
        return new ContenedorIdListaFiltros(id,listaFiltros);
    }

    static public Entity contenedorIdListaVideos(Integer id, ArrayList<Video> listaVideos){
        return new ContenedorIdListaVideos(id,listaVideos);
    }
    //endregion
}

