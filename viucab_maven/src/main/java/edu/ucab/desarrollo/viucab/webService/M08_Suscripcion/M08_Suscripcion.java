package edu.ucab.desarrollo.viucab.webService.M08_Suscripcion;


import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.*;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.PlConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.WebFaulException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.GetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.SetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.UpdateSuscripcionComando;

import javax.ws.rs.*;
import javax.xml.ws.WebFault;
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
     * @throws BdConnectException
     * @throws PlConnectException
     * @throws WebFaulException
     */
    @GET
    @Path("/SetSuscripcion")
    @Produces("text/plain")
    public String SetSuscripcion(@QueryParam("idLogueado") int idLogueado , @QueryParam("idSuscriptor") int idSuscriptor) throws BdConnectException, PlConnectException, WebFaulException  {

        try {
            Command comandSuscripcion = CommandsFactory.instanciaSetSuscripcionComando(idLogueado, idSuscriptor);
            SetSuscripcionComando cmd = (SetSuscripcionComando) comandSuscripcion;
            cmd.execute();
        }
        catch (BdConnectException ex)
        {
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }
        catch (PlConnectException ex)
        {
            /*
            catch (ViUCABException e) {

           throw new WebFault(e.Mensaje, e.codigo);
        } */
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }


   //     Entity suscripcionObject = EntityFactory.suscripcion(1, id);
   //     Command comandSuscripcion = CommandsFactory.instanciaSetSuscripcionComando(suscripcionObject);
    //    SetSuscripcionComando cmd = (SetSuscripcionComando) comandSuscripcion;
      //  cmd.execute();
     //   Entity result = cmd.Return();
      //  Suscripcion json = (Suscripcion) result;
        return "LO INSERTO EXITOSAMENTE";


    }

    /**
     * Metodo que me comunico con el comando : UpdateSuscripcionComando
     * el cual elimina la suscripcion del usuario logueado.
     * @param idLogueado
     * @param idSuscriptor
     * @return
     * @throws BdConnectException
     * @throws PlConnectException
     * @throws WebFaulException
     */
    @DELETE
    @Path("/UpdateSuscripcion")
    @Produces("application/json")
    public String UpdateSuscripcion(@QueryParam("idLogueado") int idLogueado , @QueryParam("idSuscriptor") int idSuscriptor) throws BdConnectException, PlConnectException, WebFaulException {

        try {

            Command comandSuscripcion = CommandsFactory.instanciaUpdateSuscripcionComando(idLogueado, idSuscriptor);
            UpdateSuscripcionComando cmd = (UpdateSuscripcionComando) comandSuscripcion;
            cmd.execute();

            return "LO ELIMINO EXITOSAMENTE";

        }catch (BdConnectException ex)
        {
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }catch (PlConnectException ex)
        {
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }

    }

    /**
     * Metodo que me comunico con el comando : UpdateSuscripcionComando
     * el cual lista las suscripciones del usuario logueado.
     * @param id
     * @return
     * @throws BdConnectException
     * @throws PlConnectException
     * @throws WebFaulException
     */

    @GET
    @Path("/GetSuscripcion")
    @Produces("application/json")
    public String GetSuscripcion(@QueryParam("id") int id) throws BdConnectException, PlConnectException, WebFaulException {

        try{

            Command comandSuscripcion = CommandsFactory.instanciaGetSuscripcionComando(id);

            GetSuscripcionComando cmd = (GetSuscripcionComando) comandSuscripcion;
            cmd.execute();
            ArrayList<Usuario> result = cmd.get_listUsuario(); System.out.println("RESPUESTA DE CAPA DE PRESENTACION->  "+result);


            return   gson.toJson(result);



        }catch (BdConnectException ex)
        {   ex.printStackTrace();
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }catch (PlConnectException ex)
        {
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }




    }



}
