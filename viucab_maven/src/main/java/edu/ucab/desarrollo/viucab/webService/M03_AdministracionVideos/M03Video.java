package edu.ucab.desarrollo.viucab.webService.M03_AdministracionVideos;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
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
        Video videoAux = EntityFactory.instantiateVideo();

        String imgUrl = videoAux.saveImage(imagen);

        Entity video = EntityFactory.instantiateVideo(titulo,descripcion,imgUrl,url,usuario);

        AddVideoCommand cmd = CommandsFactory.intantiateAddVideoCommand(video);

        try {
            cmd.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return gson.toJson(cmd._returned);
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    public String updateVideo(@FormDataParam("file") InputStream imagen,
                              @FormDataParam("titulo") String titulo,
                              @FormDataParam("descripcion") String descripcion,
                              @FormDataParam("oldImgUrl") String oldImgUrl,
                              @FormDataParam("videoId") int videoId
                              ){

        //Si viene el input stream con algo, SALVAR IMAGEN Y OBTENER SU URL
        String imgUrl=oldImgUrl;

            if(imagen!=null){
                Video videoAux = EntityFactory.instantiateVideo();
                 imgUrl = videoAux.saveImage(imagen);
            }


        Entity video = EntityFactory.instantiateVideo(videoId,titulo,descripcion,imgUrl);


        UpdateVideoCommand cmd = CommandsFactory.intantiateUpdateVideoCommand(video);

        try {
            cmd.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gson.toJson(cmd._returned);
    }

    @GET
    @Path("/get")
    @Produces("application/json")
    public String getVideo(@QueryParam("userId") String videoId){

        return gson.toJson("getVideo");
    }

    @GET
    @Path("/getAll")
    @Produces("application/json")
    public String getAllVideoFromUser(@QueryParam("userID") int userID){


        GetAllVideoByIdCommand cmd = CommandsFactory.intantiateGetAllVideoByIdCommand(userID);

        return gson.toJson("getAllFromUser");
    }

    @DELETE
    @Produces("application/json")
    public String deleteVideo(/*@QueryParam("videoId") String videoId*/){

        return gson.toJson("DeleteVideo");
    }




}