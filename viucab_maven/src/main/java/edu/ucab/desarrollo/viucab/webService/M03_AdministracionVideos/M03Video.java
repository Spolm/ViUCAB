package edu.ucab.desarrollo.viucab.webService.M03_AdministracionVideos;

import com.google.gson.Gson;

import com.sun.jersey.core.header.ContentDisposition;
import com.sun.jersey.core.header.FormDataContentDisposition;
//import com.sun.jersey.multipart.FormDataBodyPart;
//import com.sun.jersey.multipart.FormDataMultiPart;
//import com.sun.jersey.multipart.FormDataParam;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import org.apache.commons.io.IOUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.*;
import java.sql.Connection;

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

    @PUT
    @Path("/uploadImage")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    public String uploadImage() {

        return gson.toJson("uploadImage");
    }

    @PUT
    @Path("/uploadVideo")
    @Produces("application/json")
    public String uploadVideo(/*@QueryParam("valor") String valor*/){

        return gson.toJson("uploadVideo");
    }



































    //esto hay q sacarlo de aqui

    private static final String UPLOAD_FOLDER = "C:/Users/andre/Desktop";

/*
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(FormDataMultiPart form) {

        FormDataBodyPart filePart = form.getField("file");

        ContentDisposition headerOfFilePart =  filePart.getContentDisposition();

        InputStream fileInputStream = filePart.getValueAs(InputStream.class);

        String filePath = UPLOAD_FOLDER + headerOfFilePart.getFileName();

        // save the file to the server
        saveFile(fileInputStream, filePath);

        String output = "File saved to server location using FormDataMultiPart : " + filePath;

        return Response.status(200).entity(output).build();

    }*/

    // save uploaded file to a defined location on the server
    private void saveFile(InputStream uploadedInputStream, String serverLocation) {

        try {
            OutputStream outpuStream = new FileOutputStream(new File(
                    serverLocation));
            int read = 0;
            byte[] bytes = new byte[1024];

            outpuStream = new FileOutputStream(new File(serverLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                outpuStream.write(bytes, 0, read);
            }

            outpuStream.flush();
            outpuStream.close();

            uploadedInputStream.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}