package edu.ucab.desarrollo.viucab.webService.M02_Home;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetBusquedaComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetMasVistosComando;
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
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by estefania on 14/12/2017.
 */
@Path("/HomePatrones")
public class M02_HomePatrones {

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
            try {

                Command commandVideoMasVisto = CommandsFactory.instanciateGetMasVistosComando();
                GetMasVistosComando cmd = (GetMasVistosComando) commandVideoMasVisto;
                cmd.execute();
                ArrayList<Video> result =cmd.get_listVideo();
                //LinkedList<Entity> result = cmd.get_listVideo();
                //LinkedList <Video> pruebaCast = (LinkedList<Video>) result;
                return gson.toJson(result);
            }
            catch (Exception e){

            }
            return null;
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




        return null;


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
            Command commandVideoBusqueda = CommandsFactory.instanciateGetBusquedaComando(parametroBusqueda);
            GetBusquedaComando cmd = (GetBusquedaComando) commandVideoBusqueda;
            cmd.execute();
            ArrayList<Video> result = cmd.get_listVideo();


            return gson.toJson(result);


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
