package edu.ucab.desarrollo.viucab.webService.M02_Home;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.common.exceptions.ListAllException;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetBusquedaComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetMasVistosComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetPreferenciasComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M02_Home.GetSuscritosComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by estefania on 14/12/2017.
 */
@Path("/Home")
public class M02_Home {
        private static Logger logger = LoggerFactory.getLogger( M02_Home.class );

        Gson gson = new Gson();
        Connection conn= Sql.getConInstance();

        /**
         * @Param id
         * Devuelve todos los Videos en funcion de las preferencias dado un id de Usuario
         */
        @GET
        @CrossOrigin(origins = "http://localhost:8100")
        @Path("/ObtenerPreferencias")
        @Produces("application/json")

        public String obtenerPreferencia (@QueryParam("id")  int idUsuario) {

            Entity videoObject = EntityFactory.homeVideo(idUsuario);
            Command commadHome = CommandsFactory.instanciateGetPreferenciasComando(videoObject);
            GetPreferenciasComando cmd = (GetPreferenciasComando) commadHome;
            try{
                cmd.execute();
                return gson.toJson(cmd.get_listVideo());
            }
            catch (VIUCABException e){
                videoObject.set_errorCode( e.ERROR_CODE );
                videoObject.set_errorMsg( e.ERROR_MSG );
                logger.error( "Metodo: {} {}", "obtenerPreferencia", e.toString() );
                return gson.toJson( videoObject );
            }
            catch (Exception e){
               e.printStackTrace();
            }

            return null;
        }

        /**
         * Devuelve el listado de los videos mas reproducidos
         */
        @GET
        @CrossOrigin(origins = "http://localhost:8100")
        @Path("/MasVistos")
        @Produces("application/json")

        public String obtenerMasVistos ()
        {
            Command commandVideoMasVisto = CommandsFactory.instanciateGetMasVistosComando();
            GetMasVistosComando cmd = (GetMasVistosComando) commandVideoMasVisto;
            Entity videoObject =null;
            String response = null;
            ArrayList <Video> result=null;
            try {


                cmd.execute();
                result = cmd.get_listVideo();
                response = gson.toJson(videoObject);
                return gson.toJson(result);
            }
            catch (VIUCABException e){
                videoObject.set_errorCode( e.ERROR_CODE );
                videoObject.set_errorMsg( e.ERROR_MSG );
                logger.error( "Metodo: {} {}", "obtenerMasVistos", e.toString() );
                return gson.toJson( videoObject );
            }

            catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        /**
         * Obtiene los ultimos videos subidos por los canales a los cuales
         * esta suscrito el usuario
         *@Param id del Usuario suscrito
         */
        @GET
        @CrossOrigin(origins = "http://localhost:8100")
        @Path("/Suscritos")
        @Produces("application/json")
        public String obtenerVideosSuscritos (@QueryParam("id") int idUser)
        {
            Entity videoObject = EntityFactory.homeVideo(idUser);
            Command commadHome = CommandsFactory.instanciateGetSuscritosComando (videoObject);
            GetSuscritosComando cmd = (GetSuscritosComando) commadHome;
            try {
                cmd.execute();
                return gson.toJson(cmd.get_listVideo());
            }
            catch(VIUCABException e){
                videoObject.set_errorCode( e.ERROR_CODE );
                videoObject.set_errorMsg( e.ERROR_MSG );
                logger.error( "Metodo: {} {}", "obtenerVideosSuscritos", e.toString() );
                return gson.toJson( videoObject );
            }
            catch (Exception ex) {
                return gson.toJson( null );
            }
        }

        /**
         * Realiza Busquedas por titulo,genero y etiquetas
         * @param parametroBusqueda
         * @return listaDeVideos
         */
        @GET
        @CrossOrigin(origins = "http://localhost:8100")
        @Path("/Busqueda")
        @Produces("application/json")
        public String busquedaVideos (@QueryParam("parametroBusqueda")  String parametroBusqueda)
        {
            Entity videoObject = EntityFactory.homeVideo(parametroBusqueda);
            Command commadHome = CommandsFactory.instanciateGetBusquedaComando(videoObject);
            GetBusquedaComando cmd = (GetBusquedaComando) commadHome;
            try {
                cmd.execute();
                return gson.toJson(cmd.get_listVideo());
            }
             catch(VIUCABException e){
                    videoObject.set_errorCode( e.ERROR_CODE );
                    videoObject.set_errorMsg( e.ERROR_MSG );
                    logger.error( "Metodo: {} {}", "obtenerVideosSuscritos", e.toString() );
                    return gson.toJson( videoObject );
                }
            catch (Exception ex) {
                    return gson.toJson( null );
                }


        }

    /**
     * Obtiene los ultimos videos subidos por los canales a los cuales
     * esta suscrito el usuario
     *@Param id del Usuario suscrito
     */
    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/Inicio")
    @Produces("application/json")
    public String obtenerVideosInicio (@QueryParam("id") int idUser)
    {
        Entity videoObject = EntityFactory.homeVideo(idUser);
        Command commadHome = CommandsFactory.instanciateGetSuscritosComando (videoObject);
        Command commandVideoMasVisto = CommandsFactory.instanciateGetMasVistosComando();
        GetSuscritosComando cmd = (GetSuscritosComando) commadHome;
        GetMasVistosComando cmd_ = (GetMasVistosComando) commandVideoMasVisto;
        ArrayList <Video> result = new ArrayList <Video>();
        try {
            cmd.execute();
            cmd_.execute();
            ArrayList <Video> Suscritos = cmd.get_listVideo();
            ArrayList <Video> Tendencia = cmd_.get_listVideo();
            for (Video video : Suscritos) {
                result.add(video);
            }
            for (Video video : Tendencia) {
                result.add(video);
            }
            return gson.toJson(result);
        }
        catch(VIUCABException e){
            videoObject.set_errorCode( e.ERROR_CODE );
            videoObject.set_errorMsg( e.ERROR_MSG );
            logger.error( "Metodo: {} {}", "obtenerVideosInicio", e.toString() );
            return gson.toJson( videoObject );
        }
        catch (Exception ex) {
            return gson.toJson( null );
        }
    }

}
