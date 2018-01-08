package edu.ucab.desarrollo.viucab.webService.M02_Home;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetBusquedaComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetMasVistosComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetPreferenciasComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetSuscritosComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.sql.Connection;
import java.util.ArrayList;

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

            Entity videoObject = EntityFactory.homeVideo(idUsuario);
            Command commadHome = CommandsFactory.instanciateGetPreferenciasComando(videoObject);
            GetPreferenciasComando cmd = (GetPreferenciasComando) commadHome;
            try {
                cmd.execute();
                return gson.toJson(cmd.get_listVideo());
            } catch (Exception ex) {
                return gson.toJson( null );//nuevo
            }
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
            Entity videoObject = EntityFactory.homeVideo(idUser);
            Command commadHome = CommandsFactory.instanciateGetSuscritosComando (videoObject);
            GetSuscritosComando cmd = (GetSuscritosComando) commadHome;
            try {
                cmd.execute();
                return gson.toJson(cmd.get_listVideo());
            } catch (Exception ex) {
                return gson.toJson( null );
            }
        }

        @GET
        @CrossOrigin(origins = "http://localhost:8100")
        @Path("/Busqueda")
        @Produces("application/json")
        /**
         * Realiza Busquedas por titulo,genero y etiquetas
         * @param parametroBusqueda
         * @return listaDeVideos
         */
        public String busquedaVideos (@QueryParam("parametroBusqueda")  String parametroBusqueda)
        {
            Entity videoObject = EntityFactory.homeVideo(parametroBusqueda);
            Command commadHome = CommandsFactory.instanciateGetBusquedaComando(videoObject);
            GetBusquedaComando cmd = (GetBusquedaComando) commadHome;
            try {
                cmd.execute();
                return gson.toJson(cmd.get_listVideo());
            } catch (Exception ex) {
                return gson.toJson( null );
            }


        }

}
