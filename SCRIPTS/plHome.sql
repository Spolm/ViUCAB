 -- FUNCION QUE DEVUELVE LOS VIDEOS ORDENADOS POR NUMERO DE VISITAS
 CREATE OR REPLACE FUNCTION public.m02_obtenerMasVistos()
  RETURNS TABLE(idvideo numeric, nombrevideo character varying,descripcionvideo character varying
			   ,imagenvideo character varying, urlvideo character varying,fechavideo character varying
			   ,visitasvideo character varying,nombreusuario character varying, imagenusuario character varying  ) AS
$BODY$ 
DECLARE
var_r record;
BEGIN 
for var_r in(SELECT VIDEO.* ,USUARIO.USU_LOGIN,USUARIO.USU_AVATAR
             FROM VIDEO,USUARIO
             where VIDEO.VID_USUARIO=USUARIO.USU_ID
             ORDER BY VIDEO.VID_VISITAS DESC)
loop
		idvideo:=var_r.vid_id;
		nombrevideo := var_r.vid_titulo;
		descripcionvideo:= var_r.vid_descripcion;
		imagenvideo :=var_r.vid_imagen;
		urlvideo := var_r.vid_url;
		fechavideo := var_r.vid_fecha;
		visitasvideo := var_r.vid_visitas;
		nombreusuario := var_r.usu_login;
		imagenusuario := var_r.usu_avatar;
		return next;
		
end loop;		


  
END; 
$BODY$
  LANGUAGE plpgsql STABLE;
  
  
 --FUNCION QUE DEVUELVE DADO UN ID LAS PREFERENCIAS ASOCIADAS AL USUARIO 
 CREATE OR REPLACE FUNCTION public.m02_obtenerPreferencias(idUsuario numeric)
  RETURNS TABLE(idvideo numeric, nombrevideo character varying,descripcionvideo character varying
			   ,imagenvideo character varying, urlvideo character varying,fechavideo character varying
			   ,visitasvideo character varying,nombreusuario character varying, imagenusuario character varying  ) AS
$BODY$ 
DECLARE
var_r record;
BEGIN 
for var_r in(SELECT  VIDEO.* ,USUARIO.USU_LOGIN,USUARIO.USU_AVATAR
             FROM video,usuario,categoria,preferencia,video_cat
             WHERE video.vid_id=video_cat.idvid 
                   AND categoria.cat_id=video_cat.idcat 
                   AND usuario.usu_id=preferencia.id_usu 
                   AND categoria.cat_id=preferencia.id_cat 
                   AND video_cat.idcat=preferencia.id_cat 
				   AND usuario.usu_id=idUsuario)
loop
		idvideo:=var_r.vid_id;
		nombrevideo := var_r.vid_titulo;
		descripcionvideo:= var_r.vid_descripcion;
		imagenvideo :=var_r.vid_imagen;
		urlvideo := var_r.vid_url;
		fechavideo := var_r.vid_fecha;
		visitasvideo := var_r.vid_visitas;
		nombreusuario := var_r.usu_login;
		imagenusuario := var_r.usu_avatar;
		return next;
		
end loop;		

END; 
$BODY$
  LANGUAGE plpgsql STABLE;
  
 -- FUNCION QUE DEVUELVE LOS ULTIMOS VIDEOS SUBIDOS A LOS CANALES SUSCRITOS
   CREATE OR REPLACE FUNCTION public.m02_obtenerSuscripciones(idUsuario numeric)
  RETURNS TABLE(idvideo numeric, nombrevideo character varying,descripcionvideo character varying
			   ,imagenvideo character varying, urlvideo character varying,fechavideo character varying
			   ,visitasvideo character varying ) AS
$BODY$ 
DECLARE
var_r record;
BEGIN 
for var_r in(SELECT DISTINCT VIDEO.* 
             FROM video,usuario,suscripcion 
             WHERE video.vid_usuario=suscripcion.id_suscripcion 
				AND suscripcion.id_suscriptor=IdUsuario
             ORDER BY video.vid_fecha DESC )
loop
		idvideo:=var_r.vid_id;
		nombrevideo := var_r.vid_titulo;
		descripcionvideo:= var_r.vid_descripcion;
		imagenvideo :=var_r.vid_imagen;
		urlvideo := var_r.vid_url;
		fechavideo := var_r.vid_fecha;
		visitasvideo := var_r.vid_visitas;
		return next;
		
end loop;		


  
END; 
$BODY$
  LANGUAGE plpgsql STABLE;
  
  


 CREATE OR REPLACE FUNCTION public.m02_buscarVideo(parametroBusqueda character varying)
  RETURNS TABLE(idvideo numeric, nombrevideo character varying,descripcionvideo character varying
			   ,imagenvideo character varying, urlvideo character varying,fechavideo character varying
			   ,visitasvideo character varying) AS
$BODY$ 
DECLARE
var_r record;
concatenado character varying;

BEGIN 
concatenado := '%'||parametroBusqueda||'%' ;
for var_r in(SELECT  video.*
             FROM    video, categoria, video_cat 
             WHERE   video.vid_titulo LIKE concatenado
					 AND video.vid_id=video_cat.idvid 
                     AND categoria.cat_id=video_cat.idcat 
            UNION 
			SELECT  video.* 
			FROM    video,categoria,video_cat 
			WHERE   categoria.cat_valor LIKE concatenado
					AND video.vid_id=video_cat.idvid 
					AND categoria.cat_id=video_cat.idcat 
			UNION 
			SELECT  video.*
			FROM    video,etiqueta,video_etiq
			WHERE   etiqueta.eti_valor LIKE concatenado
					AND video.vid_id=video_etiq.idvid 
					AND etiqueta.eti_id=video_etiq.idetiq)
loop
		idvideo:=var_r.vid_id;
		nombrevideo := var_r.vid_titulo;
		descripcionvideo:= var_r.vid_descripcion;
		imagenvideo :=var_r.vid_imagen;
		urlvideo := var_r.vid_url;
		fechavideo := var_r.vid_fecha;
		visitasvideo := var_r.vid_visitas;

		return next;
		
end loop;		


  
END; 
$BODY$
  LANGUAGE plpgsql STABLE;


  