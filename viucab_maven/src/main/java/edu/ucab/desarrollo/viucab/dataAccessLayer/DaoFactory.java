package edu.ucab.desarrollo.viucab.dataAccessLayer;

import edu.ucab.desarrollo.viucab.dataAccessLayer.M011.GetEstadisticaDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home.GetHomeDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.DaoVideoEntity;
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
    static  public GetHomeDao instanciateGetHome(){
        return new GetHomeDao();
    }
    //endregion

    //M03 Video
    static public DaoVideoEntity instantiateDaoVideoEntity(){ return new DaoVideoEntity();}
    //Fin M03 Video

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
}

