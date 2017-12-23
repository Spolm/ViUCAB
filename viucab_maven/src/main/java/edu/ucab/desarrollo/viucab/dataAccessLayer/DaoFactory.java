package edu.ucab.desarrollo.viucab.dataAccessLayer;

<<<<<<< HEAD
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M011.*;
=======
import edu.ucab.desarrollo.viucab.dataAccessLayer.M011.GetEstadisticaDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home.GetHomeDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M07_Etiquetas.GetEtiquetasDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M08.SuscripcionDao;
>>>>>>> Develop

/**
 * Fabrica para instanciar los DAO creada por M011
 */

public class DaoFactory
{

    //region M011

<<<<<<< HEAD
    static public Dao instanciateDaoEstadistica1(Entity est){
        return new GetEstadisticaDao1(est);
    }
    static public Dao instanciateDaoEstadistica2(Entity est){
        return new GetEstadisticaDao2(est);
    }
    static public Dao instanciateDaoEstadistica3(Entity est){
        return new GetEstadisticaDao3(est);
    }
    static public Dao instanciateDaoEstadistica4(Entity est){
        return new GetEstadisticaDao4(est);
    }
    static public Dao instanciateDaoEstadistica5(Entity est){
        return new GetEstadisticaDao5(est);
    }
    static public Dao instanciateDaoEstadistica6(Entity est){
        return new GetEstadisticaDao6(est);
    }
    static public Dao instanciateDaoEstadistica7(Entity est){
        return new GetEstadisticaDao7(est);
    }
    static public Dao instanciateDaoEstadistica8(Entity est){
        return new GetEstadisticaDao8(est);
    }
    static public Dao instanciateDaoEstadistica9(Entity est){
        return new GetEstadisticaDao9(est);
    }

    //endregion


=======
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
>>>>>>> Develop
}

