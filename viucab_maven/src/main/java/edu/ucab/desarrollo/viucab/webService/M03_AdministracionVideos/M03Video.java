package edu.ucab.desarrollo.viucab.webService.M03_AdministracionVideos;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Resource;
import edu.ucab.desarrollo.viucab.common.entities.VideoEntity;
import edu.ucab.desarrollo.viucab.common.exceptions.ParameterNotValidException;
import edu.ucab.desarrollo.viucab.common.exceptions.ParameterNullException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.DaoVideoEntity;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos.*;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.InsertarEtiqueta;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;

@Path("/Video")
public class M03Video {
    final static org.slf4j.Logger logger = LoggerFactory.getLogger(DaoVideoEntity.class);
    static Gson gson = new Gson();

    @PUT
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    public String addVideo(@FormDataParam("video") InputStream video,
                           @FormDataParam("imagen") InputStream imagen,
                           @FormDataParam("titulo") String titulo,
                           @FormDataParam("descripcion") String descripcion,
                           @FormDataParam("usuario") int usuario,
                           @FormDataParam("tag") String tag
                            ){
        logger.debug("Debug: Adding VideoEntity - WebService");

        Resource r =  Resource.getInstance();
        VideoEntity aux;
        AddVideoCommand cmd;

        try {
            if(video == null)
                throw new ParameterNullException("Video");
            if(imagen == null)
                throw new ParameterNullException("Imagen");
            if(titulo == null)
                throw new ParameterNullException("Titulo");
            if(descripcion == null)
                throw new ParameterNullException("Descripcion");
            if(usuario == 0)
                throw new ParameterNotValidException("Usuario");

            aux = EntityFactory.instantiateVideoEntity(titulo,descripcion,r.saveImage(imagen),r.saveVideo(video),usuario);
            cmd = CommandsFactory.intantiateAddVideoCommand(aux);
            cmd.execute();

            otrosModulos(tag,aux.getNextId()-1);
            return gson.toJson(cmd._returned);

        }catch (FileAlreadyExistsException e) {
            e.printStackTrace();
            logger.error("Error: Archivo ya existente "+e.getMessage());
            return gson.toJson("Error: Archivo ya existente "+e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Error: "+e.getMessage());
            return gson.toJson(e.getMessage());
        }




    }

    private void otrosModulos(String tag, int id) {

            Entity etiquetaObject = EntityFactory.insertEtiqueta(tag, id);
            Command commandEtiqueta = CommandsFactory.instanciateInsertEtiqueta(etiquetaObject);
            InsertarEtiqueta cmd = (InsertarEtiqueta) commandEtiqueta;
            cmd.execute();
            Entity result = cmd.Return();
    }

    @GET
    @Path("/update")
    @Produces("application/json")
    public String updateVideo(@QueryParam("titulo") String titulo,
                              @QueryParam("descripcion") String descripcion,
                              @QueryParam("videoId") int videoId
                              ){
        logger.debug("Debug: Update VideoEntity - WebService");

        UpdateVideoCommand cmd;
        Entity video;

        try {

            if(titulo == null)
                throw new ParameterNullException("Titulo");
            if(descripcion == null)
                throw new ParameterNullException("Descripcion");
            if(videoId == 0)
                throw new ParameterNotValidException("Video Id");


            video = EntityFactory.instantiateVideoEntity(videoId,titulo,descripcion);
            cmd = CommandsFactory.intantiateUpdateVideoCommand(video);
            cmd.execute();
            return gson.toJson(cmd._returned);

        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Error: "+e.getMessage());
            return gson.toJson(e.getMessage());
        }


    }

    @GET
    @Path("/get")
    @Produces("application/json")
    public String getVideo(@QueryParam("videoId") int videoId){
        logger.debug("Debug: Getting VideoEntity - WebService");

        GetVideoCommand cmd;

        try {
            if(videoId == 0)
                throw new ParameterNotValidException("videoId");

            cmd = CommandsFactory.intantiateGetVideoCommand(videoId);
            cmd.execute();
            return gson.toJson(cmd._returned);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error: "+e.getMessage());
            return gson.toJson(e.getMessage());
        }

    }

    @GET
    @Path("/getAll")
    @Produces("application/json")
    public String getAllVideoFromUser(@QueryParam("userId") int userId){
        logger.debug("Debug: Getting all video from user - WebService");


        GetAllVideoByIdCommand cmd;
        try {
            if(userId == 0)
                throw new ParameterNotValidException("UsuarioId");

            cmd  = CommandsFactory.intantiateGetAllVideoByIdCommand(userId);
            cmd.execute();
            return gson.toJson(cmd._returned);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error: "+e.getMessage());
            return gson.toJson(e.getMessage());
        }

    }

    @DELETE
    @Produces("application/json")
    public String deleteVideo(@QueryParam("videoId") int videoId){
        logger.debug("Debug: Deleting VideoEntity - WebService");

        DeleteVideoCommand cmd;
        try {
            if(videoId == 0)
                throw new ParameterNotValidException("videoId");

            cmd = CommandsFactory.intantiateDeleteVideoCommand(videoId);
            cmd.execute();
            return gson.toJson(cmd._returned);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error: "+e.getMessage());
            return gson.toJson(e.getMessage());
        }

    }




}