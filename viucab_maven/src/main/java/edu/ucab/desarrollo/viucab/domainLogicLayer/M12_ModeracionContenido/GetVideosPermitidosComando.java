package edu.ucab.desarrollo.viucab.domainLogicLayer.M12_ModeracionContenido;


import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M12_ModeracionContenido.GetModeracionContenidoDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.util.ArrayList;

/**
 * Created by jose on 08/11/2017.
 */
public class GetVideosPermitidosComando extends Command {

    Integer id;
    Entity est;
    ArrayList<Video> _resultado;

    public GetVideosPermitidosComando(Integer id) {
        this.id=id;
    }

    /**
     * Obtiene el resultado de la busqueda de los videos de permitidos, que estan almacenados en _resultado
     * @return lista de videos
     */
    public ArrayList<Video> getVideosPermitidos()
    {
        return _resultado;
    }

    /**
     * Metodo que realiza la llamada a el patron DAO en la clase GetModeracionContenidoDao
     * para almacenar los datos obtenidos en la fabrica, en la variable _resultado.
     */
    @Override
    public void execute() {
        try {
            GetModeracionContenidoDao dao =  DaoFactory.instanciarModeracionContenidoDao();
            _resultado= dao.buscarVideosPermitidos(id);

        }
        catch (Exception e){

        }

    }
    @Override
    public Entity Return() {
        return est;
    }

}
