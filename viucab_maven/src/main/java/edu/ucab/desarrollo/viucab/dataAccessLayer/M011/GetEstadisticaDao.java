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
        label[0] = "El";
        label[1] = "cable";
        label[2] = "funciona";
        label[3] = "claro que yes";
        String [] data = new String[4];
        data[0]="1";
        data[1]="2";
        data[2]="3";
        data[3]="4";
        estadistica.setData(data);
        estadistica.setLabel(label);
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
        return null;
    }

    @Override
    public Entity GetEstadistica3(Entity e) {
        return null;
    }

    @Override
    public Entity GetEstadistica4(Entity e) {
        return null;
    }

    @Override
    public Entity GetEstadistica5(Entity e) {
        return null;
    }

    @Override
    public Entity GetEstadistica6(Entity e) {
        return null;
    }

    @Override
    public Entity GetEstadistica7(Entity e) {
        return null;
    }

    @Override
    public Entity GetEstadistica8(Entity e) {
        return null;
    }

    @Override
    public Entity GetEstadistica9(Entity e) {
        return null;
    }
}
