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
	                                     ima varchar, url varchar , fec date , vis integer ,
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
SELECT m03_addvideo( 'titulo', 'descripcion', 'imagen','url' , '1-1-2017' , 5 ,
	                                       1) AS HOLA;