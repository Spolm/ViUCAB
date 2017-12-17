package edu.ucab.desarrollo.viucab.domainLogicLayer.M09_Sugerencias;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.Like;
import edu.ucab.desarrollo.viucab.common.entities.Usuario;
import edu.ucab.desarrollo.viucab.common.entities.Video;
import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;

import java.sql.SQLException;

public class GetSugerenciasLikeComando implements Command {

    Like like;
    Usuario user;
    Video vid;

    public GetSugerenciasLikeComando(){
        like = new Like();
        user = new Usuario();
        vid = new Video();
    }

    @Override
    public String execute(int usuario, String categoria) throws SQLException {
        Dao dao = new Dao();
        return dao.getSugerenciasLike(usuario, categoria);
    }
/*
    @Override
    public Entity Return() {
        return null;
    }
*/
}
