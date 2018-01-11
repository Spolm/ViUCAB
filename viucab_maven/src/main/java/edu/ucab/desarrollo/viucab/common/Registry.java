package edu.ucab.desarrollo.viucab.common;

/**
 * Created by Daniel on 25/11/2017. creada por M011
 */
public class Registry {

<<<<<<< HEAD
    //public static String BD_USER = "viucab";
    public static String BD_USER = "postgres";
    //public static String BD_PASSWORD = "viucab";
    public static String BD_PASSWORD = "5530321";
    //public static String BD_URL = "jdbc:postgresql://localhost/viucabdb";
    public static String BD_URL = "jdbc:postgresql://localhost/ViUCAB";
=======
    public static String BD_USER = "viucab";
    //public static String BD_USER = "postgre";
    public static String BD_PASSWORD = "viucab";
    //public static String BD_PASSWORD = "5530321";
    public static String BD_URL = "jdbc:postgresql://localhost:5432/viucabdb";
   // public static String BD_URL = "jdbc:postgresql://localhost:5432/ViUCAB";
>>>>>>> Develop
    public static String BD_CLASS_FOR_NAME = "org.postgresql.Driver";

    public static final int RESULT_CODE_OK = 200;
    public static final int RESULT_CODE_FAIL = 500;

    public static final String ERROR_PARAM_WS = "Error recibido por el servicio web";
    public static final String RESULT_CODE_FAIL_MSG = "Ha ocurrido un error";
    

}
