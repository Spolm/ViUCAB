package edu.ucab.desarrollo.viucab.domainLogicLayer;

import edu.ucab.desarrollo.viucab.common.entities.Entity;

import edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.GetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.GetUsuariosComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.SetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.UpdateSuscripcionComando;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasLikeComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.GetSugerenciasSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M04_Reproduccion.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M10_Notificaciones.*;


/**
 * Fabrica de comandos creada por M011
 */
public class CommandsFactory {

    //region M011

    public static Command instanciateEstadistica1 (Entity est){
        return new GetEstadistica1(est);
    }

    public static  Command instanciateEstadistica2 (Entity est){

        return  new GetEstadistica2(est);
    }

    public  static  Command instanciateEstadistica3 (Entity est){
        return new GetEstadistica3(est);
    }

    public  static  Command instanciateEstadistica4 (Entity est){
        return new GetEstadistica4(est);
    }

    public  static  Command instanciateEstadistica5 (Entity est){
        return new GetEstadistica5(est);
    }

    public  static  Command instanciateEstadistica6 (Entity est){
        return new GetEstadistica6(est);
    }

    public  static  Command instanciateEstadistica7 (Entity est){
        return new GetEstadistica7(est);
    }

    public  static  Command instanciateEstadistica8 (Entity est){
        return new GetEstadistica8(est);
    }

    public  static  Command instanciateEstadistica9 (Entity est){
        return new GetEstadistica9(est);
    }

    //endregion

    //M02 Instancias

    public  static  Command instanciateGetBusquedaComando     (Entity est) {return  new GetBusquedaComando(est);}

    //Mas Vistos no recibe Parametros
    public  static  Command instanciateGetMasVistosComando    () {return  new GetMasVistosComando();}

    public  static  Command instanciateGetPreferenciasComando (Entity est) {return  new GetPreferenciasComando(est);}

    public  static  Command instanciateGetSuscritosComando    (Entity est) {return  new GetSuscritosComando(est);}

    // Fin instancias M02

    //M03 Video

    public static Command intantiateAddVideoCommand (Entity e){return new AddVideoCommand(e);}

    public static Command intantiateUpdateVideoCommand (Entity e){return new UpdateVideoCommand(e);}

    public static Command intantiateGetAllVideoByIdCommand(int userID) {
        return new GetAllVideoByIdCommand(userID);
    }

    public static Command intantiateGetVideoCommand(int videoId) {
        return new GetVideoCommand(videoId);
    }

    public static Command intantiateDeleteVideoCommand(int videoId) {
        return new DeleteVideoCommand(videoId);
    }

    //Fin M03

    //region M05

    public static Command instanciaGetLista (Entity lista){
        return new GetListaComando(lista);
    }

    public static Command instanciaGetEspecificList (Entity lista){
        return new GetEspecificListComando(lista);
    }

    public static Command instanciaAddListComando (Entity lista){
        return new AddListComando(lista);
    }

    public static Command instanciaModifyListComando (Entity lista){
        return new ModifyListComando(lista);
    }

    public static Command instanciaDeleteListComando (Entity lista){
        return new DeleteListComando(lista);
    }

    public static Command instanciaAddVideoToListComando (Entity lista){
        return new AddVideoToListComando(lista);
    }

    public static Command instanciaDeleteVideoToListComando (Entity lista){
        return new DeleteVideoToListComando(lista);
    }

    public static Command instanciaGetVideosFromList (Entity lista){
        return new GetVideosFromListComando(lista);
    }

    //endregion

    //region M07
    public static Command instanciateInsertEtiqueta(Entity etiqueta){
        return new InsertarEtiqueta(etiqueta);
    }

    public static Command instanciateEliminarEtiqueta(Entity etiqueta){
        return new EliminarEtiqueta(etiqueta);
    }

    public static Command instanciateConsultarVideos(Entity etiqueta){
        return new ConsultarVideos(etiqueta);
    }
    //endregion

    //M08 Instancias

     public  static  Command instanciaGetSuscripcionComando(int idsuscriptor) {return  new GetSuscripcionComando(idsuscriptor);}

     public  static  Command instanciaSetSuscripcionComando(int idsuscriptor,int idsuscripcion) {return  new SetSuscripcionComando(idsuscriptor,idsuscripcion);}

     public  static  Command instanciaUpdateSuscripcionComando(int idsuscriptor,int idsuscripcion) {return  new UpdateSuscripcionComando(idsuscriptor,idsuscripcion);}

     public static Command instanciaGetUsuariosComando () {return  new GetUsuariosComando();}
    //Fin instancias M08
     
     
     // M04
     
     public static Command instanciarComandoGetVideoInfo(int idvideo) {
         return new ComandoGetVideoInfo(idvideo);
     }
     
     public static Command instanciarComandoGetVideosRelacionados(int idvideo) {
         return new ComandoGetVideosRelacionados(idvideo);
     }
     
     public static Command instanciarComandoGetComentarios(int idvideo) {
         return new ComandoGetComentarios(idvideo);
     }
     
     public static Command instanciarComandoGetVideoYCanal(int idvideo) {
         return new ComandoGetVideoYCanal(idvideo);
     }
     
     public static Command instanciarComandoAddVisita(int idvideo) {
         return new ComandoAddVisita(idvideo);
     }
     
     public static Command instanciarComandoAgregarComentario(int idvideo,String usuario, String comentario) {
         return new ComandoAgregarComentario(idvideo,usuario,comentario);
     }
        
     public static Command instanciarComandoUpdateLike(int idvideo,String usuario) {
         return new ComandoUpdateLike(idvideo,usuario);
     }
        
     public static Command instanciarComandoGetIfLike(int idvideo,String usuario) {
         return new ComandoGetIfLike(idvideo,usuario);
     }
        
     public static Command instanciarComandoDeleteComentario(int idcom) {
         return new ComandoDeleteComentario(idcom);
     }
     
     // Fin M04

    //regin M09

    public static Command instaciateSugerenciasLike (Entity video) {return new GetSugerenciasLikeComando(video);}

    public static Command instaciateSugerenciasSuscripcion (Entity video) {return new GetSugerenciasSuscripcionComando(video);}

    //fin M09

    // M10
    public static Command instanciateGetNotificaciones ( Entity notificacion) {
        return new GetNotificaciones(notificacion);
    }
}
