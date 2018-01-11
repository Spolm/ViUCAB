package edu.ucab.desarrollo.viucab.dataAccessLayer;

import edu.ucab.desarrollo.viucab.dataAccessLayer.M011.GetEstadisticaDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M01_Login.GetUsuarioDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home.GetHomeDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M04_Reproductor.VideoDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M07_Etiquetas.GetEtiquetasDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M08.SuscripcionDao;

/**
 * Fabrica para instanciar los DAO creada por M011
 */

public class DaoFactory
{

    //region M011

    static public GetEstadisticaDao instanciateDaoEstadistica1(){
        return new GetEstadisticaDao();
    }


    //endregion

    //region M02
    static  public GetHomeDao instanciateGetBusquedaComando(){return new GetHomeDao();
    }
    static  public GetHomeDao instanciateGetMasVistosComando(){return new GetHomeDao();}

    static  public GetHomeDao instanciateGetPreferenciasComando(){return new GetHomeDao();}

    static  public GetHomeDao instanciateGetSuscritosComando(){return new GetHomeDao();}

    //endregion



    //region M05

    static public GetListaDeReproduccionDao instanciateDaoListaDeReproduccion(){
        return new GetListaDeReproduccionDao();
    }
    //region M08
    static  public SuscripcionDao instanciateSuscripcion(){
        return new SuscripcionDao();
    }
    
    //endregion M08

    //endregion

    //region M07
    static public GetEtiquetasDao instanciateDaoEtiquetas(){
        return new GetEtiquetasDao();
    }
    //endregion
    
    
    
    
    //M04 
    
    static public VideoDao instanciarVideoDao() {
        return new VideoDao();
    }
    
    // FIN M04
    //M01
    static public GetUsuarioDao instanciateDaoUsuario(){
        return new GetUsuarioDao();
    }
}

