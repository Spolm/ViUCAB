/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucab.desarrollo.viucab.domainLogicLayer.M04_Reproduccion;

import com.google.gson.JsonObject;
import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.*;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M04_Reproductor.IDaoVideo;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M04_Reproductor.VideoDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

/**
 *
 * @author AlejandroNegrin
 */
public class ComandoGetVideoYCanal extends Command {

    private int idvideo;
    public JsonObject result;

    public ComandoGetVideoYCanal(int idvideo) {
        this.idvideo = idvideo;
    }

    @Override
    public void execute() throws VIUCABException, Exception {
        VideoDao videoDao = DaoFactory.instanciarVideoDao();
        this.result = videoDao.getVideoYCanal(this.idvideo);
    }

    @Override
    public Entity Return() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
