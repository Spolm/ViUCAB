package edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.DaoVideoEntity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.IDaoVideoEntity;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import org.slf4j.LoggerFactory;

/**
 * Comando que se encarga de Agregar un video.
 *
 */
public class AddVideoCommand extends Command {


    private Entity _video;

    public String _returned;


    /**
     * Constructor del agregar comando
     *
     * @Param Entity
     *
     */

    public AddVideoCommand(Entity video){

        _video = video;
    }

    /**
     *Metodo ejecutar el comando
     *
     */
    @Override
    public void execute() throws Exception {

        final org.slf4j.Logger logger = LoggerFactory.getLogger(DaoVideoEntity.class);
        logger.debug("Debug: Adding VideoEntity - Command");

        IDaoVideoEntity daoVideo = DaoFactory.instantiateDaoVideoEntity();

        _returned = Integer.toString(daoVideo.addVideo(_video));


    }

    @Override
    public Entity Return() {
        return null;
    }


}
