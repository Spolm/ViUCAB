/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucab.desarrollo.viucab.domainLogicLayer.M04_Reproduccion;

import com.google.gson.JsonObject;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;

/**
 *
 * @author AlejandroNegrin
 */
public class ComandoGetVideoInfo extends Command {

    private int idvideo;
    public JsonObject result;

    public ComandoGetVideoInfo(int idvideo) {
        this.idvideo = idvideo;
    }

    @Override
    public void execute() throws VIUCABException, Exception {

        //construyo json con la info basica del video
        Command cmd = CommandsFactory.instanciarComandoGetVideoYCanal(idvideo);
        ComandoGetVideoYCanal co = (ComandoGetVideoYCanal) cmd;
        co.execute();
        this.result = co.result;

        //agrego lista de videos relacionados al jason
        cmd = CommandsFactory.instanciarComandoGetVideosRelacionados(idvideo);
        ComandoGetVideosRelacionados co2 = (ComandoGetVideosRelacionados) cmd;
        co2.execute();
        this.result.add("relacionados", co2.result);

        //agrego comentarios
        cmd = CommandsFactory.instanciarComandoGetComentarios(idvideo);
        ComandoGetComentarios co3 = (ComandoGetComentarios) cmd;
        co3.execute();
        this.result.add("comentarios", co3.result);
        
    }

    @Override
    public Entity Return() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
