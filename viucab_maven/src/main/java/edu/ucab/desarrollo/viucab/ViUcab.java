package edu.ucab.desarrollo.viucab;

import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import edu.ucab.desarrollo.viucab.webService.*;
import edu.ucab.desarrollo.viucab.webService.M02_Home.M02_Home;
import edu.ucab.desarrollo.viucab.webService.M07_Etiqueta.M07_Etiqueta;
import edu.ucab.desarrollo.viucab.webService.M09_Sugerencias.M09_Sugerencias;
import edu.ucab.desarrollo.viucab.webService.M11_Estadistica.M11_Estadistica;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//Esta es la prueba
@ApplicationPath("/")
public class ViUcab extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h= new HashSet<Class<?>>();
        h.add(hola.class);
        h.add(Dao.class);
        h.add(M02_Home.class);
        h.add(M07_Etiqueta.class);
        h.add(M09_Sugerencias.class);
        h.add(M11_Estadistica.class);


        return h;
    }
}