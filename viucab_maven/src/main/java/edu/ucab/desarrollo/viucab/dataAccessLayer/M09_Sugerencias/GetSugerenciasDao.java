package edu.ucab.desarrollo.viucab.dataAccessLayer.M09_Sugerencias;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.common.exceptions.*;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias.LoggerM09;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
public class GetSugerenciasDao extends Dao implements IDaoSugerencias {

    private static Logger logger = LoggerFactory.getLogger(GetSugerenciasDao.class );
    public LoggerM09 log = new LoggerM09();

    public GetSugerenciasDao(){

    }

    @Override
    public ArrayList<Entity> sugerenciasLike(Entity e)  throws VIUCABException, SQLException  {

        logger.info("Empezando sugerenciasLike", GetSugerenciasDao.class);
        log.imprimirLogger("GetSugerenciasDao", "sugerenciaslike", "INFO");

        ArrayList<Entity> lista = new ArrayList<>();
        Video video = (Video) e;
        int id_usuario = video.getId_usuario();
        String categoria = video.get_valorCategoria();
        Connection conn = null;
        String query = "SELECT * FROM public.video JOIN public.likes ON public.video.vid_id = public.likes.id_video JOIN public.suscripcion ON public.likes.id_usuario = public.suscripcion.id_suscripcion JOIN public.categoria ON public.categoria.cat_id = public.video.vid_categoria WHERE id_suscriptor = "+id_usuario+" AND public.categoria.cat_valor = '"+categoria+"' ";

        try{

            conn = getBdConnect();
            Statement st = conn.createStatement();
            // st.executeUpdate(query);
            ResultSet rs = st.executeQuery(query);

            //Ciclo que va tomando los videos de la BDD y los almacena en el ArrayList
            while (rs.next()){
                int id = rs.getInt("vid_id");
                String nombre = rs.getString("vid_titulo");
                String descripcion = rs.getString("vid_descripcion");
                String imagen = rs.getString("vid_imagen");
                String url = rs.getString("vid_url");
                String fecha = rs.getString("vid_fecha");
                int visitas = rs.getInt("vid_visitas");
                int usuario = rs.getInt("vid_usuario");
                int idcategoria = rs.getInt("vid_categoria");
                video = (Video) EntityFactory.nuevoVideo(id, nombre, descripcion, imagen, url, fecha, visitas, usuario, idcategoria);
                lista.add(video);

            }

            return lista;

        }
        catch (SQLException el) {
            logger.error("SQLException sugerenciasLike", GetSugerenciasDao.class);
            log.imprimirLogger("GetSugerenciasDao", "sugerenciassLike-SQLException", "ERROR");
            throw new MessageException(el, "GetSugerenciasDao", "getSugerenciasLike");
        }

        catch (NullPointerException en){
            logger.error("NullpointerException sugerenciasSuscripcion", GetSugerenciasDao.class);
            log.imprimirLogger("GetSugerenciasDao", "sugerenciassLike-NullPointer", "ERROR");
            throw new MessageException(en, "GetSugerenciasDao", "getSugerenciasSuscripcion");
        }

        catch (Exception _e) {
            logger.error("Metodo {} {}", "getSugerenciasLike", _e.toString());
            log.imprimirLogger("GetSugerenciasDao", "sugerenciassLike-Exception", "ERROR");
            throw new VIUCABException( _e );
        }
        finally {
            closeConnection();
        }

    }

    @Override
    public ArrayList<Entity> sugerenciasSuscripcion(Entity e) throws VIUCABException, SQLException, MessageException {

        logger.info("Empezando sugerenciasSuscripcion", GetSugerenciasDao.class);
        log.imprimirLogger("GetSugerenciasDao", "sugerenciassuscripcion", "INFO");

        ArrayList<Entity> lista = new ArrayList<>();
        Video video = (Video) e;
        int id_usuario = video.getId_usuario();
        String categoria = video.get_valorCategoria();
        Connection conn = null;
        String query = "SELECT * FROM public.video JOIN public.suscripcion ON public.video.vid_usuario = public.suscripcion.id_suscripcion JOIN public.preferencia ON public.preferencia.id_usu = "+id_usuario+" JOIN public.categoria ON public.categoria.cat_id = public.preferencia.id_cat WHERE public.video.vid_categoria = public.categoria.cat_id AND public.categoria.cat_valor = '"+categoria+"'";
        //query= "SELECT * FROM public.video";
        try{
            getBdConnect();
            Statement st = conn.createStatement();
            // st.executeUpdate(query);
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){

                int id = rs.getInt("vid_id");
                String nombre = rs.getString("vid_titulo");
                String descripcion = rs.getString("vid_descripcion");
                String imagen = rs.getString("vid_imagen");
                String url = rs.getString("vid_url");
                String fecha = rs.getString("vid_fecha");
                int visitas = rs.getInt("vid_visitas");
                int usuario = rs.getInt("vid_usuario");
                int idcategoria = rs.getInt("vid_categoria");
                video = (Video) EntityFactory.nuevoVideo(id, nombre, descripcion, imagen, url, fecha, visitas, usuario, idcategoria);
                lista.add(video);

            }
            return lista;

        } catch (SQLException el) {
            logger.error("SQLException sugerenciasLike", GetSugerenciasDao.class);
            log.imprimirLogger("GetSugerenciasDao", "sugerenciassuscripcion-SQLException", "ERROR");
            throw new MessageException(el, "GetSugerenciasDao", "getSugerenciasSuscripcion");
        }

        catch (NullPointerException en){
            logger.error("NullpointerException sugerenciasSuscripcion", GetSugerenciasDao.class);
            log.imprimirLogger("GetSugerenciasDao", "sugerenciassuscripcion-NullPointer", "ERROR");
            throw new MessageException(en, "GetSugerenciasDao", "getSugerenciasSuscripcion");
        }

        catch (Exception _e) {
            logger.error("Metodo {} {}", "getSugerenciasSuscripcion", _e.toString());
            log.imprimirLogger("GetSugerenciasDao", "sugerenciassuscripcion-Exception", "ERROR");
            throw new VIUCABException( _e, "GetSugerenciasDao", "GetSugerenciasSuscripcion" );}
            finally {
           closeConnection();
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
}
