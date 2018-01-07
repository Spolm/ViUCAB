package edu.ucab.desarrollo.viucab.webService.M03_AdministracionVideos;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos.AddVideoCommand;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.sql.Connection;

@Path("/Video")
public class M03Video {
    static Gson gson = new Gson();
    static Connection conn = Sql.getConInstance();


    @PUT
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    public String addVideo(@FormDataParam("file") InputStream imagen,
                           @FormDataParam("titulo") String titulo,
                           @FormDataParam("descripcion") String descripcion,
                           @FormDataParam("url") String url,
                           @FormDataParam("usuario") int usuario
                            ){

        //SALVAR IMAGEN Y OBTENER SU URL
        Video videoAux = (Video) EntityFactory.instantiateVideo();

        String imgUrl = videoAux.saveImage(imagen,usuario);

        Entity video = EntityFactory.instantiateVideo(titulo,descripcion,imgUrl,url,usuario);

        AddVideoCommand cmd = (AddVideoCommand) CommandsFactory.intantiateAddVideoCommand(video);

        try {
            cmd.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return gson.toJson(cmd._returned);
    }

    @POST
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
    @Produces("application/json")
    public String deleteVideo(/*@QueryParam("videoId") String videoId*/){

        return gson.toJson("DeleteVideo");
    }




}