package edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.VideoEntity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import org.postgresql.util.PSQLException;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class DaoVideoEntity implements IDaoVideoEntity {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(DaoVideoEntity.class);

    public DaoVideoEntity(){

    }

    @Override
    public int addVideo(Entity e) throws SQLException{

        logger.debug("Debug: Adding VideoEntity - DAO");

        int respuesta;
        VideoEntity agregar = (VideoEntity) e;

        SimpleDateFormat _sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaActual = new Date();
        String fecha = _sdf.format(fechaActual);

        ResultSet rs;

        try{
            Connection conn = Dao.getBdConnect();
            CallableStatement stm = conn.prepareCall("{? = Call M03_AddVideo(?,?,?,?,?)}");

            stm.setString(1,agregar.get_titulo());
            stm.setString(2,agregar.get_descripcion());
            stm.setString(3,agregar.get_imagen());
            stm.setString(4,agregar.get_url());
            stm.setString(5,fecha);
            stm.setInt(6,agregar.get_usuario());

            rs = stm.executeQuery();
            respuesta = getResponseIntBD(rs);
            return respuesta;
        }finally {

        }



    }

    @Override
    public VideoEntity getVideo(int idVideo) throws SQLException {
        logger.debug("Debug: Getting VideoEntity - DAO");

        VideoEntity respuesta;

        ResultSet rs;

        try{
            Connection conn = Dao.getBdConnect();
            CallableStatement stm = conn.prepareCall("{? = Call M03_GetVideo()}");

            stm.setInt(1,idVideo);

            rs = stm.executeQuery();
            respuesta = getResponseVideoBD(rs);
            if(respuesta==null)
                throw new SQLException("Video no existe.");
            return respuesta;
        }finally {

        }
    }


    @Override
    public ArrayList<VideoEntity> getAllVideoById(int idUsuario) throws SQLException {
        logger.debug("Debug: Getting All videos from user - DAO");

        ArrayList<VideoEntity> respuesta = null;

        ResultSet rs;

        try{
            Connection conn = Dao.getBdConnect();
            CallableStatement stm = conn.prepareCall("{? = Call M03_GetAllVideoById()}");

            stm.setInt(1,idUsuario);

            rs = stm.executeQuery();
            respuesta = getResponseArrayListBD(rs);
            return respuesta;

        }finally {

        }

    }


    @Override
    public int updateVideo(Entity e) throws SQLException {
        logger.debug("Debug: Updating VideoEntity - DAO");

        int respuesta;
        VideoEntity update = (VideoEntity) e;

        ResultSet rs;

        try{
            Connection conn = Dao.getBdConnect();
            CallableStatement stm = conn.prepareCall("{? = Call M03_UpdateVideo(?,?)}");

            stm.setString(1,update.get_titulo());
            stm.setString(2,update.get_descripcion());
            stm.setInt(3,update.get_id());

            rs = stm.executeQuery();
            respuesta = getResponseIntBD(rs);

            if(respuesta==0)
                throw new SQLException("Video no existe.");

            return respuesta;


        }finally {

        }

    }

    @Override
    public int deleteVideo(int idVideo) throws SQLException {
        logger.debug("Debug: Deleting VideoEntity - DAO");

        int respuesta = 0;

        ResultSet rs;

        try{
            Connection conn = Dao.getBdConnect();
            CallableStatement stm = conn.prepareCall("{? = Call M03_DeleteVideo()}");

            stm.setInt(1,idVideo);

            rs = stm.executeQuery();
            respuesta = getResponseIntBD(rs);
            return respuesta;

        }finally {

        }
    }

    @Override
    public int getNextId() throws SQLException {
        logger.debug("Debug: getLast VideoEntity ID - DAO");

        int respuesta = 0;

        ResultSet rs;

        try{
            Connection conn = Dao.getBdConnect();
            CallableStatement stm = conn.prepareCall("{? = Call M03_getLastId()}");

            stm.setString(1,"");
            rs = stm.executeQuery();
            respuesta = getResponseIntBD(rs);

        }catch (Exception ex){
            if(ex instanceof NullPointerException)
                System.out.println("Error de apuntador Nulo.");
            else if (ex instanceof SQLException)
                System.out.println("Error en la conexion de la BD.");
            else
                System.out.println(ex.getMessage());
            ex.printStackTrace();
        }finally {
            return respuesta;
        }

    }

    @Override
    public Entity create(Entity e) {
        return null;
    }

    @Override
    public Entity read(Entity e) {
        return null;
    }

    @Override
    public Entity update(Entity e) {
        return null;
    }


    private int getResponseIntBD(ResultSet rs) throws NullPointerException, SQLException{

        int salida = 0;

        while (rs.next()){
            salida = rs.getInt("res");
        }

        return salida;

    }

    private ArrayList<VideoEntity> getResponseArrayListBD(ResultSet rs) throws SQLException {
        ArrayList<VideoEntity> salida = new ArrayList<VideoEntity>();

        while (rs.next()){
            VideoEntity v = EntityFactory.instantiateVideoEntity(
                    rs.getInt("id"),
                    rs.getString("titu"),
                    rs.getString("des"),
                    rs.getString("ima"),
                    rs.getString("url"),
                    rs.getString("fec"),
                    rs.getInt("vis")
            );
            salida.add(v);
        }

        return salida;

    }

    private VideoEntity getResponseVideoBD(ResultSet rs)throws SQLException {
        VideoEntity salida = null;

        while (rs.next()){
            salida = EntityFactory.instantiateVideoEntity(
                    rs.getInt("id"),
                    rs.getString("titu"),
                    rs.getString("des"),
                    rs.getString("ima"),
                    rs.getString("url"),
                    rs.getString("fec"),
                    rs.getInt("vis")
            );
        }

        return salida;
    }
}
