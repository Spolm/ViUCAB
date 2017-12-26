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
class GetEstadisticaDaoTest {
    private static Entity est;
    @Test
    void getEstadistica1() {

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

    @Test
    void getEstadistica2() {

        GetEstadisticaDao dao =  DaoFactory.instanciateDaoEstadistica1();
        Entity estadistica = null;
        try {
            estadistica = dao.GetEstadistica2(est);
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        est = estadistica;
        assertNotNull(est);
    }

    @Test
    void getEstadistica3() {

        GetEstadisticaDao dao =  DaoFactory.instanciateDaoEstadistica1();
        Entity estadistica = null;
        try {
            estadistica = dao.GetEstadistica3(est);
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        est = estadistica;
        assertNotNull(est);
    }

    @Test
    void getEstadistica4() {
        GetEstadisticaDao dao =  DaoFactory.instanciateDaoEstadistica1();
        Entity estadistica = null;
        try {
            estadistica = dao.GetEstadistica4(est);
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        est = estadistica;
        assertNotNull(est);
    }

    @Test
    void getEstadistica5() {
        GetEstadisticaDao dao =  DaoFactory.instanciateDaoEstadistica1();
        Entity estadistica = null;
        try {
            estadistica = dao.GetEstadistica5(est);
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        est = estadistica;
        assertNotNull(est);
    }

    @Test
    void getEstadistica6() {
        GetEstadisticaDao dao =  DaoFactory.instanciateDaoEstadistica1();
        Entity estadistica = null;
        try {
            estadistica = dao.GetEstadistica6(est);
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        est = estadistica;
        assertNotNull(est);
    }

    @Test
    void getEstadistica7() {
        GetEstadisticaDao dao =  DaoFactory.instanciateDaoEstadistica1();
        Entity estadistica = null;
        try {
            estadistica = dao.GetEstadistica7(est);
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        est = estadistica;
        assertNotNull(est);
    }

    @Test
    void getEstadistica8() {
        GetEstadisticaDao dao =  DaoFactory.instanciateDaoEstadistica1();
        Entity estadistica = null;
        try {
            estadistica = dao.GetEstadistica8(est);
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        est = estadistica;
        assertNotNull(est);
    }

    @Test
    void getEstadistica9() {
        GetEstadisticaDao dao =  DaoFactory.instanciateDaoEstadistica1();
        Entity estadistica = null;
        try {
            estadistica = dao.GetEstadistica9(est);
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        est = estadistica;
        assertNotNull(est);
    }

}