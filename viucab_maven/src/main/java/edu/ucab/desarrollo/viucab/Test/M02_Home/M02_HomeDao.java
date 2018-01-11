package M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home.GetHomeDao;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class M02_HomeDao {

   /* @Test
    void getMasVistosComando() throws SQLException, VIUCABException, PLConnectException1, BDConnectException1 {

        GetHomeDao dao = DaoFactory.instanciateGetMasVistosComando();
        ArrayList<Video> video = dao.GetMasVistosComando();
        assertNotNull(video);

    }

    @Test
    void getPreferenciasComando() {

        GetHomeDao dao = DaoFactory.instanciateGetPreferenciasComando();
        ArrayList<Video> video = dao.GetPreferenciasComando(1);
        assertNotNull(video);

    }

    @Test
    void getSuscritosComando() {

        GetHomeDao dao = DaoFactory.instanciateGetMasVistosComando();
        ArrayList<Video> video = dao.GetMasVistosComando();
        assertNotNull(video);

    }

    @Test
    void getBusquedaComando() {

        GetHomeDao dao = DaoFactory.instanciateGetMasVistosComando();
        ArrayList<Video> video = dao.GetMasVistosComando();
        assertNotNull(video);

    }*/
}