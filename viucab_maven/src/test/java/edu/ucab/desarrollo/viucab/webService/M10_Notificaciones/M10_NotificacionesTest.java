package edu.ucab.desarrollo.viucab.webService.M10_Notificaciones;

import com.google.gson.*;
import static edu.ucab.desarrollo.viucab.dataAccessLayer.Dao.getBdConnect;
import java.sql.*;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.IntegerBinding;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;


public class M10_NotificacionesTest {
    Gson gson = new Gson();
     public M10_NotificacionesTest() {

     }

    @BeforeClass
    public static void setUpClass() throws SQLException {
        Connection conn;
        conn = getBdConnect();
        String query = "INSERT INTO usuario(usu_id, usu_login, usu_clave, usu_token, usu_correo,usu_act, usu_avatar) VALUES (99,'junit','1234','0', 'prueba@prueba.com',true,' ');\n"
                + "INSERT INTO video(vid_id,vid_titulo,vid_visitas,vid_usuario, vid_descripcion, vid_imagen, vid_url,vid_fecha) VALUES (99,'Prueba', 99, 99, 'd', 'img', 'url', now());\n"
                + "INSERT INTO notificacion(not_id, not_fecha, not_desechado, usu_id, vid_id) VALUES (99, now(), false,99, 99);";
        Statement st = conn.createStatement();
        st.executeUpdate(query);

    }


    @Test
    public void testGetNotificaciones() throws Exception {
        System.out.println("getNotificaciones");
        M10_Notificaciones instance = new M10_Notificaciones();
        Response result = instance.obtenerNotificacion();
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(result.toString()).getAsJsonObject();
        assertEquals(99, Integer.parseInt(json.get("not_id").getAsString()));
        assertEquals(false, Boolean.parseBoolean(json.get("not_desechado").getAsString()));
        assertEquals(99, Integer.parseInt(json.get("usu_id").getAsString()));
        assertEquals(99, Integer.parseInt(json.get("usu_id").getAsString()));
    }
}
