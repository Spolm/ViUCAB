package edu.ucab.desarrollo.viucab;

import edu.ucab.desarrollo.viucab.webService.*;
import edu.ucab.desarrollo.viucab.webService.M03_AdministracionVideos.*;
import edu.ucab.desarrollo.viucab.webService.M07_Etiqueta.M07_Etiqueta;
import edu.ucab.desarrollo.viucab.webService.M11_Estadistica.M11_Estadistica;

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
        h.add(M03Video.class);
        h.add(M07_Etiqueta.class);
        h.add(M11_Estadistica.class);
        return h;
    }
}
