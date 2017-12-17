package edu.ucab.desarrollo.viucab.webService.M05_ListaDeReproduccion;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.ListaDeReproduccion;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/playlist")
public class M05_ListaDeReproduccion {

    Gson gson = new Gson();

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/playlist")
    @Produces("application/json")
    /**
     * Devuelve el listado de los videos mas reproducidos
     */
    public String obtenerMasVistos ()
    {

        String query =  "SELECT * " +
                "FROM VIDEO " +
                "ORDER BY VIDEO.VID_VISITAS DESC";
        try {

            //Lista del objeto video para almacenar todos los videos a cargar
            ArrayList<Video> listaVideos= new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Video resultado = new Video();
                resultado.setId(rs.getInt("vid_id"));
                resultado.setNombre(rs.getString("vid_titulo"));
                resultado.setDescripcion(rs.getString("vid_descripcion"));
                resultado.setImagen(rs.getString("vid_imagen"));
                resultado.setFecha(rs.getString("vid_fecha"));
                resultado.setVisitas(rs.getInt("vid_visitas"));

                listaVideos.add(resultado);

            }
            return gson.toJson(listaVideos);
        }
        catch(SQLException e) {
            return e.getMessage();
        }
        finally {
            Sql.bdClose(conn);
        }


    }



}