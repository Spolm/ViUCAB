package edu.ucab.desarrollo.viucab.webService.M05_ListaDeReproduccion;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.ListaDeReproduccion;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M05_ListaDeReproduccion.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/playlist")
public class M05_ListaDeReproduccion {

    Gson gson = new Gson();

    @GET
    @Path("/playlist")
    @Produces("text/plain")
    public String obtenerLista(@QueryParam("id") int idLista)
    {

        Entity listaObject = EntityFactory.listaDeReproduccion(1); //SE LE ESTA PASANDO MANUALMENTE
        Command commandGetLista = CommandsFactory.instanciaGetLista(listaObject);
        GetListaComando cmd = (GetListaComando) commandGetLista;
        cmd.execute();
        Entity result = cmd.Return();
        ListaDeReproduccion json = (ListaDeReproduccion) result;
        return gson.toJson(json);
    }



}