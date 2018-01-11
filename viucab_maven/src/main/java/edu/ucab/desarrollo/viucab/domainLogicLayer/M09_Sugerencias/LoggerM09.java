package edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias;

import edu.ucab.desarrollo.viucab.common.exceptions.MessageException;
import javafx.scene.media.MediaException;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class LoggerM09 {
    FileOutputStream archivo;
    PrintStream p = null;
    private Logger logr = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    String proc;
    String clase;
    String tipo;
    FileHandler fh;

    public LoggerM09(){}

    public LoggerM09(String procedimiento, String clase, String tipo){
        this.proc = procedimiento;
        this.clase = clase;
        this.tipo = tipo;
    }

        public void imprimirLogger (String clase, String procedimiento, String tipo) throws MessageException {

            Date fecha = new Date();
            FileWriter archivos;
            File archivo=new File("C:/Users/Alejandro/Documents/texto.txt"); // Se crea el archivo
            FileWriter fw = null;	// la extension al archivo
            try {
                fw = new FileWriter(archivo,true);
                fw.write(clase+procedimiento+tipo);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter salArch = new PrintWriter(bw);

                salArch.print(tipo+": CLASE: "+clase+". PROCEDIMIENTO: "+procedimiento+". "+fecha+".");
                salArch.println();

                salArch.close();
            }
            catch (IOException ex) {
            }
        }

    public FileOutputStream getArchivo() {
        return archivo;
    }

    public void setArchivo(FileOutputStream archivo) {
        this.archivo = archivo;
    }

    public PrintStream getP() {
        return p;
    }

    public void setP(PrintStream p) {
        this.p = p;
    }

    public Logger getLogr() {
        return logr;
    }

    public void setLogr(Logger logr) {
        this.logr = logr;
    }

    public String getProc() {
        return proc;
    }

    public void setProc(String proc) {
        this.proc = proc;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
