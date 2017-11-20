package edu.ucab.desarrollo.viucab.webService;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/hola")
public class hola {



    @GET
    @Path("/holamundo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response holamundo() {
        String json = "{hola}";
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }




}
