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

    static public Video homeUsuario ()
    {
        return new Video();
    }
    static public Video homeUsuario (ArrayList<Video> listaVideos)
    {
        return new Video(listaVideos);
    }

    static public Video homeUsuario( int id, String titulo, String descripcion,
                                     String imagen,String url, String fecha,int visitas){
        return new Video(id,titulo,descripcion,imagen,fecha,visitas,url);
    }
    //final M02

}
