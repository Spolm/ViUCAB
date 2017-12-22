package edu.ucab.desarrollo.viucab.dataAccessLayer;

import edu.ucab.desarrollo.viucab.dataAccessLayer.M011.GetEstadisticaDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home.GetHomeDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;

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

    //region M05

    static public GetListaDeReproduccionDao instanciateDaoListaDeReproduccion(){
        return new GetListaDeReproduccionDao();
    }

    //endregion
}

