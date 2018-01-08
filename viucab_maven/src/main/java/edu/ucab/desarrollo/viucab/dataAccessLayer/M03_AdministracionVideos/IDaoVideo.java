package edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoVideo extends IDao{

    int addVideo(Entity e) throws SQLException;
    Video getVideo(int idVideo) throws SQLException;
    ArrayList<Video> getAllVideoById(int idUsuario) throws SQLException;
    int updateVideo(Entity e) throws SQLException;
    int deleteVideo (int idVideo) throws SQLException;
    int getLastId() throws SQLException;

}
