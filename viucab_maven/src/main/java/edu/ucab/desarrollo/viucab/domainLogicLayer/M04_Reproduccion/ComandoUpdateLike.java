/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucab.desarrollo.viucab.domainLogicLayer.M04_Reproduccion;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M04_Reproductor.VideoDao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

/**
 *
 * @author AlejandroNegrin
 */
public class ComandoUpdateLike extends Command{
    private int idvideo;
    private String usuario;
    
    public ComandoUpdateLike(int idvideo, String usuario) {
        this.idvideo = idvideo;
        this.usuario = usuario;
    }
    
    @Override
    public void execute() throws VIUCABException, Exception {
        VideoDao dao = DaoFactory.instanciarVideoDao();
        dao.updateLike(this.idvideo, this.usuario);
    }

    @Override
    public Entity Return() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
