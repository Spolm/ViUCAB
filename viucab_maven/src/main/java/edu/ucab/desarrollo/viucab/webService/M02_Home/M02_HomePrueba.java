package edu.ucab.desarrollo.viucab.webService.M02_Home;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetPreferenciasComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by estefania on 14/12/2017.
 */
@Path("/Home")
public class M02_HomePrueba {

        Gson gson = new Gson();
        Connection conn= Sql.getConInstance();

        @GET
        @CrossOrigin(origins = "http://localhost:8100")
        @Path("/ObtenerPreferencias")
        @Produces("application/json")
        /**
         * @Param id
         * Devuelve todos los Videos en funcion de las preferencias dado un id
         */
        public String obtenerPreferencia (@QueryParam("id")  int idUsuario){

            Entity videoObject = EntityFactory.homeUsuario(idUsuario);
         /*   Command commadHome = CommandsFactory.instanciateGetPreferenciasComando(videoObject);
            GetPreferenciasComando cmd = (GetPreferenciasComando) commadHome;
            cmd.execute();
            Entity result = cmd.Return();
            ArrayList<Video> json = (ArrayListVideo) result;
            return gson.toJson(json);*/
          return null;
        }

        @GET
        @CrossOrigin(origins = "http://localhost:8100")
        @Path("/MasVistos")
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

        @GET
        @CrossOrigin(origins = "http://localhost:8100")
        @Path("/Suscritos")
        @Produces("application/json")
        /**
         * Obtiene los ultimos videos subidos por los canales a los cuales
         * esta suscrito el usuario
         *@Param id del Usuario suscrito
         */
        public String obtenerVideosSuscritos (@QueryParam("id") int idUser)
        {

            String query =  "SELECT DISTINCT video.* " +
                    "FROM video,usuario,suscripcion " +
                    "WHERE video.vid_usuario=suscripcion.id_suscripcion " +
                    "AND suscripcion.id_suscriptor='"+idUser+"'" +
                    "ORDER BY video.vid_fecha DESC ";


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

        @GET
        @CrossOrigin(origins = "http://localhost:8100")
        @Path("/Busqueda")
        @Produces("application/json")
        /**
         * Realiza Busquedas por titulo y por categoria (por ahora)
         * @param parametroBusqueda
         */
        public String busquedaVideos (@QueryParam("parametroBusqueda")  String parametroBusqueda)
        {
            //Consulta por:
            // 1._Titulo
            // 2._Categoria
            // 3._Etiqueta

            String query  = "SELECT  video.* " +
                    "FROM    video, categoria, video_cat " +
                    "WHERE   video.vid_titulo LIKE '%"+parametroBusqueda+"%'" +
                    "AND video.vid_id=video_cat.idvid " +
                    "AND categoria.cat_id=video_cat.idcat " +
                    "UNION " +
                    "SELECT  video.* " +
                    "FROM    video,categoria,video_cat " +
                    "WHERE   categoria.cat_valor LIKE '%"+parametroBusqueda+"%'  " +
                    "AND video.vid_id=video_cat.idvid " +
                    "AND categoria.cat_id=video_cat.idcat " +
                    "UNION " +
                    "SELECT  video.*" +
                    "FROM    video,etiqueta,video_etiq " +
                    "WHERE   etiqueta.eti_valor LIKE '%"+parametroBusqueda+"%' " +
                    "AND video.vid_id=video_etiq.idvid " +
                    "AND etiqueta.eti_id=video_etiq.idetiq";
            try{

                //Lista del objeto video para almacenar todos los videos a cargar
                ArrayList<Video> listaVideos= new ArrayList<>();
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();


                while (rs.next() ) {
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

            } catch(SQLException e) {
                return e.getMessage();
            }
            finally {
                Sql.bdClose(conn);
            }


        }

        /**
         * Metodo que dado un nombre de usuario devuelve
         * la id correspondiente
         * @param user
         * @return
         */

        public int obtenerUserId( String user){


            String query = "SELECT usu_id FROM  usuario WHERE ('"+user+"'=usu_login')";

            Usuario resultado = new Usuario();

            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){

                    resultado.set_id_user(rs.getInt("usu_id"));
                }

                return resultado.get_id_user();

            } catch (Exception e) {
                return 0;
            }
        }
}
