
        package edu.ucab.desarrollo.viucab.webService.M07_Etiqueta;

        import com.google.gson.Gson;
        import edu.ucab.desarrollo.viucab.common.entities.Entity;
        import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
        import edu.ucab.desarrollo.viucab.common.entities.Etiquetas;
        import edu.ucab.desarrollo.viucab.common.entities.Video_Etiq;
        import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
        import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
        import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.*;


        import javax.ws.rs.GET;
        import javax.ws.rs.Path;
        import javax.ws.rs.Produces;
        import javax.ws.rs.QueryParam;

        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.List;

@Path("/Etiqueta")
public class M07_Etiqueta {
    Gson gson = new Gson();

    /**
     * Este metodo inserta una nueva etiqueta
     * y devuelve en un texto plano la etiqueta insertada
     */

    @GET
    @Path("/insertar")
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


    /**
     * Este metodo elimina una etiqueta por id y devuelve un json con el id de la etiqueta que se elimino
     */

    @GET
    @Path("/eliminar")
    @Produces("text/plain")
    public String eliminarEtiqueta(@QueryParam("id") int id){
        Entity etiquetaObject = EntityFactory.eliminarEtiqueta(id);
        Command commandEtiqueta = CommandsFactory.instanciateEliminarEtiqueta(etiquetaObject);
        EliminarEtiqueta cmd = (EliminarEtiqueta) commandEtiqueta;
        cmd.execute();
        Entity result = cmd.Return();
        Etiquetas json = (Etiquetas) result;
        return gson.toJson(json);
    }

    /**
     * Este metodo devuelve una lista en un json con el id de todos los videos asociados a una etiqueta
     * y el id de la etiqueta asociada
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
        //List<Video_Etiq> json = new ArrayList<Video_Etiq>();
        //json.addAll((Collection<? extends Video_Etiq>) result);
        return gson.toJson(result);
    }
}
