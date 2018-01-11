package edu.ucab.desarrollo.viucab.dataAccessLayer.M07_Etiquetas;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Etiquetas;
import edu.ucab.desarrollo.viucab.common.exceptions.BDConnectException1;
import edu.ucab.desarrollo.viucab.common.exceptions.PLConnectException1;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import org.postgresql.util.PSQLException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GetEtiquetasDao extends Dao implements IDaoEtiqueta {

    public GetEtiquetasDao(){

    }

    @Override
    public Entity insertarEtiqueta(Entity e) throws BDConnectException1, PLConnectException1 {
        Connection conn;
        String insert="{call add_tag(?,?)}";
        Etiquetas eti = (Etiquetas) e;
        try{
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            CallableStatement ps = conn.prepareCall(insert);
            String str = eti.getValor();
            List<String> items = Arrays.asList(str.split("\\s"));
            for(String s : items) {
                ps.setString(1, s);
                ps.setInt(2, eti.getVideoEtiqList().getIdVid());
                ps.execute();
            }
            ps.close();
        }
        catch (PSQLException el){
            throw new PLConnectException1(el);
        }
        catch (SQLException el) {
            throw new BDConnectException1(el);
        }
        catch (Exception el)    {
            el.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return eti;
    }

    @Override
    public Entity eliminarEtiqueta(Entity e) throws BDConnectException1, PLConnectException1{
        Connection conn;
        Etiquetas eti = (Etiquetas) e;
        String delete="{call delete_tag(?,?)}";
        try{
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            CallableStatement ps = conn.prepareCall(delete);
            ps.setInt(1, eti.getVideoEtiqList().getIdVid());
            ps.setString(2, eti.getValor());
            ps.execute();
            ps.close();
        }
        catch (PSQLException el){
            throw new PLConnectException1(el);
        }
        catch (SQLException el) {
            throw new BDConnectException1(el);
        }
        catch (Exception el)    {
            el.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return eti;
    }

    @Override
    public List<Etiquetas> consultarVideos(Entity e) throws BDConnectException1, PLConnectException1{
        Connection conn;
        Etiquetas eti = (Etiquetas) e;

        List<Etiquetas> list = new ArrayList<Etiquetas>();

        String selectVid="{call consult_tags(?)}";

        try{
            //Creando la instancia de Conexion a la BD
            conn = getBdConnect();
            CallableStatement ps = conn.prepareCall(selectVid);
            ps.setInt(1, eti.getVideoEtiqList().getIdVid());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String _valor = rs.getString("valor");
                Etiquetas etis = new Etiquetas(_valor);
                list.add(etis);
            }
            ps.close();
        }
        catch (PSQLException el){
            throw new PLConnectException1(el);
        }
        catch (SQLException el) {
            throw new BDConnectException1(el);
        }
        catch (Exception el)    {
            el.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return list;
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
}
