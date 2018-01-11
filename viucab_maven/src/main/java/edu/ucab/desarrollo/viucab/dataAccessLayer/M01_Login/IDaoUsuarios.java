package edu.ucab.desarrollo.viucab.dataAccessLayer.M01_Login;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Etiquetas;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public interface IDaoUsuarios {
    Boolean addUsuario(Entity e) throws SQLException, BDConnectException1, PLConnectException1;
    ArrayList<Entity> verusuario(Entity e) throws SQLException;
    Entity GetusuarioEspecifico(Entity e) throws SQLException, BDConnectException1, PLConnectException1;


}
