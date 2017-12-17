package edu.ucab.desarrollo.viucab.dataAccessLayer.M011;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Estadistica;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;

import java.sql.SQLException;

/**
 * Created by Daniel on 25/11/2017.
 */
public class GetEstadisticaDao extends Dao implements IDaoEstadistica{
    public GetEstadisticaDao() {

    }

    @Override
    public Entity create(Entity e) {
        return null;
    }

    @Override
    public Entity read(Entity e) {
        return null;
    }

    @Override
    public Entity update(Entity e) {
        return null;
    }

    @Override
    public Entity GetEstadistica1(Entity e) throws SQLException {
        Estadistica estadistica = (Estadistica) e;

        String [] label = new String[4];
        label[0] = "Farandula";
        label[1] = "Bachata";
        label[2] = "Pegala al Piso";
        label[3] = "Cableadores ";
        String [] data = new String[4];
        data[0]="2";
        data[1]="5";
        data[2]="2";
        data[3]="8";
        estadistica.setData(data);
        estadistica.setLabel(label);
        estadistica.setNombre("Etiquetas más utilizadas");
    /*
        //castean el objeto a su objeto y lo usan como quieran , para sacar los datos de la consulta


       // llaman la con aqui
        Connection conn = Dao.getBdConnect();


        CallableStatement stm = conn.prepareCall("{? = Call nombredelprocedimiento() }");
        // PreparedStatement stm = conn.prepareStatement(query);

       // cada st son los valores que se envian por el metodo tienen que coincidir los tipos de datos
        //con lo que pusieron en el procedimiento

        stm.setString(1, "cualquier vaina");


        ResultSet rs = stm.executeQuery();
        String a = "";
        while(rs.next()){

           a = rs.getString("nombre columna que devuelve");
        }

        //aqui recojes todos los datos de la consulta y luego llamas al factory creas tu objeto y lo dvuelves

*/


        return estadistica;


    }

    @Override
    public Entity GetEstadistica2(Entity e) {
        Estadistica estadistica = (Estadistica) e;

        String [] label = new String[4];
        label[0] = "Como Hacer un Ws";
        label[1] = "Como funciona ionic";
        label[2] = "como hacer una bomba";
        label[3] = "Cableadores 2.0 ";
        String [] data = new String[4];
        data[0]="100";
        data[1]="500";
        data[2]="400";
        data[3]="700";
        estadistica.setData(data);
        estadistica.setLabel(label);
        estadistica.setNombre("Videos con más likes");
        return estadistica;
    }

    @Override
    public Entity GetEstadistica3(Entity e) {
        Estadistica estadistica = (Estadistica) e;

        String [] label = new String[4];
        label[0] = "Como Hacer un Ws";
        label[1] = "Como funciona ionic";
        label[2] = "como hacer una bomba";
        label[3] = "Cableadores 2.0 ";
        String [] data = new String[4];
        data[0]="1340";
        data[1]="500";
        data[2]="900";
        data[3]="1800";
        estadistica.setData(data);
        estadistica.setLabel(label);
        estadistica.setNombre("videos  más Vistos");

        return estadistica;
    }

    @Override
    public Entity GetEstadistica4(Entity e) {
        Estadistica estadistica = (Estadistica) e;

        String [] label = new String[4];
        label[0] = "Arabe";
        label[1] = "Pepe";
        label[2] = "Rivetti";
        label[3] = "Binladen";
        String [] data = new String[4];
        data[0]="5";
        data[1]="2";
        data[2]="1";
        data[3]="1";
        estadistica.setData(data);
        estadistica.setLabel(label);
        estadistica.setNombre("Usuarios con mas Videos");


        return estadistica;
    }

    @Override
    public Entity GetEstadistica5(Entity e) {
        Estadistica estadistica = (Estadistica) e;

        String [] label = new String[0];

        String [] data = new String[0];

        estadistica.setData(data);
        estadistica.setLabel(label);
        estadistica.setNombre("Usuarios con mas Videos");


        return estadistica;
    }

    @Override
    public Entity GetEstadistica6(Entity e) {
        Estadistica estadistica = (Estadistica) e;

        String [] label = new String[0];

        String [] data = new String[0];

        estadistica.setData(data);
        estadistica.setLabel(label);
        estadistica.setNombre("U");


        return estadistica;
    }



    @Override
    public Entity GetEstadistica7(Entity e) {
        Estadistica estadistica = (Estadistica) e;

        String [] label = new String[4];
        label[0] = "Enero";
        label[1] = "Febrero";
        label[2] = "Marzo";
        label[3] = "Abril";
        String [] data = new String[4];
        data[0]="200";
        data[1]="300";
        data[2]="100";
        data[3]="200";
        estadistica.setData(data);
        estadistica.setLabel(label);
        estadistica.setNombre("Usuarios con mas Videos");
        return estadistica;

    }

    @Override
    public Entity GetEstadistica8(Entity e) {
        Estadistica estadistica = (Estadistica) e;

        String [] label = new String[4];
        label[0] = "Como Hacer un Ws";
        label[1] = "Como funciona ionic";
        label[2] = "como hacer una bomba";
        label[3] = "Cableadores 2.0 ";
        String [] data = new String[4];
        data[0]="3";
        data[1]="2";
        data[2]="4";
        data[3]="1";
        estadistica.setData(data);
        estadistica.setLabel(label);
        estadistica.setNombre(" Videos y Sus  Categorias");
        return estadistica;
    }

    @Override
    public Entity GetEstadistica9(Entity e) {
        Estadistica estadistica = (Estadistica) e;

        String [] label = new String[4];
        label[0] = "Como Hacer un Ws";
        label[1] = "Como funciona ionic";
        label[2] = "como hacer una bomba";
        label[3] = "Cableadores 2.0 ";
        String [] data = new String[4];
        data[0]="750";
        data[1]="600";
        data[2]="400";
        data[3]="1500";
        estadistica.setData(data);
        estadistica.setLabel(label);
        estadistica.setNombre(" Videos y Sus  Comentarios");

        return estadistica;
    }
}
