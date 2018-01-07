CREATE OR REPLACE  FUNCTION M03_AddVideo( titu varchar, des varchar, 
	                                     ima varchar, url varchar , fec date , vis integer ,
	                                       fkP integer, OUT res integer)
AS $$
DECLARE  
BEGIN
		
	INSERT INTO video(
	 VID_TITULO, VID_DESCRIPCION, VID_IMAGEN, VID_URL, VID_FECHA, VID_VISITAS, VID_USUARIO)
	VALUES ( titu, des, ima, url, fec, vis, fkp);

    res = (SELECT Count(t.vid_id) FROM video as t WHERE t.VID_URL = url and VID_USUARIO = fkp);

END;
$$ LANGUAGE plpgsql VOLATILE;
SELECT m03_addvideo( 'titulo', 'descripcion', 'imagen','url' , '1-1-2017' , 5 ,
	                                       1) AS HOLA;
