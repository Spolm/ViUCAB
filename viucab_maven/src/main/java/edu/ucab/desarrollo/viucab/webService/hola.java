package edu.ucab.desarrollo.viucab.webService;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;




@Path("/hola")
public class hola {



    @GET
    @Path("/holamundo")
    @Produces("text/plain")
    public String getUser(@QueryParam("username") String username,
                          @QueryParam("password") String password)
    {
        //pasan el valor con ?username= y lo que quieran capturar |
            return "hola" + username;
    }




}
