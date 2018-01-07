package edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DaoVideo implements IDaoVideo {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(DaoVideo.class);

    public DaoVideo(){

    }

    @Override
    public int addVideo(Entity e) throws SQLException {

        logger.debug("Debug: Agregando Video - DAO");

        int respuesta = 0;
        Video agregar = (Video) e;

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
            respuesta = addVideoResult(rs);

        }catch (Exception ex){
            if(ex instanceof NullPointerException)
                agregar.set_errorMsg("Error de apuntador Nulo.");
            else if (ex instanceof SQLException)
                agregar.set_errorMsg("Error en la conexion de la BD.");
            else
                agregar.set_errorMsg(ex.getMessage());
        }finally {
            return respuesta;
        }



    }

    @Override
    public Entity getVideo(int idVideo) throws SQLException {
        return null;
    }

    @Override
    public Entity getListVideo(int idUsuario) throws SQLException {
        return null;
    }

    @Override
    public Entity updateVideo(Entity e) throws SQLException {
        return null;
    }

    @Override
    public Entity deleteVideo(Entity e) throws SQLException {
        return null;
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


    private int addVideoResult(ResultSet rs) throws NullPointerException, SQLException{

        int salida = 0;

        while (rs.next()){
            salida = rs.getInt("res");
        }

        return salida;

    }
}
