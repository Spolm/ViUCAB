package edu.ucab.desarrollo.viucab.dataAccessLayer.M07_Etiquetas;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Etiquetas;
import edu.ucab.desarrollo.viucab.common.entities.Video_Etiq;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GetEtiquetasDao extends Dao implements IDaoEtiqueta {

    public GetEtiquetasDao(){

    }

    @Override
    public Entity insertarEtiqueta(Entity e) throws SQLException {
        Connection conn;
        String insert="INSERT INTO ETIQUETA (ETI_VALOR) VALUES(?);";
        Etiquetas eti = (Etiquetas) e;
        try{
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, eti.getValor());
            ps.executeUpdate();
        }
        catch(SQLException el) {
            el.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return eti;
    }

    @Override
    public Entity eliminarEtiqueta(Entity e) throws SQLException{
        Connection conn;
        Etiquetas eti = (Etiquetas) e;
        String delete="DELETE FROM ETIQUETA WHERE ETI_ID = (?);";
        try{
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setInt(1, eti.getId());
            ps.executeUpdate();
        }
        catch(SQLException el) {
            el.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return eti;
    }

    @Override
    public List<Video_Etiq> consultarVideos(Entity e) throws SQLException{
        Connection conn;
        Etiquetas eti = (Etiquetas) e;

        List<Video_Etiq> list = new ArrayList<Video_Etiq>();

        String selectVid="SELECT V.VID_ID ID_VID, E.ETI_ID ID_ETIQ FROM VIDEO V, " +
                         "VIDEO_ETIQ VE, ETIQUETA E WHERE E.ETI_ID = (?) " +
                         "AND VE.IDVID = V.VID_ID AND VE.IDETIQ = (?);";

        try{
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            PreparedStatement ps = conn.prepareStatement(selectVid);
            ps.setInt(1, eti.getId());
            ps.setInt(2, eti.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int _id = rs.getInt("ID_ETIQ");
                int _idVid = rs.getInt("ID_VID");
                Video_Etiq video_etiq = new Video_Etiq(_id, _idVid);
                list.add(video_etiq);
            }
        }
        catch(SQLException el) {
            el.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return list;
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
}
