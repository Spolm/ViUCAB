-- Procedure to insert a tag
CREATE OR REPLACE FUNCTION add_tag(eti VARCHAR(100), idVid integer) 
RETURNS void AS $$
DECLARE 
id integer;
idVideo integer;
_idVideo integer;
BEGIN
	_idVideo := idVid;
	INSERT INTO etiqueta
	    (eti_valor)
	SELECT eti
	WHERE
	    NOT EXISTS (
		SELECT eti_valor FROM etiqueta WHERE eti_valor LIKE eti
	    )
	RETURNING eti_id into id;

	SELECT eti_id into id from etiqueta where eti_valor LIKE eti;
	
	SELECT video_etiq.idvid into idVideo from video_etiq where video_etiq.idetiq = id AND video_etiq.idvid = _idVideo;
	
	IF idVideo IS null
	THEN
		INSERT INTO video_etiq
				(idvid, idetiq)
		VALUES (idVid, id);
	END IF;
END;
$$ LANGUAGE plpgsql;

-- Procedure to delete a tag
CREATE OR REPLACE FUNCTION delete_tag(idVid integer, valor VARCHAR(100)) 
RETURNS void AS $$
DECLARE 
id integer;
idVideo integer;
BEGIN
	idVideo := idVid;
	
	SELECT eti_id INTO id 
		FROM etiqueta 
	WHERE eti_valor LIKE valor;
	
	DELETE 
		FROM VIDEO_ETIQ
	WHERE VIDEO_ETIQ.idvid = idVideo 
		AND VIDEO_ETIQ.idetiq = id;
	
END;
$$ LANGUAGE plpgsql;

-- Procedure to consult tags from a video
CREATE OR REPLACE FUNCTION consult_tags(idVid integer) 
RETURNS TABLE(valor VARCHAR(100)) AS $BODY$
DECLARE 
id integer;
idVideo integer;
var_r record;
BEGIN
	idVideo := idVid;
	
	FOR var_r in (SELECT etiqueta.eti_valor as rValor
			FROM VIDEO_ETIQ, etiqueta 
			WHERE VIDEO_ETIQ.idVid = idVideo AND 
			etiqueta.eti_id = VIDEO_ETIQ.idetiq)
	loop
		valor := var_r.rValor;
		return next;
	end loop;
	
END;
$BODY$
LANGUAGE plpgsql;
