/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucab.desarrollo.viucab.dataAccessLayer.M04_Reproductor;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import static edu.ucab.desarrollo.viucab.dataAccessLayer.Dao.getBdConnect;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlejandroNegrin
 */
public class VideoDao extends Dao implements IDaoVideo {

    @Override
    public Entity create(Entity e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity read(Entity e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity update(Entity e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JsonObject getVideoYCanal(int idvideo) {
//        System.out.println("LLEGUE A VIDEO CANAL CONSULTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//        System.out.println("c");
//        System.out.println("c");
//        System.out.println("c");
//        System.out.println("c");
//        System.out.println("c");
//        System.out.println("c");
//        System.out.println("con idvideo= "+idvideo);
        Connection conn;
        conn = getBdConnect();
        JsonObject json = new JsonObject();

        CallableStatement stmt;
        try {
            stmt = conn.prepareCall("{call videoinfo(?)}");
            //Metiendo los parametros al SP
            stmt.setInt(1, idvideo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                json.addProperty("title", rs.getString("title"));
                json.addProperty("url", rs.getString("url"));
                json.addProperty("visitas", rs.getString("visitas"));
                json.addProperty("likes", rs.getString("likes"));
                json.addProperty("owner", rs.getString("owner"));
                json.addProperty("idowner", rs.getString("idowner"));
                json.addProperty("imgowner", "../../assets/imgs/advance-card-bttf.png");
                json.addProperty("subscripciones", rs.getString("subscripciones"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(VideoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    @Override
    public JsonArray getVideosRelacionados(int idvideo) {
        Connection conn;
        conn = getBdConnect();
        JsonArray jsonArray = new JsonArray();

        CallableStatement stmt;
        try {
            stmt = conn.prepareCall("{call getVideosRelacionados(?)}");
            //Metiendo los parametros al SP
            stmt.setInt(1, idvideo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                JsonObject json = new JsonObject();
                json.addProperty("id", rs.getString("id"));
                json.addProperty("urlimg", rs.getString("urlimg"));
                json.addProperty("nombre", rs.getString("nombre"));
                json.addProperty("canal", rs.getString("canal"));
                jsonArray.add(json);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VideoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonArray;
    }

    @Override
    public JsonArray getComentarios(int idvideo) {
        Connection conn;
        conn = getBdConnect();
        JsonArray jsonArray = new JsonArray();

        CallableStatement stmt;
        try {
            stmt = conn.prepareCall("{call getComentarios(?)}");
            //Metiendo los parametros al SP
            stmt.setInt(1, idvideo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                JsonObject json = new JsonObject();
                json.addProperty("iduser", rs.getString("iduser"));
                json.addProperty("urlimg", "../../assets/imgs/advance-card-bttf.png");
                json.addProperty("nombre", rs.getString("nombre"));
                json.addProperty("comentario", rs.getString("comentario"));
                jsonArray.add(json);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VideoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonArray;
    }

    @Override
    public void addVisita(int idvideo) {
        Connection conn;
        conn = getBdConnect();
        CallableStatement stmt;
        try {
            stmt = conn.prepareCall("{call addVisita(?)}");
            stmt.setInt(1, idvideo);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VideoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Metiendo los parametros al SP
    }

}
