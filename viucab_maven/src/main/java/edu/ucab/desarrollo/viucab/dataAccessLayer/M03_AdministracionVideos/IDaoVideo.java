package edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDaoVideo extends IDao{

    public int addVideo(Entity e) throws SQLException;
    public Entity getVideo(int idVideo) throws SQLException;
    public ArrayList<Video> getAllVideoById(int idUsuario) throws SQLException;
    public int updateVideo(Entity e) throws SQLException;
    public Entity deleteVideo (Entity e) throws SQLException;
    public int getLastId() throws SQLException;

}
