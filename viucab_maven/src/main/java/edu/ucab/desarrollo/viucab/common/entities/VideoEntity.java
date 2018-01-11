package edu.ucab.desarrollo.viucab.common.entities;

import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.IDaoVideoEntity;

import java.sql.SQLException;

public class VideoEntity extends Entity {


    private String _titulo;
    private String _descripcion;
    private String _imagen;
    private String _url;
    private String _fecha;
    private int _visitas;
    private int _usuario;



    public VideoEntity() {}

    public VideoEntity(String titulo, String descripcion, String imagen, String url, int usuario) {

        _titulo = titulo;
        _descripcion = descripcion;
        _imagen = imagen;
        _url = url;
        _usuario = usuario;

    }

    public VideoEntity(int id, String titulo, String descripcion, String imagen, String url, String fecha, int visitas) {

        _id = id;
        _titulo = titulo;
        _descripcion = descripcion;
        _imagen = imagen;
        _url = url;
        _fecha = fecha;
        _visitas = visitas;

    }

    public VideoEntity(int videoId, String titulo, String descripcion) {
        _id = videoId;
        _titulo = titulo;
        _descripcion = descripcion;
    }

    public int getNextId(){
        int response=0;
        IDaoVideoEntity daoVideo = DaoFactory.instantiateDaoVideoEntity();
        try {
            response = daoVideo.getNextId();
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
