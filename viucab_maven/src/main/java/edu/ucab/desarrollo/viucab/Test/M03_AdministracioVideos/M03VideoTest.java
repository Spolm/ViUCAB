package edu.ucab.desarrollo.viucab.Test.M03_AdministracioVideos;

import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.VideoEntity;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M03_AdministracionVideos.*;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class M03VideoTest {

    @Test
    public void test1_addVideo() throws Exception {
        VideoEntity video = (VideoEntity) EntityFactory.instantiateVideoEntity("tituloTest",
                                                                               "descripcionTest",
                                                                               "urlImagen.jpg","urlVideo.mp4",
                                                                               1);
        AddVideoCommand cmd = (AddVideoCommand) CommandsFactory.intantiateAddVideoCommand(video);
        cmd.execute();
        assertEquals(cmd._returned,"1");
    }

    @Test
    public void test2_updateVideo() throws Exception {

        VideoEntity videoAux = (VideoEntity) EntityFactory.instantiateVideoEntity();
        VideoEntity video = (VideoEntity) EntityFactory.instantiateVideoEntity(videoAux.getNextId()-1,
                                                                               "tituloNuevoTest",
                                                                               "descripcionNuevaTest");
        UpdateVideoCommand cmd = (UpdateVideoCommand) CommandsFactory.intantiateUpdateVideoCommand(video);
        cmd.execute();
        assertEquals(cmd._returned,"1");
    }

    @Test
    public void test3_getVideo() throws Exception {
        VideoEntity videoAux = (VideoEntity) EntityFactory.instantiateVideoEntity();
        GetVideoCommand cmd = (GetVideoCommand) CommandsFactory.intantiateGetVideoCommand(videoAux.getNextId()-1);
        cmd.execute();

        assertEquals(cmd._returned.get_id(),videoAux.getNextId()-1);
    }

    @Test
    public void test4_getAllVideoFromUser() throws Exception {

        GetAllVideoByIdCommand cmd = (GetAllVideoByIdCommand) CommandsFactory.intantiateGetAllVideoByIdCommand(1);
        cmd.execute();
        assertNotEquals(cmd._returned.size(),0);

    }

    @Test
    public void test5_deleteVideo() throws Exception {
        VideoEntity videoAux = (VideoEntity) EntityFactory.instantiateVideoEntity();
        DeleteVideoCommand cmd = (DeleteVideoCommand) CommandsFactory.intantiateDeleteVideoCommand(videoAux.getNextId()-1);
        cmd.execute();
        assertEquals(cmd._returned,"0");
    }

}