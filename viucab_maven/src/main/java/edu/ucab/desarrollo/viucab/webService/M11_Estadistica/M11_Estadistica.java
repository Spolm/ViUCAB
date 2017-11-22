package edu.ucab.desarrollo.viucab.webService.M11_Estadistica;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/Estadistica")
public class M11_Estadistica {

    @GET
    @Path("/Estadistica1")
    @Produces("text/plain")
    public String estadistica1(@QueryParam("username") String username)
    {

        return "hola" + username;
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
