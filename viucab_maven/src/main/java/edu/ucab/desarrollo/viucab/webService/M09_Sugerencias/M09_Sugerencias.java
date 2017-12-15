package edu.ucab.desarrollo.viucab.webService.M09_Sugerencias;

import com.google.gson.Gson;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Sql;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.sql.*;
import java.util.ArrayList;

@Path("/Sugerencias")
public class M09_Sugerencias {

    Gson gson = new Gson();
    Connection con;
}
