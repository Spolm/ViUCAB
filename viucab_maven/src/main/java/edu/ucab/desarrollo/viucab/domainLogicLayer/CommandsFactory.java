package edu.ucab.desarrollo.viucab.domainLogicLayer;

import edu.ucab.desarrollo.viucab.common.entities.Entity;

import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.GetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.SetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.UpdateSuscripcionComando;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M04_Reproduccion.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.*;

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

    public  static  Command instanciateGetBusquedaComando     (String criterio) {return  new GetBusquedaComando();}

    //Mas Vistos no recibe Parametros
    public  static  Command instanciateGetMasVistosComando    () {return  new GetMasVistosComando();}

    public  static  Command instanciateGetPreferenciasComando (Entity est) {return  new GetPreferenciasComando(est);}

    public  static  Command instanciateGetSuscritosComando    (Entity est) {return  new GetSuscritosComando(est);}

    // Fin instancias M02

    //region M05

    public static Command instanciaGetLista (Entity lista){
        return new GetListaComando(lista);
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
}
