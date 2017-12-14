package edu.ucab.desarrollo.viucab.dataAccessLayer;

import edu.ucab.desarrollo.viucab.dataAccessLayer.M011.GetEstadisticaDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home.GetHomeDao;

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

}

