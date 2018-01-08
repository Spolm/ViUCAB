package edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.IDaoVideo;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.util.ArrayList;

public class GetVideoCommand extends Command {


    private int _videoId;

    public Video _returned;


    public GetVideoCommand(int videoId){

        _videoId = videoId;
    }

    @Override
    public void execute() throws Exception {

        IDaoVideo daoVideo = DaoFactory.instantiateDaoVideo();

        _returned = daoVideo.getVideo(_videoId);

    }

    @Override
    public Entity Return() {
        return null;
    }


}
