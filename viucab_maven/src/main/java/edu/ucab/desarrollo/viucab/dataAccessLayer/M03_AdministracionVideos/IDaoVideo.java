package edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;

import java.sql.SQLException;

public interface IDaoVideo extends IDao{

    public int addVideo(Entity e) throws SQLException;
    public Entity getVideo(int idVideo) throws SQLException;
    public Entity getListVideo(int idUsuario) throws SQLException;
    public Entity updateVideo(Entity e) throws SQLException;
    public Entity deleteVideo (Entity e) throws SQLException;

}
