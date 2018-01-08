CREATE OR REPLACE  FUNCTION M03_UpdateVideo( titu varchar, des varchar, 
	                                     ima varchar, id integer,
	                                     OUT res integer)
AS $$
DECLARE  
BEGIN
		
	UPDATE video SET
	 VID_TITULO = titu, VID_DESCRIPCION = des, VID_IMAGEN = ima, VID_ID = id
	 WHERE VID_ID = id;

 res = (SELECT Count(vid_id) FROM video as t WHERE VID_IMAGEN = ima and VID_ID = id);
END;
$$ LANGUAGE plpgsql VOLATILE;

SELECT m03_updatevideo( 'titulo', 'descripcion', 'imagenNUEVA', 1) AS HOLA;

CREATE OR REPLACE  FUNCTION M03_AddVideo( titu varchar, des varchar, 
	                                     ima varchar, url varchar , fec varchar , vis integer ,
	                                       fkP integer, OUT res integer)
AS $$
DECLARE  
BEGIN
		
	INSERT INTO video(
	 VID_TITULO, VID_DESCRIPCION, VID_IMAGEN, VID_URL, VID_FECHA, VID_VISITAS, VID_USUARIO)
	VALUES ( titu, des, ima, url, fec, vis, fkp);

    res = (SELECT Count(vid_id) FROM video as t WHERE VID_URL = url and VID_USUARIO = fkp);

END;
$$ LANGUAGE plpgsql VOLATILE;

SELECT m03_addvideo( 'titulo', 'descripcion', 'imagen','url' , '1-1-2017' , 5 ,1) AS HOLA;


CREATE OR REPLACE  FUNCTION M03_getLastId(basura varchar,OUT res integer)
AS $$
DECLARE  
BEGIN
		
    res = (SELECT CASE WHEN is_called THEN last_value + 1 ELSE last_value END FROM VIDEO_VID_ID_seq);

END;
$$ LANGUAGE plpgsql VOLATILE;
SELECT M03_getLastId('');

CREATE OR REPLACE  FUNCTION M03_GetAllVideoById(id integer)
RETURNS TABLE (titu varchar(1000), des varchar(1000), 
	           ima varchar(1000), url varchar(1000) , 
	           fec date , vis integer
	           )
AS $$
  
BEGIN
		RETURN QUERY
		SELECT t.VID_TITULO,
		       t.VID_DESCRIPCION,
		       t.VID_IMAGEN,
		       t.VID_URL,
		       t.VID_FECHA,
		       t.VID_VISITAS
		       

		FROM video t
		WHERE t.VID_USUARIO = id ; 
END;
$$ LANGUAGE plpgsql;		     

SELECT M03_GetAllVideoById(1) AS HOLA;
