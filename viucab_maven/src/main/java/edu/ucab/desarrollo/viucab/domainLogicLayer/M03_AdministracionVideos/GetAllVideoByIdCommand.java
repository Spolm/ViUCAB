package edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.IDaoVideo;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.util.ArrayList;

public class GetAllVideoByIdCommand extends Command {


    private int _usuario;

    public ArrayList<Video> _returned;


    public GetAllVideoByIdCommand(int usuario){

        _usuario = usuario;
    }

    @Override
    public void execute() throws Exception {

        IDaoVideo daoVideo = DaoFactory.instantiateDaoVideo();

        _returned = daoVideo.getAllVideoById(_usuario);

    }

    @Override
    public Entity Return() {
        return null;
    }


}
