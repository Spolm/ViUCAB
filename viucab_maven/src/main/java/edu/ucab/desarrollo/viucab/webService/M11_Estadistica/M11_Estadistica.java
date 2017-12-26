package edu.ucab.desarrollo.viucab.webService.M11_Estadistica;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Estadistica;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@Path("/Estadistica")
public class M11_Estadistica {
    private static Logger logger = LoggerFactory.getLogger( M11_Estadistica.class );
    Gson gson = new Gson();
//a a recibir un int
    //Ver de Etiquetas más utilizadas


     /***
     * web service que es llamado a traves del fronten para Ver de Etiquetas más utilizadas
     * @param username
     * @return
     */
    @GET
    @Path("/Estadistica1")
    @Produces("text/plain")
    public String estadistica1(@QueryParam("username") String username)
    {



        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica1(estadisticaObject);
        GetEstadistica1 cmd = (GetEstadistica1) commandEstadistica;

        try {
            cmd.execute();
            Entity result = cmd.Return();
            Estadistica json = (Estadistica) result;
            return gson.toJson(json);

        } catch (VIUCABException e) {

            estadisticaObject.set_errorCode( e.ERROR_CODE );
            estadisticaObject.set_errorMsg( e.ERROR_MSG );
            logger.error( "Metodo: {} {}", "getTrainingDetail", e.toString() );
            return gson.toJson( estadisticaObject );



        }




    }

    /***
     * web service que es llamado a traves del fronten para la estadistica videos con más likes
     * @param username
     * @return
     */
    //Ver Estadísticas de videos con más likes
    @GET
    @Path("/Estadistica2")
    @Produces("text/plain")
    public String estadistica2(@QueryParam("username") String username)
    {
        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica2(estadisticaObject);
        GetEstadistica2 cmd = (GetEstadistica2) commandEstadistica;

        try {
            cmd.execute();
            Entity result = cmd.Return();
            Estadistica json = (Estadistica) result;
            return gson.toJson(json);

        } catch (VIUCABException e) {

            estadisticaObject.set_errorCode( e.ERROR_CODE );
            estadisticaObject.set_errorMsg( e.ERROR_MSG );
            logger.error( "Metodo: {} {}", "getTrainingDetail", e.toString() );
            return gson.toJson( estadisticaObject );



        }
    }


    /***
     * web service que es llamado a traves del fronten para la ver Estadísticas de videos  más visto
     * @param username
     * @return
     */
    @GET
    @Path("/Estadistica3")
    @Produces("text/plain")
    public String estadistica3(@QueryParam("username") String username)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica3(estadisticaObject);
        GetEstadistica3 cmd = (GetEstadistica3) commandEstadistica;

