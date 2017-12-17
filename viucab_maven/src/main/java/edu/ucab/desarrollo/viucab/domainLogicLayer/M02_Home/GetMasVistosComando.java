package edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;

import edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home.GetHomeDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import org.slf4j.LoggerFactory;

import java.util.LinkedList;

/**
 * Created by estefania on 29/11/2017.
 */
public class GetMasVistosComando extends Command {
    //Se declara un arraylist para obtener el resultado
   LinkedList<Entity> _resultado=null;

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(GetMasVistosComando.class);

    public GetMasVistosComando(LinkedList<Entity> resultado) {
        this._resultado = resultado;
    }
    public GetMasVistosComando() {
        _resultado=get_listVideo();
    }

    public LinkedList<Entity> get_listVideo()
    {
        return _resultado;
    }

    @Override
    public void execute() {
        try {
            GetHomeDao dao =  DaoFactory.instanciateGetMasVistosComando();
            LinkedList<Entity> video = dao.GetMasVistosComando();

            //Guardamos lo que devuelve el DAO
            _resultado=video;

        }
        catch (Exception e){

        }

    }

    @Override
    public Entity Return() {
        return null;
    }
}
