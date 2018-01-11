-- Function: m10_getnotificaciones(integer)

--DROP FUNCTION m10_getnotificaciones(integer);

CREATE OR REPLACE FUNCTION m10_getnotificaciones ( IN usuario integer)
    RETURNS TABLE(not_id integer, not_fecha date, not_desechado boolean, usu_login character varying, vid_titulo character varying,
                vid_descripcion character varying, vid_url character varying, vid_imagen character varying) AS
$BODY$
BEGIN
RETURN QUERY
SELECT  n.not_id, n.not_fecha, n.not_desechado, u.usu_login, v.vid_titulo, v.vid_descripcion, v.vid_url, v.vid_imagen 
        FROM notificacion n, video v, usuario u
        WHERE (n.not_desechado=false and n.vid_id=v.vid_id and n.usu_id = usuario and v.vid_usuario = u.usu_id)
        ORDER BY not_fecha DESC;
END;
$BODY$
    LANGUAGE plpgsql VOLATILE
    COST 100
    ROWS 1000;
ALTER FUNCTION m10_getnotificaciones(integer)
    OWNER TO postgres;