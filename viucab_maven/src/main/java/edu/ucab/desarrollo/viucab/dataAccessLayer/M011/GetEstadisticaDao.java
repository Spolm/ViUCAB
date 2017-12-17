package edu.ucab.desarrollo.viucab.dataAccessLayer.M011;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Estadistica;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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

    /***
     * metodo que consume a la base de datos los valores
     * @param e
     * @return
     * @throws SQLException
     */
    @Override
    public Entity GetEstadistica1(Entity e) throws SQLException {
        Estadistica estadistica = (Estadistica) e;


       // llaman la con aqui
        Connection conn = Dao.getBdConnect();

        CallableStatement stm = conn.prepareCall("{? = Call M11_ESTADISTICA1() }");

        stm.setInt(1, 1);

        ResultSet rs = stm.executeQuery();
        String a = "";
        int b =0;
        if (rs.wasNull() )
        {
        while(rs.next()){

           a = rs.getString("dato");
           b = rs.getInt("numero");
        }




        }
        else
        {
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

        }
        estadistica.setNombre("Etiquetas más utilizadas");

        return estadistica;


    }

    /***
     *  metodo que consume a la base de datos los valores
     * @param e
     * @return
     * @throws SQLException
     */
    @Override
    public Entity GetEstadistica2(Entity e) throws SQLException {



        Estadistica estadistica = (Estadistica) e;


        // llaman la con aqui
        Connection conn = Dao.getBdConnect();

        CallableStatement stm = conn.prepareCall("{? = Call M11_ESTADISTICA2() }");

        stm.setInt(1, 1);

        ResultSet rs = stm.executeQuery();
        String a = "";
        int b =0;
        if (rs.wasNull() )
        {
            while(rs.next()){

                a = rs.getString("dato");
                b = rs.getInt("numero");
            }




        }
        else
        {
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


        }
        estadistica.setNombre("Videos con más likes");

        return estadistica;

    }

    /***
     *  metodo que consume a la base de datos los valores
     * @param e
     * @return
     * @throws SQLException
     */
    @Override
    public Entity GetEstadistica3(Entity e) throws SQLException {





        Estadistica estadistica = (Estadistica) e;


        // llaman la con aqui
        Connection conn = Dao.getBdConnect();

        CallableStatement stm = conn.prepareCall("{? = Call M11_ESTADISTICA3() }");

        stm.setInt(1, 1);

        ResultSet rs = stm.executeQuery();
        String a = "";
        String b ="";
        if (rs.wasNull() )
        {
            while(rs.next()){

                a = rs.getString("dat");
                b = rs.getString("dato");
            }




        }
        else
        {
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


        }
        estadistica.setNombre("videos  más Vistos");

        return estadistica;






    }

    /***
     *  metodo que consume a la base de datos los valores
     * @param e
     * @return
     * @throws SQLException
     */
    @Override
    public Entity GetEstadistica4(Entity e) throws SQLException {
        Estadistica estadistica = (Estadistica) e;




        // llaman la con aqui
        Connection conn = Dao.getBdConnect();

        CallableStatement stm = conn.prepareCall("{? = Call M11_ESTADISTICA4() }");

        stm.setInt(1, 1);

        ResultSet rs = stm.executeQuery();
        int a = 0;
        String b ="";
        if (rs.wasNull() )
        {
            while(rs.next()){

                a = rs.getInt("numero");
                b = rs.getString("dato");
            }




        }
        else
        {
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




        }
        estadistica.setNombre("Usuarios con mas Videos");

        return estadistica;



    }

    /***
     *  metodo que consume a la base de datos los valores
     * @param e
     * @return
     * @throws SQLException
     */
    @Override
    public Entity GetEstadistica5(Entity e) throws SQLException {
        Estadistica estadistica = (Estadistica) e;




        // llaman la con aqui
        Connection conn = Dao.getBdConnect();

        CallableStatement stm = conn.prepareCall("{? = Call M11_ESTADISTICA56() }");

        stm.setInt(1, 1);

        ResultSet rs = stm.executeQuery();
        int a = 0;
        String b ="";
        if (rs.wasNull() )
        {
            while(rs.next()){

                a = rs.getInt("numero");
                b = rs.getString("dato");
            }




        }
        else
        {
            String [] label = new String[4];
            label[0] = "Enero";
            label[1] = "Febrero";
            label[2] = "Marzo";
            label[3] = "Abril";
            String [] data = new String[4];
            data[0]="20";
            data[1]="5";
            data[2]="1";
            data[3]="6";
            estadistica.setData(data);
            estadistica.setLabel(label);





        }
        estadistica.setNombre("Personas Seguidas ");

        return estadistica;

    }

    /***
     *  metodo que consume a la base de datos los valores
     * @param e
     * @return
     * @throws SQLException
     */
    @Override
    public Entity GetEstadistica6(Entity e) throws SQLException {
        Estadistica estadistica = (Estadistica) e;




        // llaman la con aqui
        Connection conn = Dao.getBdConnect();

        CallableStatement stm = conn.prepareCall("{? = Call M11_ESTADISTICA56() }");

        stm.setInt(1, 1);

        ResultSet rs = stm.executeQuery();
        int a = 0;
        String b ="";
        if (rs.wasNull() )
        {
            while(rs.next()){

                a = rs.getInt("numero");
                b = rs.getString("dato");
            }




        }
        else
        {
            String [] label = new String[4];
            label[0] = "Enero";
            label[1] = "Febrero";
            label[2] = "Marzo";
            label[3] = "Abril";
            String [] data = new String[4];
            data[0]="30";
            data[1]="15";
            data[2]="14";
            data[3]="32";
            estadistica.setData(data);
            estadistica.setLabel(label);





        }
        estadistica.setNombre("Personas que te Siguieron ");

        return estadistica;

    }


    /***
     *  metodo que consume a la base de datos los valores
     * @param e
     * @return
     * @throws SQLException
     */
    @Override
      public Entity GetEstadistica7(Entity e) throws SQLException {


        Estadistica estadistica = (Estadistica) e;




        // llaman la con aqui
        Connection conn = Dao.getBdConnect();

        CallableStatement stm = conn.prepareCall("{? = Call M11_ESTADISTICA7() }");

        stm.setInt(1, 1);

        ResultSet rs = stm.executeQuery();
        int a = 0;
        String b ="";
        if (rs.wasNull() )
        {
            while(rs.next()){

                a = rs.getInt("numero");
                b = rs.getString("dato");
            }




        }
        else
        {
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




        }


        return estadistica;

    }

    /***
     *  metodo que consume a la base de datos los valores
     * @param e
     * @return
     * @throws SQLException
     */
    @Override
    public Entity GetEstadistica8(Entity e) throws SQLException {
        Estadistica estadistica = (Estadistica) e;





        // llaman la con aqui
        Connection conn = Dao.getBdConnect();

        CallableStatement stm = conn.prepareCall("{? = Call M11_ESTADISTICA8() }");

        stm.setInt(1, 1);

        ResultSet rs = stm.executeQuery();
        int a = 0;
        String b ="";
        if (rs.wasNull() )
        {
            while(rs.next()){

                a = rs.getInt("numero");
                b = rs.getString("dato");
            }




        }
        else
        {

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
            estadistica.setNombre(" Cantidad de  Categorias por Video");






        }


        return estadistica;
    }

    /*** metodo que consume a la base de datos los valores
     *
     * @param e
     * @return
     * @throws SQLException
     */
    @Override
    public Entity GetEstadistica9(Entity e) throws SQLException {
        Estadistica estadistica = (Estadistica) e;





        // llaman la con aqui
        Connection conn = Dao.getBdConnect();

        CallableStatement stm = conn.prepareCall("{? = Call M11_ESTADISTICA8() }");

        stm.setInt(1, 1);

        ResultSet rs = stm.executeQuery();
        int a = 0;
        String b ="";
        if (rs.wasNull() )
        {
            while(rs.next()){

                a = rs.getInt("numero");
                b = rs.getString("dato");
            }




        }
        else
        {

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
            estadistica.setNombre(" Cantidad de  Comentarios ");







        }


        return estadistica;
    }
}
