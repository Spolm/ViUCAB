package edu.ucab.desarrollo.viucab.webService.M03_AdministracionVideos;

import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;

import javax.imageio.ImageIO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.sql.Connection;
import java.util.Random;


@Path("/Resources")
public class M03Resources {

    static Gson gson = new Gson();
    static Connection conn = Sql.getConInstance();
    private static final String FOLDER_DIR = "C:/Users/andre/Desktop/img/";

//    @POST
//    @Path("/uploadImage")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    @Produces("application/json")
//    public String uploadImage(@FormDataParam("file") InputStream uploadedInputStream,
//                              @FormDataParam("file") FormDataContentDisposition fileDisposition) {
//
//        String name = "download-" + Integer.toString( new Random().nextInt(50)) +".jpg";
//        String filePath = FOLDER_DIR + name;
//        saveFile(uploadedInputStream,filePath);
//        String output = "File uploaded to : " + filePath;
//        return gson.toJson(output);
//
//    }

    @POST
    @Path("/uploadVideo")
    @Produces("application/json")
    public String uploadVideo(@FormDataParam("file") InputStream uploadedInputStream,
                              @FormDataParam("file") FormDataContentDisposition fileDisposition) {

        String name = "download-" + Integer.toString( new Random().nextInt(50)) +".mp4";
        String filePath = FOLDER_DIR + name;
        saveFile(uploadedInputStream,filePath);
        String output = "File uploaded to : " + filePath;
        return gson.toJson(output);

    }

    @POST
    @Path("/TestSaveImage")
    public Response SaveImageTest() {


        BufferedImage img;
        InputStream is = null;

        try
        {
            img = ImageIO.read(new File(FOLDER_DIR + "upload.jpg")); // eventually C:\\ImageTest\\pic2.jpg
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", os);
            is = new ByteArrayInputStream(os.toByteArray());
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }

        InputStream fileInputStream = is;

        String filePath = FOLDER_DIR + "download"+ Integer.toString( new Random().nextInt(50)) +".jpg";

        // save the file to the server
        saveFile(fileInputStream, filePath);


        String output = "File saved to server location using FormDataMultiPart : " + filePath;

        return Response.status(200).entity(output).build();

    }

    @POST
    @Path("/TestSaveVideo")
    public Response SaveVideoTest() {

        InputStream is = null;

        File initialFile = new File(FOLDER_DIR + "videoUpload.mp4");
            try {
            is = new FileInputStream(initialFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStream fileInputStream = is;


        String filePath = FOLDER_DIR + "download"+ Integer.toString( new Random().nextInt(50)) +".mp4";

        // save the file to the server
        saveFile(fileInputStream, filePath);


        String output = "File saved to server location using FormDataMultiPart : " + filePath;

        return Response.status(200).entity(output).build();

    }

    // save uploaded file to a defined location on the server
    private void saveFile(InputStream uploadedInputStream, String serverLocation) {

        java.nio.file.Path path = FileSystems.getDefault().getPath(serverLocation);
        try {
            Files.copy(uploadedInputStream,path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
