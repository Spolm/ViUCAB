package edu.ucab.desarrollo.viucab.domainLogicLayer;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
<<<<<<< HEAD
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.*;
=======

import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.GetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.SetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.UpdateSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.*;
>>>>>>> Develop

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

<<<<<<< HEAD
=======
    //M02 Instancias

    public  static  Command instanciateGetBusquedaComando     (String criterio) {return  new GetBusquedaComando(criterio);}

    //Mas Vistos no recibe Parametros
    public  static  Command instanciateGetMasVistosComando    () {return  new GetMasVistosComando();}

    public  static  Command instanciateGetPreferenciasComando (int idUsuario) {return  new GetPreferenciasComando(idUsuario);}

    public  static  Command instanciateGetSuscritosComando    (int idUsuario) {return  new GetSuscritosComando(idUsuario);}

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
>>>>>>> Develop
}
