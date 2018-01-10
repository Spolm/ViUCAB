package edu.ucab.desarrollo.viucab.webService.M04_Reproductor;

import edu.ucab.desarrollo.viucab.webService.M11_Estadistica.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Estadistica;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M04_Reproduccion.ComandoAddVisita;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M04_Reproduccion.ComandoAgregarComentario;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M04_Reproduccion.ComandoDeleteComentario;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M04_Reproduccion.ComandoGetIfLike;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M04_Reproduccion.ComandoGetVideoInfo;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M04_Reproduccion.ComandoUpdateLike;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.*;
import edu.ucab.desarrollo.viucab.webService.M02_Home.CrossOrigin;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/Reproductor")
public class M04_Reproductor {

    Gson gson = new Gson();

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/getVideoInfo")
    @Produces("application/json")
    public String getVideoInfo(@QueryParam("idvideo") String idvideo) throws Exception {
        JsonObject jsonObj;
        JsonArray listaJson;

        Command comando = CommandsFactory.instanciarComandoGetVideoInfo(Integer.parseInt(idvideo));
        ComandoGetVideoInfo cmd = (ComandoGetVideoInfo) comando;
        cmd.execute();
        JsonObject json = cmd.result;

        //agrego listas de reproduccion
        listaJson = new JsonArray();
        for (int i = 0; i < 3; i++) {
            jsonObj = new JsonObject();
            jsonObj.addProperty("id", i);
            jsonObj.addProperty("nombre", "Lista " + i);
            listaJson.add(jsonObj);
        }
        json.add("listas", listaJson);

        return gson.toJson(json);

    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/addVisita")
    @Produces("application/json")
    public String addVisitaVideo(@QueryParam("idvideo") String idvideo) {
        Command comando = CommandsFactory.instanciarComandoAddVisita(Integer.parseInt(idvideo));
        ComandoAddVisita cmd = (ComandoAddVisita) comando;
        try {
            cmd.execute();
        } catch (Exception ex) {
            Logger.getLogger(M04_Reproductor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/addComentario")
    @Produces("application/json")
    public String addComentario(@QueryParam("idvideo") String idvideo, @QueryParam("usuario") String usuario, @QueryParam("comentario") String comentario) {
        Command comando = CommandsFactory.instanciarComandoAgregarComentario(Integer.parseInt(idvideo), usuario, comentario);
        ComandoAgregarComentario cmd = (ComandoAgregarComentario) comando;
        try {
            cmd.execute();
            JsonObject jsonObj = new JsonObject();
            jsonObj.addProperty("result", cmd.result);
            return gson.toJson(jsonObj);
        } catch (Exception ex) {
            Logger.getLogger(M04_Reproductor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/updateLike")
    @Produces("application/json")
    public String updateLike(@QueryParam("idvideo") String idvideo, @QueryParam("usuario") String usuario) {
        Command comando = CommandsFactory.instanciarComandoUpdateLike(Integer.parseInt(idvideo), usuario);
        ComandoUpdateLike cmd = (ComandoUpdateLike) comando;
        try {
            cmd.execute();
            JsonObject jsonObj = new JsonObject();
            jsonObj.addProperty("result", cmd.result);
            return gson.toJson(jsonObj);
        } catch (Exception ex) {
            Logger.getLogger(M04_Reproductor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/getIfLike")
    @Produces("application/json")
    public String getIfLike(@QueryParam("idvideo") String idvideo, @QueryParam("usuario") String usuario) {
        Command comando = CommandsFactory.instanciarComandoGetIfLike(Integer.parseInt(idvideo), usuario);
        ComandoGetIfLike cmd = (ComandoGetIfLike) comando;
        try {
            cmd.execute();
            JsonObject jsonObj = new JsonObject();
            jsonObj.addProperty("result", cmd.result);
            return gson.toJson(jsonObj);
        } catch (Exception ex) {
            Logger.getLogger(M04_Reproductor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @GET
    @CrossOrigin(origins = "http://localhost:8100")
    @Path("/deleteComentario")
    @Produces("application/json")
    public String deleteComentario(@QueryParam("idcomentario") String idcomentario) {
        System.out.println("LLEGUE AL METODO CON IDCOMENTARIO = " + idcomentario);
        Command comando = CommandsFactory.instanciarComandoDeleteComentario(Integer.parseInt(idcomentario));
        ComandoDeleteComentario cmd = (ComandoDeleteComentario) comando;
        try {
            cmd.execute();
            JsonObject jsonObj = new JsonObject();
            jsonObj.addProperty("result", cmd.result);
            return gson.toJson(jsonObj);
        } catch (Exception ex) {
            Logger.getLogger(M04_Reproductor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

}
