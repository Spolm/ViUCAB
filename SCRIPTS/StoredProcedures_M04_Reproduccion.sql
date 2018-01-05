
CREATE OR REPLACE FUNCTION videoinfo(fitrovideo int) 
    RETURNS table(title varchar,url varchar,visitas int,likes int,owner varchar,idowner int, subscripciones int) AS $$
        
       DECLARE 
        var record;
        begin
     
        FOR var in (SELECT v.vid_titulo title , v.vid_url url, v.vid_visitas visitas, 
(SELECT count(li.id_video) from likes li where li.id_video = v.vid_id )likes, 
u.usu_login "owner", u.usu_id idowner, 
u.usu_avatar imgowner,
( select count(su.id_suscripcion) from suscripcion su where su.id_suscripcion = u.usu_id)subscripciones 
FROM video v, usuario u
WHERE v.vid_id = fitrovideo 
AND v.vid_usuario = u.usu_id)
        LOOP 
        title:= var.title;
        url := var.url;
        visitas := var.visitas;
        likes := var.likes;
        owner := var.owner;
        idowner := var.idowner;
        subscripciones := var.subscripciones;
	
        RETURN NEXT;
        END LOOP;
        end;$$
    
     LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION getVideosRelacionados(fitrovideo int) 
    RETURNS table(id int,urlimg varchar,nombre varchar,canal varchar) AS $$
        
       DECLARE 
        var record;
        begin
     
        FOR var in (SELECT video.vid_id id, video.vid_titulo nombre, video.vid_imagen urlimg, usuario.usu_login canal
from video inner join video_cat on video.vid_id = video_cat.idvid  , usuario
where video_cat.idcat IN (SELECT video_cat.idcat from video_cat WHERE video_cat.idvid = fitrovideo) 
and video.vid_id <> fitrovideo and usuario.usu_id = video.vid_usuario)
        LOOP 
        id:= var.id;
        urlimg := var.urlimg;
        nombre := var.nombre;
        canal := var.canal;
	
        RETURN NEXT;
        END LOOP;
        end;$$
    
     LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION getComentarios(fitrovideo int) 
    RETURNS table(iduser int,urlimg varchar,nombre varchar,comentario varchar) AS $$
        
       DECLARE 
        var record;
        begin
     
        FOR var in (SELECT usuario.usu_id iduser, usuario.usu_avatar urlimg , usuario.usu_login nombre , comentario.com_descripcion comentario
FROM comentario , usuario
WHERE comentario.id_vid = 1 AND comentario.id_usu = usuario.usu_id)
        LOOP 
        iduser:= var.iduser;
        urlimg := var.urlimg;
        nombre := var.nombre;
        comentario := var.comentario;
	
        RETURN NEXT;
        END LOOP;
        end;$$
    
     LANGUAGE plpgsql;
	 
 CREATE OR REPLACE FUNCTION addVisita(id INT) 
    RETURNS void AS $$
    BEGIN

  UPDATE video SET vid_visitas = vid_visitas + 1 where vid_id = id;
      
    END;
    $$ LANGUAGE plpgsql;
	
