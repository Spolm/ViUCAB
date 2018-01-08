package edu.ucab.desarrollo.viucab.common.entities;

import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.IDaoVideo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.sql.SQLException;

public class Video extends Entity {


    private String _titulo;
    private String _descripcion;
    private String _imagen;
    private String _url;
    private String _fecha;
    private int _visitas;
    private int _usuario;


    private static final String FOLDER_DIR = "C:/Users/andre/Desktop";


    public Video() {}

    public Video(String titulo, String descripcion, String imagen, String url, int usuario) {

        _titulo = titulo;
        _descripcion = descripcion;
        _imagen = imagen;
        _url = url;
        _usuario = usuario;

    }

    public Video(int id, String titulo, String descripcion, String imagen, String url, String fecha, int visitas) {

        _id = id;
        _titulo = titulo;
        _descripcion = descripcion;
        _imagen = imagen;
        _url = url;
        _fecha = fecha;
        _visitas = visitas;

    }

    public Video(int videoId, String titulo, String descripcion, String imgUrl) {
        _id = videoId;
        _titulo = titulo;
        _descripcion = descripcion;
        _imagen = imgUrl;
    }

    public String saveVideo(InputStream uploadedInputStream, int usuario ){

        int idVideo= getLastId();

        String name = idVideo +".mp4";
        String filePath = FOLDER_DIR + "/vid/" + name;
        saveFile(uploadedInputStream,filePath);

        return name;
    }

    public String saveImage(InputStream uploadedInputStream){

        int idVideo= getLastId();
        ;//Llamar a stores procedure que te da el siguiente id de video

        String name = idVideo +".jpg";
        String filePath = FOLDER_DIR + "/img/" + name;
        saveFile(uploadedInputStream,filePath);

        return name;
    }

    private void saveFile(InputStream uploadedInputStream, String serverLocation) {

        java.nio.file.Path path = FileSystems.getDefault().getPath(serverLocation);
        try {
            Files.copy(uploadedInputStream, path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int getLastId(){
        int response=0;
        IDaoVideo daoVideo = DaoFactory.instantiateDaoVideo();
        try {
            response = daoVideo.getLastId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    public int get_id() {
        return _id;
    }
    public String get_titulo() {
        return _titulo;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public String get_imagen() {
        return _imagen;
    }

    public String get_url() {
        return _url;
    }

    public int get_usuario() {
        return _usuario;
    }
}
