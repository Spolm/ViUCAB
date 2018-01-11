package edu.ucab.desarrollo.viucab.domainLogicLayer.M12_ModeracionContenido;


import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Filtro;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M12_ModeracionContenido.GetModeracionContenidoDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.util.ArrayList;

/**
 * Created by jose on 08/11/2017.
 */
public class GetFiltrosDeUsuarioComando extends Command {

    Integer id;
    Entity est;
    ArrayList<Filtro> _resultado;

    public GetFiltrosDeUsuarioComando(Integer id) {
        this.id=id;
    }

    public ArrayList<Filtro> getFiltros()
    {
        return _resultado;
    }

    @Override
    public void execute() {
        try {
            GetModeracionContenidoDao dao =  DaoFactory.instanciarModeracionContenidoDao();
            ArrayList<Filtro> listaFiltros = dao.buscarFiltros(id);

            _resultado=listaFiltros;

        }
        catch (Exception e){

        }

    }
    @Override
    public Entity Return() {
        return est;
    }

}
