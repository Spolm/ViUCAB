package edu.ucab.desarrollo.viucab.webService.M11_Estadistica;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M011.GetEstadisticaDao;
import org.junit.jupiter.api.Test;


import static junit.framework.TestCase.assertNotNull;


/**
 * Created by Daniel on 26/12/2017.
 */
class DaoFactoryTest {

    private static Entity est;

    @Test
    void instanciateDaoEstadistica1() {

        GetEstadisticaDao dao =  DaoFactory.instanciateDaoEstadistica1();
        Entity estadistica = null;
        try {
            estadistica = dao.GetEstadistica1(est);
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        est = estadistica;
        assertNotNull(est);
    }

}