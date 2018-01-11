/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucab.desarrollo.viucab.webService.M04_Reproductor;

import com.google.gson.*;
import static edu.ucab.desarrollo.viucab.dataAccessLayer.Dao.getBdConnect;
import java.sql.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AlejandroNegrin
 */
public class M04_ReproductorTest {

    Gson gson = new Gson();

    public M04_ReproductorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws SQLException {
        Connection conn;
        conn = getBdConnect();
        String query = "INSERT INTO usuario(usu_id, usu_login, usu_clave, usu_token, usu_correo,usu_act) VALUES (0,'junit','1234','0', 'prueba@prueba.com',true);\n"
                + "INSERT INTO video(vid_id,vid_titulo,vid_visitas,vid_usuario, vid_descripcion, vid_imagen, vid_url,vid_fecha) VALUES (0,'Prueba Unitaria', 0, 0, 'd', 'img', 'url', now());\n"
                + "INSERT INTO comentario(com_id, com_descripcion, id_usu, id_vid) VALUES (0, 'prueba unitaria', 0,0);";
        Statement st = conn.createStatement();
        st.executeUpdate(query);

    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
        Connection conn;
        conn = getBdConnect();
        String query = "DELETE FROM likes WHERE id_usuario = 0;\n"
                + "DELETE FROM comentario WHERE id_usu = 0;\n"
                + "DELETE FROM video where vid_id = 0;\n"
                + "DELETE FROM usuario where usu_id = 0;";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getVideoInfo method, of class M04_Reproductor.
     */
    @Test
    public void testGetVideoInfo() throws Exception {
        System.out.println("getVideoInfo");
        M04_Reproductor instance = new M04_Reproductor();
        String result = instance.getVideoInfo("0");
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(result).getAsJsonObject();
        assertEquals(0, Integer.parseInt(json.get("likes").getAsString()));
        assertEquals("Prueba Unitaria", json.get("title").getAsString());
        assertEquals("url", json.get("url").getAsString());
    }

    /**
     * Test of addVisitaVideo method, of class M04_Reproductor.
     */
    @Test
    public void testAddVisitaVideo() throws SQLException {
        System.out.println("addVisitaVideo");
        M04_Reproductor instance = new M04_Reproductor();
        instance.addVisitaVideo("0");
        String query = "SELECT  vid_visitas FROM video WHERE vid_id = 0";
        Connection conn = getBdConnect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        assertEquals(1, rs.getInt("vid_visitas"));
    }

    /**
     * Test of addComentario method, of class M04_Reproductor.
     */
    @Test
    public void testAddComentario() {
        System.out.println("addComentario");
        M04_Reproductor instance = new M04_Reproductor();
        String result = instance.addComentario("1", "prueba@prueba.com", "Hueob con sola");
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(result).getAsJsonObject();
        assertTrue(json.get("result").getAsInt() > 0);
    }

    /**
     * Test of updateLike method, of class M04_Reproductor.
     */
    @Test
    public void testUpdateLike() {
        System.out.println("updateLike");
        M04_Reproductor instance = new M04_Reproductor();
        String result = instance.updateLike("0", "prueba@prueba.com");
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(result).getAsJsonObject();
        assertEquals(1, json.get("result").getAsInt());
    }

    /**
     * Test of getIfLike method, of class M04_Reproductor.
     */
    @Test
    public void testGetIfLike() {
        System.out.println("getIfLike");
        System.out.println("updateLike");
        M04_Reproductor instance = new M04_Reproductor();
        String result = instance.getIfLike("0", "prueba@prueba.com");
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(result).getAsJsonObject();
        assertEquals(1, json.get("result").getAsInt());
    }

    /**
     * Test of deleteComentario method, of class M04_Reproductor.
     */
    @Test
    public void testDeleteComentario() {
        System.out.println("deleteComentario");
        M04_Reproductor instance = new M04_Reproductor();
        String result = instance.deleteComentario("0");
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(result).getAsJsonObject();
        assertEquals(0, json.get("result").getAsInt());
    }

}
