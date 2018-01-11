package edu.ucab.desarrollo.viucab.dataAccessLayer.M12_ModeracionContenido;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.sql.*;
import java.util.ArrayList;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Filtro;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Pablo, Jose and Karem on 07/01/2018.
 */
public class GetModeracionContenidoDao extends Dao implements IDaoModeracionContenido {
    private static Logger logger = LoggerFactory.getLogger(GetModeracionContenidoDao.class);
    public GetModeracionContenidoDao(){

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


    /**
     * Metodo que busca los filtros por un id de Usuario
     * @param id
     * @return lista de filtros
     * @throws SQLException
     */
    public ArrayList<Filtro> buscarFiltros(Integer id) throws SQLException,VIUCABException{

        ArrayList<Filtro> listaFiltros= new ArrayList<>();
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Filtro resultado;


        try{
            //Instanciando conexion
            conn=getBdConnect();
            //Query para base de datos
            String query = "SELECT * FROM FILTRO, USU_FIL WHERE FILTRO.FIL_ID=USU_FIL.ID_FIL AND USU_FIL.ID_USU="+Integer.toString(id);
            //Instanciando el ps
            ps = conn.prepareStatement(query);
            // Ejecutando el quey y guardando el resultado del query en rs
            rs = ps.executeQuery();

            //Convirtiendo la busqueda en objetos Filtros mediante EntityFactory
            while(rs.next()){

                resultado = (Filtro) EntityFactory.filtro(rs.getInt("fil_id"),rs.getString("fil_tipo"),
                        rs.getString("fil_descripcion"));
                //Añadiendo los filtros a la lista
                listaFiltros.add(resultado);
            }
            rs.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            logger.error( "Metodo: {} {}", "buscarFiltros", e.toString() );
            throw new VIUCABException( e );
        }
        finally {
            Sql.bdClose(conn);
        }
        //Retornando lista de filtros
        return listaFiltros;
    }


    /**
     * Obtiene de la base de datos en funcion del id del usuario, la contraseña correcta del Usuario,
     * y la compara con el password entrante, validando si es correcto o no ese password con el de la base de datos
     * @param id de Usuario
     * @param password ingresado
     * @return true o false
     * @throws SQLException
     */
    public boolean compararPassword(Integer id, String password) throws SQLException, VIUCABException {
        //Instanciando conexion
        Connection conn= Sql.getConInstance();
        //Variable de control
        boolean acceso = false;
        //Query para base de datos
        String query = "SELECT USU_CLAVE FROM  USUARIO WHERE USU_ID=" + id;

        try {
            //Instanciando el ps
            PreparedStatement ps = conn.prepareStatement(query);
            // Creando el rs y ejecutando el quey, y guardando el resultado del query en rs
            ResultSet rs = ps.executeQuery();

            //Comparando password
            while (rs.next()) {
                if ((rs.getString("usu_clave")).equals(password)) {
                    acceso = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            logger.error( "Metodo: {} {}", "compararPassword", e.toString() );
            throw new VIUCABException( e );
        }finally {
            Sql.bdClose(conn);
        }

        // Retorno de la validación
        return acceso;
    }


    /**
     * Obtiene de la base de datos en funcion del id del usuario,
     * una lista de videos permitidos que cumplan con los filtros de ese usuario y de las preferencias de el mismo
     * @param idd de Usuario
     * @return lista de videos permitidos
     * @throws SQLException
     */
    public ArrayList<Video> buscarVideosPermitidos(Integer idd) throws SQLException, VIUCABException {
        ArrayList<Video> listaVideos=new ArrayList<>();

        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String id = Integer.toString(idd);
        //Query para base de datos
        String query ="SELECT VIDEO.* FROM VIDEO "+
                "WHERE VIDEO.VID_ID NOT IN (SELECT DISTINCT VIDEO.VID_ID FROM VIDEO, USUARIO, FILTRO, CAT_FIL_ETIQ, CATEGORIA, VIDEO_CAT, ETIQUETA, VIDEO_ETIQ, USU_FIL "+
                "WHERE USUARIO.USU_ID="+id+" AND USU_FIL.ID_USU=USUARIO.USU_ID AND "+
                "USU_FIL.ID_FIL=FILTRO.FIL_ID AND FILTRO.FIL_ID=CAT_FIL_ETIQ.ID_FIL AND "+
                "((CAT_FIL_ETIQ.ID_CAT=CATEGORIA.CAT_ID AND CATEGORIA.CAT_ID=VIDEO_CAT.IDCAT AND VIDEO_CAT.IDVID=VIDEO.VID_ID) "+
                "OR (CAT_FIL_ETIQ.ID_ETIQ=ETIQUETA.ETI_ID AND VIDEO_ETIQ.IDETIQ=ETIQUETA.ETI_ID AND VIDEO.VID_ID=VIDEO_ETIQ.IDVID))) "+
                "AND "+
                "VIDEO.VID_ID IN (SELECT VIDEO.VID_ID FROM VIDEO, VIDEO_CAT, CATEGORIA, PREFERENCIA "+
                "WHERE PREFERENCIA.ID_USU="+id+" AND CATEGORIA.CAT_ID=PREFERENCIA.ID_CAT "+
                "AND VIDEO_CAT.IDCAT=CATEGORIA.CAT_ID AND VIDEO.VID_ID=VIDEO_CAT.IDVID)";

        try{
            //Instanciando conexion
            conn = getBdConnect();
            //Instanciando el ps
            ps = conn.prepareStatement(query);
            // Ejecutando el quey y guardando el resultado del query en rs
            rs = ps.executeQuery();

            //Convirtiendo la busqueda en objetos Video mediante EntityFactory
            while(rs.next()){
                Video resultado = (Video) EntityFactory.video(rs.getInt("vid_id"),rs.getString("vid_titulo"),
                        rs.getString("vid_descripcion"),rs.getString("vid_imagen"),rs.getString("vid_url"),
                        rs.getDate("vid_fecha"),rs.getInt("vid_visitas"),rs.getInt("vid_usuario"));

                listaVideos.add(resultado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            logger.error( "Metodo: {} {}", "buscarVideosPermitidos", e.toString() );
            throw new VIUCABException( e );
        }finally {
            Sql.bdClose(conn);
        }

        // Retorno la lista de videos permitidos
        return listaVideos;
    }



    /**
     * Obtiene de la base de datos en funcion del id del usuario, los videos permitidos para él,
     * se comparan con la lista del parametro, quedando solo los videos permitidos del Usuario de la lista entrante por parámetro
     * @param idd de Usuario
     * @param listaVideos que se quiere filtrar
     * @return lista de videos filtrada, segun los videos permitidos del Usuario
     * @throws SQLException
     */
    public ArrayList<Video> buscarYFiltrarVideos(Integer idd,  ArrayList<Video> listaVideos) throws SQLException,VIUCABException{
        ArrayList<Video> listaVideosPermitidos=new ArrayList<>();
        ArrayList<Video> listaVideosFiltrados= new ArrayList<>();
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String id = Integer.toString(idd);

        //Query para base de datos
        String query ="SELECT DISTINCT VIDEO.* FROM VIDEO "+
                "WHERE VIDEO.VID_ID NOT IN (SELECT DISTINCT VIDEO.VID_ID FROM VIDEO, USUARIO, FILTRO, CAT_FIL_ETIQ, CATEGORIA, VIDEO_CAT, ETIQUETA, VIDEO_ETIQ, USU_FIL "+
                "WHERE USUARIO.USU_ID="+id+" AND USU_FIL.ID_USU=USUARIO.USU_ID AND "+
                "USU_FIL.ID_FIL=FILTRO.FIL_ID AND FILTRO.FIL_ID=CAT_FIL_ETIQ.ID_FIL AND "+
                "((CAT_FIL_ETIQ.ID_CAT=CATEGORIA.CAT_ID AND CATEGORIA.CAT_ID=VIDEO_CAT.IDCAT AND VIDEO_CAT.IDVID=VIDEO.VID_ID) "+
                "OR (CAT_FIL_ETIQ.ID_ETIQ=ETIQUETA.ETI_ID AND VIDEO_ETIQ.IDETIQ=ETIQUETA.ETI_ID AND VIDEO.VID_ID=VIDEO_ETIQ.IDVID))) "+
                "AND "+
                "VIDEO.VID_ID IN (SELECT DISTINCT VIDEO.VID_ID FROM VIDEO, VIDEO_CAT, CATEGORIA, PREFERENCIA "+
                "WHERE PREFERENCIA.ID_USU="+id+" AND CATEGORIA.CAT_ID=PREFERENCIA.ID_CAT "+
                "AND VIDEO_CAT.IDCAT=CATEGORIA.CAT_ID AND VIDEO.VID_ID=VIDEO_CAT.IDVID)";
        try{
            //Instanciando conexion
            conn = getBdConnect();
            //Instanciando el ps
            ps = conn.prepareStatement(query);
            // Ejecutando el quey y guardando el resultado del query en rs
            rs = ps.executeQuery();

            //Convirtiendo la busqueda en objetos Video mediante EntityFactory
            while(rs.next()){
                Video resultado = (Video) EntityFactory.video(rs.getInt("vid_id"),rs.getString("vid_titulo"),
                        rs.getString("vid_descripcion"),rs.getString("vid_imagen"),rs.getString("vid_url"),
                        rs.getDate("vid_fecha"),rs.getInt("vid_visitas"),rs.getInt("vid_usuario"));
                listaVideosPermitidos.add(resultado);
            }

            // Clasificando los videos permitidos de los que llegaron
            for( int i = 0 ; i < listaVideos.size() ; i++ ){
                if (listaVideosPermitidos.contains(listaVideos.get(i))) {
                    listaVideosFiltrados.add(listaVideos.get(i));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            logger.error( "Metodo: {} {}", "buscarYFiltrarVideos", e.toString() );
            throw new VIUCABException( e );
        }finally {
            Sql.bdClose(conn);
        }

        // Retorno la lista de videos permitidos
        return listaVideosFiltrados;
    }




    /**
     * Almacena en la base de datos para el id de Usuario, una lista de filtros que fue seleccionada desde la app
     * @param id de Usuario
     * @param listaFiltros a almacenar en la base de datos
     * @return true o false
     * @throws SQLException
     */
    public String guardarFiltrosEnBD(Integer id,  ArrayList<Filtro> listaFiltros) throws SQLException, VIUCABException {
        ArrayList<Filtro> listaFiltrosNuevos= new ArrayList<>();
        ArrayList<Filtro> listaFiltrosBD= new ArrayList<>();
        ArrayList<Integer> listaInsertsBD= new ArrayList<>();
        ArrayList<Integer> listaDeleteBD= new ArrayList<>();
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        boolean estado=false;

        //Identifica cuales son los filtros marcados por el usuario en la app
        for (int i=0;i<listaFiltros.size(); i++){
            if (listaFiltros.get(i).isValor()==true){listaFiltrosNuevos.add(listaFiltros.get(i));}
        }

        try{
            //Query para base de datos
            String query ="SELECT FILTRO.* FROM FILTRO, USU_FIL WHERE USU_FIL.ID_USU="+id+" AND USU_FIL.ID_FIL=FILTRO.FIL_ID";
            //Instanciando conexion
            conn = getBdConnect();
            //Instanciando el ps
            ps = conn.prepareStatement(query);
            // Ejecutando el quey y guardando el resultado del query en rs
            rs = ps.executeQuery();

            //Convirtiendo la busqueda en objetos Filtros mediante EntityFactory
            while(rs.next()){
                Filtro resultado = (Filtro) EntityFactory.filtro(rs.getInt("fil_id"),rs.getString("fil_tipo"),
                        rs.getString("fil_descripcion"));
                listaFiltrosBD.add(resultado);
            }

            //Clasificando y formando la lista de los filtros que se van a insertar de la base de datos
            for( int i = 0 ; i < listaFiltrosNuevos.size() ; i++ ){
                if (!(listaFiltrosBD.contains(listaFiltrosNuevos.get(i)))) {
                    listaInsertsBD.add(listaFiltrosNuevos.get(i).getId());
                }
            }

            //Clasificando y formando la lista de los filtros que se van a eliminar de la base de datos
            for( int i = 0 ; i < listaFiltrosBD.size() ; i++ ){
                if (!(listaFiltrosNuevos.contains(listaFiltrosBD.get(i)))) {
                    listaDeleteBD.add(listaFiltrosBD.get(i).getId());
                }
            }

            //Eliminando los filtros no marcados en la app

            conn.close();
            ps=null;
            conn=getBdConnect();
            for( int i = 0 ; i < listaDeleteBD.size() ; i++ ){
                String transDelete="DELETE FROM USU_FIL WHERE ID_USU="+Integer.toString(id)+" AND ID_FIL="+Integer.toString(listaDeleteBD.get(i));
                ps = conn.prepareStatement(transDelete);
                ps.executeUpdate();
            }
            conn.close();
            ps=null;
            conn=getBdConnect();
            //Insertando solo los filtros nuevos que no estaban en BD
            for( int i = 0 ; i < listaInsertsBD.size() ; i++ ){
                String transInserts="INSERT INTO USU_FIL(ID_USU,ID_FIL) VALUES ("+Integer.toString(id)+","+listaInsertsBD.get(i)+")";
                ps = conn.prepareStatement(transInserts);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            return "error"+e.getMessage();
        } catch (Exception e){
            logger.error("Metodo: {} {}","guardarFiltrosEnBD",e.toString());
            throw  new VIUCABException(e);

        } finally{
            Sql.bdClose(conn);
        }
Gson g = new Gson();

        return (g.toJson(listaDeleteBD));
    }


}
