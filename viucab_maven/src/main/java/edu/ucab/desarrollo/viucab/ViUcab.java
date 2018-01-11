package edu.ucab.desarrollo.viucab;

import edu.ucab.desarrollo.viucab.webService.*;
import edu.ucab.desarrollo.viucab.webService.M02_Home.M02_Home;
import edu.ucab.desarrollo.viucab.webService.M07_Etiqueta.M07_Etiqueta;
import edu.ucab.desarrollo.viucab.webService.M08_Suscripcion.M08_Suscripcion;
import edu.ucab.desarrollo.viucab.webService.M11_Estadistica.M11_Estadistica;
import edu.ucab.desarrollo.viucab.webService.M05_ListaDeReproduccion.M05_ListaDeReproduccion;
import edu.ucab.desarrollo.viucab.webService.M01_Login.M01_Login;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/")
public class ViUcab extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h= new HashSet<Class<?>>();
        h.add(hola.class);
        h.add(M02_Home.class);
        h.add(M07_Etiqueta.class);
        h.add(M11_Estadistica.class);
        h.add(M05_ListaDeReproduccion.class);
        h.add(M08_Suscripcion.class);
        h.add(M01_Login.class);


        return h;
    }
}