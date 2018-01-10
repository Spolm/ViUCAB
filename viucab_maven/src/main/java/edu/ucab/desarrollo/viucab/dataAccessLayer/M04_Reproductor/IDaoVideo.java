package edu.ucab.desarrollo.viucab.dataAccessLayer.M04_Reproductor;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import edu.ucab.desarrollo.viucab.dataAccessLayer.IDao;
import edu.ucab.desarrollo.viucab.dataAccessLayer.M02_Home.*;

/**
 * Created by Alejandro Negrin on 03/01/2018.
 */
public interface IDaoVideo extends IDao{
    
    public JsonObject getVideoYCanal(int idvideo);
    
    public JsonArray getVideosRelacionados(int idvideo);
    
    public JsonArray getComentarios(int idvideo);
    
    public void addVisita(int idvideo);
    
    public int addComentario(int idvideo, String usuario, String comentario);
    
    public void updateLike(int idvideo, String usuario);
    
    public int getIfLike(int idvideo, String usuario);
    
    public int deleteComentario(int idcom);
}
