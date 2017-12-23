package edu.ucab.desarrollo.viucab.webService.M07_Etiqueta;

import com.google.gson.Gson;
<<<<<<< HEAD
=======
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Etiquetas;
import edu.ucab.desarrollo.viucab.common.entities.Video_Etiq;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.*;


>>>>>>> Develop
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.Etiquetas;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.Video_Etiq;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;

@Path("/Etiqueta")
public class M07_Etiqueta {
    Gson gson = new Gson();
    Connection conn = Sql.getConInstance();

    /**
     * Este metodo inserta una nueva etiqueta
     * y devuelve en un json la etiqueta insertada
=======

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("/Etiqueta")
public class M07_Etiqueta {
    Gson gson = new Gson();

    /**
     * Este metodo inserta una nueva etiqueta
     * y devuelve en un texto plano la etiqueta insertada
>>>>>>> Develop
     */

    @GET
    @Path("/insertar")
<<<<<<< HEAD
    @Produces("application/json")
    public String insertarEtiqueta(@QueryParam("valor") String valor){

        String insert="INSERT INTO ETIQUETA (ETI_VALOR) VALUES(?);";

        try{
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, valor);
            ps.executeUpdate();
            Etiquetas etiqueta = new Etiquetas(valor);
            return gson.toJson(etiqueta);
        }
        catch(SQLException e) {
            return e.getMessage();
        }
        finally {
            Sql.bdClose(conn);
        }
    }

=======
    @Produces("text/plain")
    public String insertarEtiqueta(@QueryParam("valor") String valor){
        Entity etiquetaObject = EntityFactory.insertEtiqueta(valor);
        Command commandEtiqueta = CommandsFactory.instanciateInsertEtiqueta(etiquetaObject);
        InsertarEtiqueta cmd = (InsertarEtiqueta) commandEtiqueta;
        cmd.execute();
        Entity result = cmd.Return();
        Etiquetas json = (Etiquetas) result;
        return gson.toJson(json);
    }


>>>>>>> Develop
    /**
     * Este metodo elimina una etiqueta por id y devuelve un json con el id de la etiqueta que se elimino
     */

    @GET
    @Path("/eliminar")
<<<<<<< HEAD
    @Produces("application/json")
    public String eliminarEtiqueta(@QueryParam("id") int id){

        String delete="DELETE FROM ETIQUETA WHERE ETI_ID = (?);";

        try{
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setInt(1, id);
            ps.executeUpdate();
            Etiquetas etiqueta = new Etiquetas(id);
            return gson.toJson(etiqueta);
        }
        catch(SQLException e) {
            return e.getMessage();
        }
        finally {
            Sql.bdClose(conn);
        }
    }

    /**
     * Este metodo devuelve en un json todas las etiquetas asociadas a un Id
     */

    @GET
    @Path("/consultar")
    @Produces("application/json")
    public String consultarEtiqueta(@QueryParam("id") int id){

        String select="SELECT * FROM ETIQUETA WHERE ETI_ID = (?);";

        try{
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Etiquetas etiqueta = null;
            while(rs.next()){
                int _id = rs.getInt("ETI_ID");
                String valor = rs.getString("ETI_VALOR");
                etiqueta = new Etiquetas(_id, valor);
            }
            return gson.toJson(etiqueta);
        }
        catch(SQLException e) {
            return e.getMessage();
        }
        finally {
            Sql.bdClose(conn);
        }
=======
    @Produces("text/plain")
    public String eliminarEtiqueta(@QueryParam("id") int id){
        Entity etiquetaObject = EntityFactory.eliminarEtiqueta(id);
        Command commandEtiqueta = CommandsFactory.instanciateEliminarEtiqueta(etiquetaObject);
        EliminarEtiqueta cmd = (EliminarEtiqueta) commandEtiqueta;
        cmd.execute();
        Entity result = cmd.Return();
        Etiquetas json = (Etiquetas) result;
        return gson.toJson(json);
>>>>>>> Develop
    }

    /**
     * Este metodo devuelve una lista en un json con el id de todos los videos asociados a una etiqueta
     * y el id de la etiqueta asociada
     */

    @GET
    @Path("/consultarVideos")
<<<<<<< HEAD
    @Produces("application/json")
    public String consultarVideos(@QueryParam("id") int id){

        String selectVid="SELECT V.VID_ID ID_VID, E.ETI_ID ID_ETIQ FROM VIDEO V, VIDEO_ETIQ VE, ETIQUETA E WHERE E.ETI_ID = (?) AND VE.IDVID = V.VID_ID AND VE.IDETIQ = (?);";

        try{
            PreparedStatement ps = conn.prepareStatement(selectVid);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();

            List<Video_Etiq> list = new ArrayList<Video_Etiq>();

            while(rs.next()){
                int _id = rs.getInt("ID_ETIQ");
                int _idVid = rs.getInt("ID_VID");
                Video_Etiq video_etiq = new Video_Etiq(_id, _idVid);
                list.add(video_etiq);
            }
            return gson.toJson(list);
        }
        catch(SQLException e) {
            return e.getMessage();
        }
        finally {
            Sql.bdClose(conn);
        }
=======
    @Produces("text/plain")
    public String consultarVideos(@QueryParam("id") int id){

        Entity etiquetaObject = EntityFactory.consultarVideos(id);
        Command commandEtiqueta = CommandsFactory.instanciateConsultarVideos(etiquetaObject);
        ConsultarVideos cmd = (ConsultarVideos) commandEtiqueta;
        cmd.execute();
        List<Entity> result = cmd.ReturnList();
        //List<Video_Etiq> json = new ArrayList<Video_Etiq>();
        //json.addAll((Collection<? extends Video_Etiq>) result);
        return gson.toJson(result);
>>>>>>> Develop
    }
}
