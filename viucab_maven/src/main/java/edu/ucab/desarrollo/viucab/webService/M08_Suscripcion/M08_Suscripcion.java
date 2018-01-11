package edu.ucab.desarrollo.viucab.webService.M08_Suscripcion;


import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.*;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.common.exceptions.WebFaulException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.GetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.GetUsuariosComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.SetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.UpdateSuscripcionComando;

import javassist.NotFoundException;
import org.apache.http.HttpStatus;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.postgresql.util.PSQLException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;

import static sun.misc.Version.println;


@Path("/Suscripcion")
public class M08_Suscripcion {
    Gson gson = new Gson();
    private static Logger logger = LoggerFactory.getLogger( M08_Suscripcion.class );
    /**
     * Metodo que me comunico con el comando : SetSuscripcionComando
     * el cual suscribe una persona al usuario logueado.
     * @param idSuscriptor
     * @param idLogueado
     * @return
     * @throws BDConnectException1
     * @throws PLConnectException1
     * @throws WebFaulException
     */
    @GET
    @Path("/SetSuscripcion")
    @Produces("text/plain")
    public Response SetSuscripcion(@QueryParam("idLogueado") int idLogueado , @QueryParam("idSuscriptor") int idSuscriptor) throws VIUCABException, WebFaulException  {
        Response.ResponseBuilder rb = Response.status(Response.Status.OK);
        try {
            Command comandSuscripcion = CommandsFactory.instanciaSetSuscripcionComando(idLogueado, idSuscriptor);
            SetSuscripcionComando cmd = (SetSuscripcionComando) comandSuscripcion;
            cmd.execute();
            cmd.ObtenerRespuesta();
            rb.entity("Insertado Exitosamente");
        }
         catch (VIUCABException ex)
        {
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }
        return rb.build();
    }

    /**
     * Metodo que me comunico con el comando : UpdateSuscripcionComando
     * el cual elimina la suscripcion del usuario logueado.
     * @param idLogueado
     * @param idSuscriptor
     * @return
     * @throws BDConnectException1
     * @throws PLConnectException1
     * @throws WebFaulException
     */
    @GET
    @Path("/UpdateSuscripcion")
    @Produces("text/plain")
    public Response UpdateSuscripcion(@QueryParam("idLogueado") int idLogueado , @QueryParam("idSuscriptor") int idSuscriptor) throws VIUCABException, WebFaulException {
        Response.ResponseBuilder rb = Response.status(Response.Status.OK);
        try {

            Command comandSuscripcion = CommandsFactory.instanciaUpdateSuscripcionComando(idLogueado, idSuscriptor);
            UpdateSuscripcionComando cmd = (UpdateSuscripcionComando) comandSuscripcion;

            cmd.execute();

             cmd.ObtenerRespuesta();
            rb.entity("Eliminado Exitosamente");
          //  if(cmd.ObtenerRespuesta()==null){throw new WebFaulException ("El valor devuelto es nulo, es posible ya haya eliminado la suscripcion"); };

        }catch (VIUCABException ex)
        {
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }
        return rb.build();
    }

    /**
     * Metodo que me comunico con el comando : UpdateSuscripcionComando
     * el cual lista las suscripciones del usuario logueado.
     * @param id
     * @return
     * @throws BDConnectException1
     * @throws PLConnectException1
     * @throws WebFaulException
     */

    @GET
    @Path("/GetSuscripcion")
    @Produces("application/json")
    public String GetSuscripcion(@QueryParam("id") int id) throws VIUCABException,  WebFaulException {

        try{

            Command comandSuscripcion = CommandsFactory.instanciaGetSuscripcionComando(id);

            GetSuscripcionComando cmd = (GetSuscripcionComando) comandSuscripcion;
            cmd.execute();
            ArrayList<Usuario> result = cmd.get_listUsuario(); System.out.println("RESPUESTA DE CAPA DE PRESENTACION->  "+result);


            return   gson.toJson(result);



        }catch (VIUCABException ex)
        {
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }
    }

    @GET
    @Path("/GetUsuarios")
    @Produces("application/json")
    public String GetUsuarios(@QueryParam("id") int id) throws VIUCABException , WebFaulException {
        Entity videoObject =null;
        try{
                Command comandSuscripcion = CommandsFactory.instanciaGetUsuariosComando(id);
                GetUsuariosComando cmd = (GetUsuariosComando) comandSuscripcion;
                cmd.execute();
                ArrayList<Usuario> result = cmd.get_listUsuario();
                return   gson.toJson(result);



        }catch (VIUCABException ex)
        {
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }

    }



}
