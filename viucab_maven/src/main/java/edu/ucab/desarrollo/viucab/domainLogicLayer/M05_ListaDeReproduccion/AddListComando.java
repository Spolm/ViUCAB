package edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.PlConnectException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M05_ListaDeReproduccion.GetListaDeReproduccionDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class AddListComando extends Command {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(AddListComando.class);
    private static Entity est;
    private Boolean resultado;



    public AddListComando(Entity est)
    {
        this.est = est;
    }


    public AddListComando(Boolean result) {
        this.resultado = result;
    }

    public Boolean getResultado()
    {
        return resultado;
    }


    @Override
    public void execute() throws BdConnectException, PlConnectException {


        try {
            GetListaDeReproduccionDao dao =  DaoFactory.instanciateDaoListaDeReproduccion();
            //ArrayList<Entity> listas = dao.GetLista(est);
            //_resultado = listas;
            resultado = dao.createLista(est);

        }
        catch (Exception e){
            est = new Entity();
            resultado = false; //si no devuelve nada, devuelve falso

        }


    }


    @Override
    public Entity Return() {
        return est;
    }


}
