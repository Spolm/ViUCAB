package edu.ucab.desarrollo.viucab.webService.M08_Suscripcion;


import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.*;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.WebFaulException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.GetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.GetUsuariosComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.SetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.UpdateSuscripcionComando;

import javax.ws.rs.*;
import java.util.ArrayList;

@Path("/Suscripcion")
public class M08_Suscripcion {
    Gson gson = new Gson();

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
    public String SetSuscripcion(@QueryParam("idLogueado") int idLogueado , @QueryParam("idSuscriptor") int idSuscriptor) throws BDConnectException1, PLConnectException1, WebFaulException  {

        try {
            Command comandSuscripcion = CommandsFactory.instanciaSetSuscripcionComando(idLogueado, idSuscriptor);
            SetSuscripcionComando cmd = (SetSuscripcionComando) comandSuscripcion;
            cmd.execute();
            return cmd.ObtenerRespuesta();
        }
        catch (BDConnectException1 ex)
        { ex.getMessage();
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }
        catch (PLConnectException1 ex)
        { ex.getMessage();

            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }

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
    public String UpdateSuscripcion(@QueryParam("idLogueado") int idLogueado , @QueryParam("idSuscriptor") int idSuscriptor) throws BDConnectException1, PLConnectException1, WebFaulException {

        try {

            Command comandSuscripcion = CommandsFactory.instanciaUpdateSuscripcionComando(idLogueado, idSuscriptor);
            UpdateSuscripcionComando cmd = (UpdateSuscripcionComando) comandSuscripcion;
            cmd.execute();
            System.out.println(cmd.ObtenerRespuesta());
            return cmd.ObtenerRespuesta();

        }catch (BDConnectException1 ex)
        { ex.getMessage();
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }catch (PLConnectException1 ex)
        { ex.getMessage();
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }

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
    public String GetSuscripcion(@QueryParam("id") int id) throws BDConnectException1, PLConnectException1, WebFaulException {

        try{

            Command comandSuscripcion = CommandsFactory.instanciaGetSuscripcionComando(id);

            GetSuscripcionComando cmd = (GetSuscripcionComando) comandSuscripcion;
            cmd.execute();
            ArrayList<Usuario> result = cmd.get_listUsuario(); System.out.println("RESPUESTA DE CAPA DE PRESENTACION->  "+result);


            return   gson.toJson(result);



        }catch (BDConnectException1 ex)
        {   ex.getMessage();
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }catch (PLConnectException1 ex)
        {    ex.getMessage();
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }
    }

    @GET
    @Path("/GetUsuarios")
    @Produces("application/json")
    public String GetUsuarios(@QueryParam("id") int id) throws BDConnectException1, PLConnectException1, WebFaulException {

        try{
                Command comandSuscripcion = CommandsFactory.instanciaGetUsuariosComando();
                GetUsuariosComando cmd = (GetUsuariosComando) comandSuscripcion;
                cmd.execute();
                ArrayList<Usuario> result = cmd.get_listUsuario();
                return   gson.toJson(result);



        }catch (BDConnectException1 ex)
        {    ex.getMessage();
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }catch (PLConnectException1 ex)
        { ex.getMessage();
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }
    }



}
