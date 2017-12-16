package edu.ucab.desarrollo.viucab.webService.M11_Estadistica;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Estadistica;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.*;

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
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        return gson.toJson(json);
    }

    @GET
    @Path("/Estadistica2")
    @Produces("text/plain")
    public String estadistica2(@QueryParam("username") String username)
    {
        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica2(estadisticaObject);
        GetEstadistica2 cmd = (GetEstadistica2) commandEstadistica;
        cmd.execute();
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        return gson.toJson(json);
    }


    @GET
    @Path("/Estadistica3")
    @Produces("text/plain")
    public String estadistica3(@QueryParam("username") String username)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica3(estadisticaObject);
        GetEstadistica3 cmd = (GetEstadistica3) commandEstadistica;
        cmd.execute();
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        return gson.toJson(json);
    }

    @GET
    @Path("/Estadistica4")
    @Produces("text/plain")
    public String estadistica4(@QueryParam("username") String username)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica4(estadisticaObject);
        GetEstadistica4 cmd = (GetEstadistica4) commandEstadistica;
        cmd.execute();
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        return gson.toJson(json);
    }

    @GET
    @Path("/Estadistica5")
    @Produces("text/plain")
    public String estadistica5(@QueryParam("username") String username)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica5(estadisticaObject);
        GetEstadistica5 cmd = (GetEstadistica5) commandEstadistica;
        cmd.execute();
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        return gson.toJson(json);
    }

    @GET
    @Path("/Estadistica6")
    @Produces("text/plain")
    public String estadistica6(@QueryParam("username") String username,
                               @QueryParam("date") String date)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica6(estadisticaObject);
        GetEstadistica6 cmd = (GetEstadistica6) commandEstadistica;
        cmd.execute();
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        return gson.toJson(json);
    }

    @GET
    @Path("/Estadistica7")
    @Produces("text/plain")
    public String estadistica7(@QueryParam("username") String username,
                               @QueryParam("date") String date)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica7(estadisticaObject);
        GetEstadistica7 cmd = (GetEstadistica7) commandEstadistica;
        cmd.execute();
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        return gson.toJson(json);
    }

    @GET
    @Path("/Estadistica8")
    @Produces("text/plain")
    public String estadistica8(@QueryParam("username") String username,
                               @QueryParam("date") String date)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica8(estadisticaObject);
        GetEstadistica8 cmd = (GetEstadistica8) commandEstadistica;
        cmd.execute();
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        return gson.toJson(json);
    }

    @GET
    @Path("/Estadistica9")
    @Produces("text/plain")
    public String estadistica9(@QueryParam("username") String username,
                               @QueryParam("date") String date)
    {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica9(estadisticaObject);
        GetEstadistica9 cmd = (GetEstadistica9) commandEstadistica;
        cmd.execute();
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        return gson.toJson(json);
    }
}
