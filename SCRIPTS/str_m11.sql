-- ver estadisticas mas utilizadas

CREATE OR REPLACE FUNCTION M11_ESTADISTICA1(USUARIO int)
	RETURNS TABLE (numero bigint,dato varchar(100))
as $$
BEGIN
RETURN QUERY 
select count(e.eti_valor) , e.eti_valor
from video v ,etiqueta e, video_etiq eq
where v.vid_usuario = USUARIO and v.vid_id = eq.idvid 
and eq.idetiq = e.eti_id
group by e.eti_valor;

END;
$$ LANGUAGE plpgsql;

-- videos con mas likes

CREATE OR REPLACE FUNCTION M11_ESTADISTICA2(USUARIO int)
	RETURNS TABLE (numero bigint,dato varchar(100))
as $$
BEGIN
RETURN QUERY 
select count(l.id_video) , v.vid_titulo
from video v, usuario u, likes l
where u.usu_id = USUARIO
and u.usu_id = l.id_usuario
and l.id_video = v.vid_id
group by v.vid_titulo;

END;
$$ LANGUAGE plpgsql;

-- visitas de videos 

CREATE OR REPLACE FUNCTION M11_ESTADISTICA3(USUARIO int)
	RETURNS TABLE (dat int,dato varchar(100))
as $$
BEGIN
RETURN QUERY
select v.vid_visitas ,v.vid_titulo
from video v
where v.vid_usuario = USUARIO;

END;
$$ LANGUAGE plpgsql;

-- usuarios con mas videos 

CREATE OR REPLACE FUNCTION M11_ESTADISTICA4(USUARIO int)
	RETURNS TABLE (numero bigint,dato varchar(100))
as $$
BEGIN
RETURN QUERY

select count(v.vid_id),u.usu_login
from usuario u,video v
where u.usu_id = v.vid_usuario
group by u.usu_login;

END;
$$ LANGUAGE plpgsql;

-- seguidas y seguidas por mes 

CREATE OR REPLACE FUNCTION M11_ESTADISTICA56(USUARIO int)
	RETURNS TABLE (numero int)
as $$
DECLARE
	HOLA INT;
BEGIN
HOLA := 0;	 
END;
$$ LANGUAGE plpgsql;
-- devuelva nulo

-- cuanto isitas por mes de tus videos 

CREATE OR REPLACE FUNCTION M11_ESTADISTICA7(USUARIO int)
	RETURNS TABLE (numero bigint,dato date(1000))
as $$
BEGIN
RETURN QUERY
select  count(v.vid_id), v.vid_fecha
from usuario u,video v
where u.usu_id = v.vid_usuario
group by v.vid_fecha;
 END;
$$ LANGUAGE plpgsql;

-- cual video tiene mas categorias 

CREATE OR REPLACE FUNCTION M11_ESTADISTICA8(USUARIO int)
	RETURNS TABLE (numero bigint,dato varchar(100))
as $$
BEGIN
RETURN QUERY
select  count(c.cat_id),v.vid_titulo
from video v, categoria c, video_cat vc
where v.vid_usuario = USUARIO
and v.vid_id = vc.idvid
and vc.idcat = c.cat_id
group by v.vid_titulo;
END;
$$ LANGUAGE plpgsql;


-- video con mayores comentarios

CREATE OR REPLACE FUNCTION M11_ESTADISTICA9(USUARIO int)
	RETURNS TABLE (numero bigint,dato varchar(100))
as $$
BEGIN
RETURN QUERY

select count(c.com_id),v.vid_titulo
from video v, comentario c
where v.vid_usuario = USUARIO
and v.vid_usuario = c.id_usu
group by v.vid_titulo;

END;
$$ LANGUAGE plpgsql;