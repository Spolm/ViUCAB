package edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.dataAccessLayer.DaoFactory;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M03_AdministracionVideos.IDaoVideo;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

public class GetAllVideoByIdCommand extends Command {


    private int _usuario;

    public String _returned;


    public GetAllVideoByIdCommand(int usuario){

        _usuario = usuario;
    }

    @Override
    public void execute() throws Exception {

        IDaoVideo daoVideo = DaoFactory.instantiateDaoVideo();

        //returned = daoVideo.getAllVideoById(_usuario);


    }

    @Override
    public Entity Return() {
        return null;
    }


}