        try {
            cmd.execute();
            Entity result = cmd.Return();
            Estadistica json = (Estadistica) result;
            return gson.toJson(json);

        } catch (VIUCABException e) {

            estadisticaObject.set_errorCode( e.ERROR_CODE );
            estadisticaObject.set_errorMsg( e.ERROR_MSG );
            logger.error( "Metodo: {} {}", "getTrainingDetail", e.toString() );
            return gson.toJson( estadisticaObject );



        }

    }

    /***
     * web service que es llamado a traves del fronten para Ver Estadísticas de usuarios con mas videos
     * @param username
     * @return
     */
    @GET
    @Path("/Estadistica4")
    @Produces("text/plain")
    public String estadistica4(@QueryParam("username") String username)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica4(estadisticaObject);
        GetEstadistica4 cmd = (GetEstadistica4) commandEstadistica;

        try {
            cmd.execute();
            Entity result = cmd.Return();
            Estadistica json = (Estadistica) result;
            return gson.toJson(json);

        } catch (VIUCABException e) {

            estadisticaObject.set_errorCode( e.ERROR_CODE );
            estadisticaObject.set_errorMsg( e.ERROR_MSG );
            logger.error( "Metodo: {} {}", "getTrainingDetail", e.toString() );
            return gson.toJson( estadisticaObject );



        }

    }

    /***
     * web service que es llamado a traves del fronten para Ver Estadísticas número de personas seguidas por mes
     * @param username
     * @return
     */
    @GET
    @Path("/Estadistica5")
    @Produces("text/plain")
    public String estadistica5(@QueryParam("username") String username)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica5(estadisticaObject);
        GetEstadistica5 cmd = (GetEstadistica5) commandEstadistica;

        try {
            cmd.execute();
            Entity result = cmd.Return();
            Estadistica json = (Estadistica) result;
            return gson.toJson(json);

        } catch (VIUCABException e) {

            estadisticaObject.set_errorCode( e.ERROR_CODE );
            estadisticaObject.set_errorMsg( e.ERROR_MSG );
            logger.error( "Metodo: {} {}", "getTrainingDetail", e.toString() );
            return gson.toJson( estadisticaObject );



        }

    }
    /***
     * web service que es llamado a traves del fronten para Ver Estadísticas número de personas que te siguen por mes
     * @param username
     * @return
     */
    @GET
    @Path("/Estadistica6")
    @Produces("text/plain")
    public String estadistica6(@QueryParam("username") String username,
                               @QueryParam("date") String date)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica6(estadisticaObject);
        GetEstadistica6 cmd = (GetEstadistica6) commandEstadistica;

        try {
            cmd.execute();
            Entity result = cmd.Return();
            Estadistica json = (Estadistica) result;
            return gson.toJson(json);

        } catch (VIUCABException e) {

            estadisticaObject.set_errorCode( e.ERROR_CODE );
            estadisticaObject.set_errorMsg( e.ERROR_MSG );
            logger.error( "Metodo: {} {}", "getTrainingDetail", e.toString() );
            return gson.toJson( estadisticaObject );



        }
    }

    /***
     * web service que es llamado a traves del fronten para Ver Estadísticas De número de visualizaciones de tus vídeos por mes
     * @param username
     * @return
     */
    @GET
    @Path("/Estadistica7")
    @Produces("text/plain")
    public String estadistica7(@QueryParam("username") String username,
                               @QueryParam("date") String date)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica7(estadisticaObject);
        GetEstadistica7 cmd = (GetEstadistica7) commandEstadistica;

        try {
            cmd.execute();
            Entity result = cmd.Return();
            Estadistica json = (Estadistica) result;
            return gson.toJson(json);

        } catch (VIUCABException e) {

            estadisticaObject.set_errorCode( e.ERROR_CODE );
            estadisticaObject.set_errorMsg( e.ERROR_MSG );
            logger.error( "Metodo: {} {}", "getTrainingDetail", e.toString() );
            return gson.toJson( estadisticaObject );



        }

    }
    /***
     * web service que es llamado a traves del fronten para listar cual video tiene mas categorias lusto

     * @param username
     * @return
     */
    @GET
    @Path("/Estadistica8")
    @Produces("text/plain")
    public String estadistica8(@QueryParam("username") String username,
                               @QueryParam("date") String date)  {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica8(estadisticaObject);
        GetEstadistica8 cmd = (GetEstadistica8) commandEstadistica;

        try {
            cmd.execute();
            Entity result = cmd.Return();
            Estadistica json = (Estadistica) result;
            return gson.toJson(json);

        } catch (VIUCABException e) {

            estadisticaObject.set_errorCode( e.ERROR_CODE );
            estadisticaObject.set_errorMsg( e.ERROR_MSG );
            logger.error( "Metodo: {} {}", "getTrainingDetail", e.toString() );
            return gson.toJson( estadisticaObject );



        }

    }
    /***
     * web service que es llamado a traves del fronten para listar cual video tiene mas categorias lusto
     * @param username
     * @return
     */

    @GET
    @Path("/Estadistica9")
    @Produces("text/plain")
    public String estadistica9(@QueryParam("username") String username,
                               @QueryParam("date") String date)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica9(estadisticaObject);
        GetEstadistica9 cmd = (GetEstadistica9) commandEstadistica;

        try {
            cmd.execute();
            Entity result = cmd.Return();
            Estadistica json = (Estadistica) result;
            return gson.toJson(json);

        } catch (VIUCABException e) {

            estadisticaObject.set_errorCode( e.ERROR_CODE );
            estadisticaObject.set_errorMsg( e.ERROR_MSG );
            logger.error( "Metodo: {} {}", "getTrainingDetail", e.toString() );
            return gson.toJson( estadisticaObject );



        }

    }
}
