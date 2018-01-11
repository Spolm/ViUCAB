package edu.ucab.desarrollo.viucab.dataAccessLayer.M09_Sugerencias;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.util.ArrayList;

public interface IDaoSugerencias extends IDao {

    ArrayList<Entity> sugerenciasLike(Entity e);
    ArrayList<Entity> sugerenciasSuscripcion(Entity e);

}
