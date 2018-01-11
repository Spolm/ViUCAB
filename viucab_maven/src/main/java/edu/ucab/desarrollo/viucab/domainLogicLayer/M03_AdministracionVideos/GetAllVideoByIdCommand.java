package edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.VideoEntity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.DaoVideoEntity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.IDaoVideoEntity;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Comando que se encarga de obtener todos los videos de un usuario.
 *
 */
public class GetAllVideoByIdCommand extends Command {


    private int _usuario;

    public ArrayList<VideoEntity> _returned;

    /**
     * Constructor de comando obtener todos los video por id de usuario
     * @Param int
     *
     */

    public GetAllVideoByIdCommand(int usuario){

        _usuario = usuario;
    }

    /**
     * Metodo que ejecuta el comando obtener todos los videos por id de usuario
     *
     */
    @Override
    public void execute() throws Exception {

        final org.slf4j.Logger logger = LoggerFactory.getLogger(DaoVideoEntity.class);
        logger.debug("Debug: Getting all videos from user - Command");

        IDaoVideoEntity daoVideo = DaoFactory.instantiateDaoVideoEntity();

        _returned = daoVideo.getAllVideoById(_usuario);

    }

    @Override
    public Entity Return() {
        return null;
    }


}
