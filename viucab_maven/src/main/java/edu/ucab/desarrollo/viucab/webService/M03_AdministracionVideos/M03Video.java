package edu.ucab.desarrollo.viucab.webService.M03_AdministracionVideos;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.VideoEntity;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
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
        VideoEntity videoAux = EntityFactory.instantiateVideoEntity();

        String imgUrl = videoAux.saveImage(imagen);

        Entity video = EntityFactory.instantiateVideoEntity(titulo,descripcion,imgUrl,url,usuario);

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
                VideoEntity videoAux = EntityFactory.instantiateVideoEntity();
                 imgUrl = videoAux.saveImage(imagen);
            }


        Entity video = EntityFactory.instantiateVideoEntity(videoId,titulo,descripcion,imgUrl);


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
    public String getVideo(@QueryParam("videoId") int videoId){

        GetVideoCommand cmd = CommandsFactory.intantiateGetVideoCommand(videoId);
        try {
            cmd.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gson.toJson(cmd._returned);
    }

    @GET
    @Path("/getAll")
    @Produces("application/json")
    public String getAllVideoFromUser(@QueryParam("userId") int userId){


        GetAllVideoByIdCommand cmd = CommandsFactory.intantiateGetAllVideoByIdCommand(userId);
        try {
            cmd.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gson.toJson(cmd._returned);
    }

    @DELETE
    @Produces("application/json")
    public String deleteVideo(@QueryParam("videoId") int videoId){

        DeleteVideoCommand cmd = CommandsFactory.intantiateDeleteVideoCommand(videoId);
        try {
            cmd.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gson.toJson(cmd._returned);
    }




}