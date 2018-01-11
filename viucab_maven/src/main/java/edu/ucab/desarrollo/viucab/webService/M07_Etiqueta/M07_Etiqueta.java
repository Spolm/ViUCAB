
        package edu.ucab.desarrollo.viucab.webService.M07_Etiqueta;

        import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Etiquetas;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.ConsultarVideos;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.EliminarEtiqueta;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.InsertarEtiqueta;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/Etiqueta")
public class M07_Etiqueta {
    Gson gson = new Gson();

    /**
     * Este metodo inserta una nueva etiqueta relacionandola a un video
     * si la etiqueta ya existe no se inserta en la tabla etiqueta pero si en video_etiq
     * y devuelve en un texto plano la etiqueta insertada
     */

    @GET
    @Path("/insertar")
    @Produces("text/plain")
    public String insertarEtiqueta(@QueryParam("valor") String valor, @QueryParam("id") int id){
        Entity etiquetaObject = EntityFactory.insertEtiqueta(valor, id);
        Command commandEtiqueta = CommandsFactory.instanciateInsertEtiqueta(etiquetaObject);
        InsertarEtiqueta cmd = (InsertarEtiqueta) commandEtiqueta;
        cmd.execute();
        Entity result = cmd.Return();
        Etiquetas json = (Etiquetas) result;
        return gson.toJson(json);
    }


    /**
     * Este metodo elimina la etiqueta de un video
     */

    @GET
    @Path("/eliminar")
    @Produces("text/plain")
    public String eliminarEtiqueta(@QueryParam("id") int id, @QueryParam("valor") String valor){
        Entity etiquetaObject = EntityFactory.eliminarEtiqueta(id, valor);
        Command commandEtiqueta = CommandsFactory.instanciateEliminarEtiqueta(etiquetaObject);
        EliminarEtiqueta cmd = (EliminarEtiqueta) commandEtiqueta;
        cmd.execute();
        Entity result = cmd.Return();
        Etiquetas json = (Etiquetas) result;
        return gson.toJson(json);
    }

    /**
     * Este metodo devuelve una lista con todas las etiquetas de un video
     */

    @GET
    @Path("/consultarVideos")
    @Produces("text/plain")
    public String consultarVideos(@QueryParam("id") int id){

        Entity etiquetaObject = EntityFactory.consultarVideos(id);
        Command commandEtiqueta = CommandsFactory.instanciateConsultarVideos(etiquetaObject);
        ConsultarVideos cmd = (ConsultarVideos) commandEtiqueta;
        cmd.execute();
        List<Entity> result = cmd.ReturnList();
        return gson.toJson(result);
    }
}
