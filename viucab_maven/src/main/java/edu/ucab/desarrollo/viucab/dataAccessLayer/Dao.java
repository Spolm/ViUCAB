package edu.ucab.desarrollo.viucab.dataAccessLayer;


<<<<<<< HEAD
import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.Registry;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.common.exceptions.M11.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.MessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.io.IOException;
=======
import edu.ucab.desarrollo.viucab.common.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

>>>>>>> Develop
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
<<<<<<< HEAD
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> Develop

/***
 * creada por M011
 */
<<<<<<< HEAD
//@Path("/dao")
public class Dao{

    //Gson gson = new Gson();
    Connection conn = null;
    String query;
    //Gson gson = new Gson();

    public Dao(){

    }

    //@GET
    //@Path("/conectar")
   // @Produces("Application/json")
    public String conectarDB(){



        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/ViUCAB", "postgres", "5530321");
            return "Conectado a BD";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "1";
        } catch (SQLException e) {
            e.printStackTrace();
            return "2";
        }
        //return "No conecto";
    }

    //@GET
    //@Path("/desconectar")
   // @Produces("Application/json")
    public String desconectarDB() throws SQLException {
        conn.close();
        return "Desconectado";
    }

    //@GET
   // @Path("/insertar_usuario")
  //  @Produces("Application/json")
    public String insertarUsuario() throws SQLException {
        conectarDB();
        query = "INSERT into usuario(usu_id, usu_login, usu_clave, usu_token, usu_act, usu_correo, usu_avatar) values (2, 'luis', '123', 'papa', true, 'gmail', 'papa')";

        try{
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            desconectarDB();
            return "Se ejecuto exitosamente";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    //@GET
    //    //@Path("/get_sugerencias-like")
    //   // @Produces("Application/json")
    //Metodo que busca las suscripciones del usuario, encuentra los videos a las que estas les haya dado Like y las filtra por categoria
    public String getSugerenciasLike( int id_usuario, String categoria)  { //Recuerda cambiar esto a json
        conectarDB();
        //List<Gson> lista = new List<Gson>();
        Gson gson = new Gson();
        ArrayList<Video> lista = new ArrayList<>();

        query = "SELECT * FROM public.video JOIN public.likes ON public.video.vid_id = public.likes.id_video JOIN public.suscripcion ON public.likes.id_usuario = public.suscripcion.id_suscripcion JOIN public.categoria ON public.categoria.cat_id = public.video.vid_categoria WHERE id_suscriptor = "+id_usuario+" AND public.categoria.cat_valor = '"+categoria+"' ";
        //query = "SELECT video.* FROM video";
        try{
            Statement st = conn.createStatement();
         //   st.executeUpdate(query);
            ResultSet rs = st.executeQuery(query);

            //Ciclo que va tomando los videos de la BDD y los almacena en el ArrayList
            while (rs.next()){
                Video video = new Video();
                video.setId(rs.getInt("vid_id"));
                video.setNombre(rs.getString("vid_titulo"));
                video.setDescripcion(rs.getString("vid_descripcion"));
                video.setImagen(rs.getString("vid_imagen"));
                video.setUrl(rs.getString("vid_url"));
                video.setFecha(rs.getString("vid_fecha"));
                video.setVisitas(rs.getInt("vid_visitas"));
                video.setUsuario(rs.getInt("vid_usuario"));
                video.setId_categoria(rs.getInt("vid_categoria"));
                lista.add(video);

            }
            //Transforma en Json ya que se necesita
            return gson.toJson(lista);

        }
        catch (SQLException e){
            throw new MessageException(e.getMessage(), e.getErrorCode(), "Dao.java");
        }
        catch (IOException e){
            return e.getMessage();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    //@GET
    //@Path("/get_sugerencias-suscripciones")
   // @Produces("Application/json")
    //Funcion que busca las suscripciones del usuario, y toma los videos de dichos canales basados en las preferencias del usuario
    public String getSugerenciasSuscripciones( int id_usuario,  String categoria) { //Recuerda cambiar esto a json
        conectarDB();
        // List<Gson> lista = new List<Gson>();
        Gson gson = new Gson();
        ArrayList<Video> lista = new ArrayList<>();

        query = "SELECT * FROM public.video JOIN public.suscripcion ON public.video.vid_usuario = public.suscripcion.id_suscripcion JOIN public.preferencia ON public.preferencia.id_usu = "+id_usuario+" JOIN public.categoria ON public.categoria.cat_id = public.preferencia.id_cat WHERE public.video.vid_categoria = public.categoria.cat_id AND public.categoria.cat_valor = '"+categoria+"'";
        //query= "SELECT * FROM public.video";
        try{
            Statement st = conn.createStatement();
           // st.executeUpdate(query);
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Video video = new Video();
                video.setId(rs.getInt("vid_id"));
                video.setNombre(rs.getString("vid_titulo"));
                video.setDescripcion(rs.getString("vid_descripcion"));
                video.setImagen(rs.getString("vid_imagen"));
                video.setUrl(rs.getString("vid_url"));
                video.setFecha(rs.getString("vid_fecha"));
                video.setVisitas(rs.getInt("vid_visitas"));
                video.setUsuario(rs.getInt("vid_usuario"));
                video.setCategoria(rs.getInt("vid_categoria"));
                lista.add(video);

            }
            return gson.toJson(lista);

        }
        catch (Exception e){
            return e.getMessage();
        }
    }
/*

/*
=======
>>>>>>> Develop
public abstract class Dao implements IDao
{
    private static Logger logger = LoggerFactory.getLogger( Dao.class );

    private static Connection conn = null;

    private static Connection conInstance;

    /**
     * Metodo para devolver una unica instancia de la conexion
     * @return instancia de la conexion
<<<<<<< HEAD

=======
     */
>>>>>>> Develop
    public static Connection getConInstance() {

        try {
            conInstance = getBdConnect();
<<<<<<< HEAD
        }catch (BdConnectException e){
            MessageException error = new MessageException(e, Dao.class.getSimpleName(),
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            logger.error("Error: ", error.toString());
=======
        }catch (Exception e){

>>>>>>> Develop
        }

        return conInstance;
    }

    /**
     * Metodo que realiza la conexion con la base de datos
     * @return Conexion hecha a la base de datos
     * @throws ClassNotFoundException Si la clase no es encontrada
     * @throws SQLException Problemas con sql
     * @throws Exception
     * @see Connection
     * @see Statement
<<<<<<< HEAD

    public static Connection getBdConnect() throws BdConnectException
=======
     */
    public static Connection getBdConnect()
>>>>>>> Develop
    {

        try
        {
            Class.forName( Registry.BD_CLASS_FOR_NAME );
            conn = DriverManager.getConnection( Registry.BD_URL, Registry.BD_USER, Registry.BD_PASSWORD );
        }
        catch ( ClassNotFoundException e )
        {
            logger.error( "Metodo: {} {}", "getBdConnect", e.toString() );
<<<<<<< HEAD
            throw new BdConnectException( e );
=======

>>>>>>> Develop
        }
        catch ( SQLException e )
        {
            logger.error( "Metodo: {} {}", "getBdConnect", e.toString() );
<<<<<<< HEAD
            throw new BdConnectException( e );
=======

>>>>>>> Develop
        }
        return conn;
    }

    protected static void closeConnection()
    {
        try
        {
            conn.close();
        }
        catch ( SQLException e )
        {
            logger.error( "Metodo: {} {}", "getBdConnect", e.toString() );
        }
    }
<<<<<<< HEAD
*/
=======

>>>>>>> Develop
}
