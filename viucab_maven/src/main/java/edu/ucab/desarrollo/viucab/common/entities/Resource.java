package edu.ucab.desarrollo.viucab.common.entities;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;

/**
 * Singleton que se encarga de manejar los recurso multimedia de los video
 */

public class Resource{

    private static Resource _instance = null;
    private static final String FOLDER_DIR = "C:/Users/andre/Documents/glassfish4/glassfish/domains/domain1/docroot";

    /**
     * Constructor Vacio de recurso
     */
    private Resource(){}

    /**
     * Metodo caracteristico de los singleton para obtener instancia
     */
    public static Resource getInstance(){
            if(_instance==null)
                _instance = new Resource();
            return _instance;
    }

    /**
     * Metodo que salva video en el servidor y te devuelve el url del mismo
     * @Param InputStream
     */

    public String saveVideo(InputStream uploadedInputStream) throws IOException {

        VideoEntity video = (VideoEntity) EntityFactory.instantiateVideoEntity();
        int idVideo= video.getNextId();

        String name = idVideo +".mp4";
        String filePath = FOLDER_DIR + "/video//" + name;
        saveFile(uploadedInputStream,filePath);

        return name;
    }

    /**
     * Metodo que salva imagen en el servidor y te devuelve el url del mismo
     * @Param InputStream
     */

    public String saveImage(InputStream uploadedInputStream) throws IOException {

        VideoEntity video = (VideoEntity) EntityFactory.instantiateVideoEntity();
        int idVideo= video.getNextId();

        String name = idVideo +".jpg";
        String filePath = FOLDER_DIR + "/image/" + name;
        saveFile(uploadedInputStream,filePath);

        return name;
    }

    /**
     * Metodo que salva archivi en el servidor.
     * @Param InputStream
     * @Param String
     */
    private void saveFile(InputStream uploadedInputStream, String serverLocation) throws IOException {
        //uploadedInputStream.close();
        java.nio.file.Path path = FileSystems.getDefault().getPath(serverLocation);
        Files.copy(uploadedInputStream, path);


    }

}
