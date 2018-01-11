package edu.ucab.desarrollo.viucab.common.exceptions;

import com.sun.jersey.core.spi.factory.ResponseImpl;

import javax.ws.rs.core.Response;
import javax.xml.ws.WebFault;

/**
 * creada por M08
 */
@WebFault(name="SimpleException")
public class PLConnectException1 extends Exception {

    public final String ERROR_MSG = "Ha ocurrido un error el  Store Procedure que conecta con la Base de datos " +
            "Revise que este bien escrito el Store Procedure";



    public  PLConnectException1(Exception e)
    {
        super(e+"   Ha ocurrido un error el  Store Procedure que conecta con la Base de datos Revise que este bien escrito el Store Procedure");
        System.out.println(ERROR_MSG+e);

     //  return Response.status(Response.Status.NOT_FOUND).entity(e+" Ha ocurrido un error el  Store Procedure que conecta con la Base de datos \" +\n" +
       //         "            \"Revise que este bien escrito el Store Procedure").build();
       // System.out.println(ERROR_MSG+e);
    }



}
