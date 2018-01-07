package edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.IDaoVideo;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

public class AddVideoCommand extends Command {


    private Entity _video;

    public String _returned;


    public AddVideoCommand(Entity video){

        _video = video;
    }

    @Override
    public void execute() throws Exception {

        IDaoVideo daoVideo = DaoFactory.instantiateDaoVideo();

        _returned = Integer.toString(daoVideo.addVideo(_video));


    }

    @Override
    public Entity Return() {
        return null;
    }


}
