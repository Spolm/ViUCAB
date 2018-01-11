package edu.ucab.desarrollo.viucab.domainLogicLayer.M12_ModeracionContenido;

import edu.ucab.desarrollo.viucab.common.entities.ContenedorIdListaFiltros;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Filtro;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M12_ModeracionContenido.GetModeracionContenidoDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.util.ArrayList;

/**
 * Created by jose on 08/11/2017.
 */
public class GuardarFiltrosComando extends Command {

    Integer id;
    ArrayList<Filtro> listaFiltros;
    Entity est;
    String _resultado;


    public GuardarFiltrosComando(ContenedorIdListaFiltros contenedor) {
        this.id=contenedor.getId();
        this.listaFiltros=contenedor.getListaFiltros();
    }

    /**
     * Devuelve un String si hubo o o insercion en la base de datos
     * @return true o false
     */
    public  String getResultadoGuardado()
    {
        return _resultado;
    }


    /**
     * Metodo que realiza la llamada a el patron DAO en la clase GetModeracionContenidoDao
     * para almacenar los datos obtenidos en la fabrica
     */
    @Override
    public void execute() {
        try {
            GetModeracionContenidoDao dao =  DaoFactory.instanciarModeracionContenidoDao();
            _resultado = dao.guardarFiltrosEnBD(id, listaFiltros);

        }
        catch (Exception e){

        }

    }
    @Override
    public Entity Return() {
        return est;
    }

}
