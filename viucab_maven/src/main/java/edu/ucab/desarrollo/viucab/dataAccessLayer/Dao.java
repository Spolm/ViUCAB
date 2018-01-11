package edu.ucab.desarrollo.viucab.dataAccessLayer;


import edu.ucab.desarrollo.viucab.common.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/***
 * creada por M011
 */
public abstract class Dao implements IDao
{
    private static Logger logger = LoggerFactory.getLogger( Dao.class );

    private static Connection conn = null;

    private static Connection conInstance;

    /**
     * Metodo para devolver una unica instancia de la conexion
     * @return instancia de la conexion
     */
    public static Connection getConInstance() {

        try {
            conInstance = getBdConnect();
        }catch (Exception e){

        }

        return conInstance;
    }

    /**
     * Metodo que realiza la conexion con la base de datos
     * @return Conexion hecha a la base de datos
     * @throws ClassNotFoundException Si la clase no es encontrada
     * @throws SQLException Problemas con sql
     * @throws Exception
     * @see Connection
     * @see Statement
     */
    public static Connection getBdConnect()
    {

        try
        {
            Class.forName( Registry.BD_CLASS_FOR_NAME );
            conn = DriverManager.getConnection( Registry.BD_URL, Registry.BD_USER, Registry.BD_PASSWORD );
        }
        catch ( ClassNotFoundException e )
        {
            logger.error( "Metodo: {} {}", "getBdConnect", e.toString() );

        }
        catch ( SQLException e )
        {
            logger.error( "Metodo: {} {}", "getBdConnect", e.toString() );

        }
        return conn;
    }

    protected static void closeConnection()
    {
        try
        {
            conn.close();
        }
        catch ( SQLException e )
        {
            logger.error( "Metodo: {} {}", "getBdConnect", e.toString() );
        }
    }

}
