package edu.ucab.desarrollo.viucab.dataAccessLayer.M12_ModeracionContenido;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Filtro;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by estefania on 13/12/2017.
 */
public interface IDaoModeracionContenido extends IDao {

    public ArrayList<Filtro> buscarFiltros(Integer id) throws SQLException;

}
