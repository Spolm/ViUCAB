package edu.ucab.desarrollo.viucab.dataAccessLayer;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M011.*;

/**
 * Fabrica para instanciar los DAO creada por M011
 */

public class DaoFactory
{

    //region M011

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


}

