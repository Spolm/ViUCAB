package edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.VideoEntity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.DaoVideoEntity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.IDaoVideoEntity;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

/**
 * Comando que se encarga de obtener la informacion de un video
 *
 */
public class GetVideoCommand extends Command {


    private int _videoId;

    public VideoEntity _returned;


    /**
     * Constructor de comando obtener video
     * @Param int
     *
     */
    public GetVideoCommand(int videoId){

        _videoId = videoId;
    }

    /**
     * Metodo que se encarga de ejecutar el comando obtener video
     *
     */
    @Override
    public void execute() throws Exception {

        final org.slf4j.Logger logger = LoggerFactory.getLogger(DaoVideoEntity.class);
        logger.debug("Debug: Getting VideoEntity - Command");

        IDaoVideoEntity daoVideo = DaoFactory.instantiateDaoVideoEntity();

        _returned = daoVideo.getVideo(_videoId);

    }

    @Override
    public Entity Return() {
        return null;
    }


}
