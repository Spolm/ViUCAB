package edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.VideoEntity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.IDaoVideoEntity;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

public class GetVideoCommand extends Command {


    private int _videoId;

    public VideoEntity _returned;


    public GetVideoCommand(int videoId){

        _videoId = videoId;
    }

    @Override
    public void execute() throws Exception {

        IDaoVideoEntity daoVideo = DaoFactory.instantiateDaoVideoEntity();

        _returned = daoVideo.getVideo(_videoId);

    }

    @Override
    public Entity Return() {
        return null;
    }


}
