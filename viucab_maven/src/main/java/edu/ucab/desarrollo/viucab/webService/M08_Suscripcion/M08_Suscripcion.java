package edu.ucab.desarrollo.viucab.webService.M08_Suscripcion;


import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.*;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.BdConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.PlConnectException;
import edu.ucab.desarrollo.viucab.common.exceptions.M08.WebFaulException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.SetSuscripcionComando;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M08.UpdateSuscripcionComando;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.ws.WebFault;
import java.util.ArrayList;

@Path("/Suscripcion")
public class M08_Suscripcion {
    Gson gson = new Gson();

    @GET
    @Path("/SetSuscripcion")
    @Produces("text/plain")
    public String SetSuscripcion(@QueryParam("id") int id) throws BdConnectException, PlConnectException, WebFaulException  {

        try {
            Command comandSuscripcion = CommandsFactory.instanciaSetSuscripcionComando(1, id); //cable para insertar en el usuario 1, una suscripcion de otro usuario(id)
            SetSuscripcionComando cmd = (SetSuscripcionComando) comandSuscripcion;
            cmd.execute();
        }
        catch (BdConnectException ex)
        {
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }
        catch (PlConnectException ex)
        {
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

    @GET
    @Path("/UpdateSuscripcion")
    @Produces("text/plain")
    public String UpdateSuscripcion(@QueryParam("id") int id) throws BdConnectException, PlConnectException, WebFaulException {

        try {

            Command comandSuscripcion = CommandsFactory.instanciaUpdateSuscripcionComando(1, id); //cable para eliminar en el usuario 1, una suscripcion de otro usuario(id)
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
/*
    @GET
    @Path("/GetSuscripcion")
    @Produces("text/plain")
    public String GetSuscripcion(@QueryParam("id") int id) throws BdConnectException, PlConnectException, WebFaulException {

        try{
       // Command comandSuscripcion = CommandsFactory.instanciaGetSuscripcionComando();
      //  GetSuscripcionComando cmd = (GetSuscripcionComando) comandSuscripcion;
       //     return cmd.execute();  //Este execute deberia devolver la lista de suscripciones

      //  ArrayList<Usuario> result = cmd.get_listVideo();


      // return gson.toJson(result);

        return null;
        }catch (BdConnectException ex)
        {
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }catch (PlConnectException ex)
        {
            throw new WebFaulException(ex.getMessage()); //recibe errores http error 500
        }




    }
 */


}
