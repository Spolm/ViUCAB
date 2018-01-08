package edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.IDaoVideo;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

public class DeleteVideoCommand extends Command {


    private int _video;

    public String _returned;


    public DeleteVideoCommand(int videoId){

        _video = videoId;
    }

    @Override
    public void execute() throws Exception {

        IDaoVideo daoVideo = DaoFactory.instantiateDaoVideo();

        _returned = Integer.toString(daoVideo.deleteVideo(_video));


    }

    @Override
    public Entity Return() {
        return null;
    }


}
