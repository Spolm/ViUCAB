package edu.ucab.desarrollo.viucab.dataAccessLayer.M12_ModeracionContenido;

import edu.ucab.desarrollo.viucab.common.entities.*;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by jose on 08/01/2018.
 */
public class GetModeracionContenidoDao extends Dao implements IDaoModeracionContenido {

    public GetModeracionContenidoDao(){

    }

    @Override
    public Entity create(Entity e) {
        return null;
    }

    @Override
    public Entity read(Entity e) {
        return null;
    }

    @Override
    public Entity update(Entity e) {
        return null;
    }

    /**
     * Metodo que busca los filtros de un id de usuario
     * @return resultlist
     * @throws SQLException
     */

    public ArrayList<Filtro> buscarFiltros(Integer id) throws SQLException {

        ArrayList<Filtro> listaFiltros= new ArrayList<>();
        Connection conn= getConInstance();
        Filtro resultado;

            try{
                String query = "SELECT * FROM FILTRO, USU_FIL WHERE FILTRO.FIL_ID=USU_FIL.ID_FIL AND USU_FIL.ID_USU="+id;
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                   

                   int fil_id = rs.getInt("fil_id");
                   String fil_tipo = rs.getString("fil_tipo");
                   String fil_descripcion = rs.getString("fil_descripcion");
                   
                   resultado = (Filtro) EntityFactory.filtro(fil_id,fil_tipo,fil_descripcion);
                   listaFiltros.add(resultado);
                }
                rs.close();

            } catch(SQLException e) {
                e.printStackTrace();
            }
            finally {
                closeConnection();
            }

        return listaFiltros;
    }

}
