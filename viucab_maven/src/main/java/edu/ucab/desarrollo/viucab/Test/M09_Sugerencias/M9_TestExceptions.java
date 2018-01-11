package edu.ucab.desarrollo.viucab.Test.M09_Sugerencias;

import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import org.junit.Test;
import org.postgresql.util.PSQLException;

import java.sql.*;

import static edu.ucab.desarrollo.viucab.dataAccessLayer.Dao.getBdConnect;

public class M9_TestExceptions {

    @Test(expected = SQLException.class)
    public void testSQLException() throws SQLException {
        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;
        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            Statement st = conn.createStatement();
            // st.executeUpdate(query);
            ResultSet rs = st.executeQuery("HOLA");


        } catch (SQLException e){e.printStackTrace();}

    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException() throws SQLException {
        CallableStatement preStatement = null;
        ResultSet resultSet = null;
        Connection conn;
        //Consulta que corre pero no trae nada
        String query = "SELECT * FROM public.video JOIN public.likes ON public.video.vid_id = public.likes.id_video JOIN public.suscripcion ON public.likes.id_usuario = public.suscripcion.id_suscripcion JOIN public.categoria ON public.categoria.cat_id = public.video.vid_categoria WHERE id_suscriptor = 1 AND public.categoria.cat_valor = 'Deporte' ";

        try {
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            Statement st = conn.createStatement();
            // st.executeUpdate(query);
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                int a = rs.getInt("id");
            }


        } catch (NullPointerException e){e.printStackTrace();}

    }
}
