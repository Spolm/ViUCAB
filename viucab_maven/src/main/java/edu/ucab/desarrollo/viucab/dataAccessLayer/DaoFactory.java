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
        return new GetEstadisticaDao(est);
    }

    //endregion


}

