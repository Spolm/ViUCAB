package edu.ucab.desarrollo.viucab.webService.M11_Estadistica;
import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Estadistica;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.GetEstadistica1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/Estadistica")
public class M11_Estadistica {

    Gson gson = new Gson();

    @GET
    @Path("/Estadistica1")
    @Produces("text/plain")
    public String estadistica1(@QueryParam("username") String username)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica1(estadisticaObject);
        GetEstadistica1 cmd = (GetEstadistica1) commandEstadistica;
        cmd.execute();
        Estadistica result = (Estadistica) GetEstadistica1.getEstadistica1();
        return gson.toJson(result);
    }

    @GET
    @Path("/Estadistica2")
    @Produces("text/plain")
    public String estadistica2(@QueryParam("username") String username)
    {

        return "hola" + username;
    }


    @GET
    @Path("/Estadistica3")
    @Produces("text/plain")
    public String estadistica3(@QueryParam("username") String username)
    {

        return "hola" + username;
    }

    @GET
    @Path("/Estadistica4")
    @Produces("text/plain")
    public String estadistica4(@QueryParam("username") String username)
    {

        return "hola" + username;
    }

    @GET
    @Path("/Estadistica5")
    @Produces("text/plain")
    public String estadistica5(@QueryParam("username") String username)
    {

        return "hola" + username;
    }

    @GET
    @Path("/Estadistica6")
    @Produces("text/plain")
    public String estadistica6(@QueryParam("username") String username,
                               @QueryParam("date") String date)
    {

        return "hola" + username;
    }

    @GET
    @Path("/Estadistica7")
    @Produces("text/plain")
    public String estadistica7(@QueryParam("username") String username,
                               @QueryParam("date") String date)
    {

        return "hola" + username;
    }

    @GET
    @Path("/Estadistica8")
    @Produces("text/plain")
    public String estadistica8(@QueryParam("username") String username,
                               @QueryParam("date") String date)
    {

        return "hola" + username;
    }

    @GET
    @Path("/Estadistica9")
    @Produces("text/plain")
    public String estadistica9(@QueryParam("username") String username,
                               @QueryParam("date") String date)
    {

        return "hola" + username;
    }
}
