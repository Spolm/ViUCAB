package edu.ucab.desarrollo.viucab.dataAccessLayer.M09_Sugerencias;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.MessageException;
import edu.ucab.desarrollo.viucab.common.exceptions.ParameterNullException;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoSugerencias extends IDao {

    ArrayList<Entity> sugerenciasLike(Entity e) throws VIUCABException, SQLException, MessageException, ParameterNullException;
    ArrayList<Entity> sugerenciasSuscripcion(Entity e) throws  VIUCABException, SQLException, MessageException, ParameterNullException;

}
