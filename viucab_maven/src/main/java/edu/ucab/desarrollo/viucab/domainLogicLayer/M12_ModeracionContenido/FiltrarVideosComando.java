package edu.ucab.desarrollo.viucab.domainLogicLayer.M12_ModeracionContenido;

import edu.ucab.desarrollo.viucab.common.entities.ContenedorIdListaVideos;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M12_ModeracionContenido.GetModeracionContenidoDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.util.ArrayList;
/**
 * Created by Pablo, Jose and Karem on 07/01/2018.
 */
public class FiltrarVideosComando extends Command {

    Integer id;
    ArrayList<Video> listaVideos;
    Entity est;
    ArrayList<Video> _resultado;

    public FiltrarVideosComando(ContenedorIdListaVideos contenedor) {
        this.id=contenedor.getId();
        this.listaVideos=contenedor.getListaVideos();
    }

    /**
     * Obtiene resultado de videos filtrados, guardado en la variable _resultado
     * @return Lista de videos
     */
    public  ArrayList<Video> getVideosFiltrados()
    {
        return _resultado;
    }


    /**
     * Metodo que realiza la llamada a el patron DAO en la clase GetModeracionContenidoDa
     * para consultar en base de datos y filtrar los videos obtenidos en la fabrica,
     * posteriormente los almacena en el variable _resultado.
     */
    @Override
    public void execute() {
        try {
            GetModeracionContenidoDao dao =  DaoFactory.instanciarModeracionContenidoDao();
            _resultado = dao.buscarYFiltrarVideos(id, listaVideos);

        }
        catch (Exception e){

        }
    }
    @Override
    public Entity Return() {
        return est;
    }

}
