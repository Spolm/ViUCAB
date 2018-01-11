package edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.VideoEntity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface para definir los metodos del programa relacionados con la administracion del video.
 *
 */

public interface IDaoVideoEntity extends IDao{

    int addVideo(Entity e) throws SQLException;
    VideoEntity getVideo(int idVideo) throws SQLException;
    ArrayList<VideoEntity> getAllVideoById(int idUsuario) throws SQLException;
    int updateVideo(Entity e) throws SQLException;
    int deleteVideo (int idVideo) throws SQLException;
    int getNextId() throws SQLException;

}
