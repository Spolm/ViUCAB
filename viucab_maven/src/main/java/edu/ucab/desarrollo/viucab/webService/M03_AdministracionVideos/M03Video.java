package edu.ucab.desarrollo.viucab.webService.M03_AdministracionVideos;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import javax.ws.rs.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Path("/Video")
public class M03Video {
    static Gson gson = new Gson();
    static Connection conn = Sql.getConInstance();

    @PUT
    @Path("/add")
    @Produces("application/json")
    public String addVideo(/*@QueryParam("valor") String valor*/){


        return gson.toJson("addVideo");
    }

    @POST
    @Path("/update")
    @Produces("application/json")
    public String updateVideo(/*@QueryParam("videoId") String videoId*/){


        return gson.toJson("updateVideo");
    }

    @GET
    @Path("/get")
    @Produces("application/json")
    public String getVideo(/*@QueryParam("videoId") String videoId*/){


        return gson.toJson("getVideo");
    }

    @GET
    @Path("/getAll")
    @Produces("application/json")
    public String getAllVideoFromUser(/*@QueryParam("userID") String userID*/){


        return gson.toJson("getAllFromUser");
    }

    @DELETE
    @Path("/delete")
    @Produces("application/json")
    public String deleteVideo(/*@QueryParam("videoId") String videoId*/){


        return gson.toJson("DeleteVideo");
    }


}