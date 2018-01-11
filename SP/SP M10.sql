-- Function: m10_addnotificacion(integer, integer)

--DROP FUNCTION m10_addnotificacion(integer, integer);

CREATE OR REPLACE FUNCTION m10_addnotificacion (usuario integer, video integer)
    RETURNS void AS
$BODY$
BEGIN
    INSERT INTO notificacion VALUES (nextval('id_notificaciones'),CURRENT_DATE,false,usuario,video);
END;
$BODY$
    LANGUAGE plpgsql VOLATILE
    COST 100;
ALTER FUNCTION m10_addnotificacion(integer, integer)
    OWNER TO postgres;

-- Function: m10_cambiarconfiguracion(integer,boolean,boolean,boolean,boolean,boolean,boolean)

--DROP FUNCTION m10_cambiarconfiguracion(integer,boolean,boolean,boolean,boolean,boolean,boolean);

CREATE OR REPLACE FUNCTION m10_cambiarconfiguracion (usuario integer, boletin boolean, preferencias boolean,
                  recibir boolean, suscripciones boolean, etiquetado boolean, estadisticas boolean)
    RETURNS void AS
$BODY$
BEGIN
    UPDATE config_notificacion SET con_not_boletin = boletin, con_not_preferencias = preferencias, con_not_recibir = recibir,
                                   con_not_suscripciones = suscripciones, con_not_etiquetado = etiquetado, con_not_estadisticas = estadisticas 
                                WHERE usu_id = usuario;
END;
$BODY$
    LANGUAGE plpgsql VOLATILE
    COST 100;
ALTER FUNCTION m10_cambiarconfiguracion(integer,boolean,boolean,boolean,boolean,boolean,boolean)
    OWNER TO postgres;

-- Function: m10_desecharnotificacion(integer)

--DROP FUNCTION m10_desecharnotificacion(integer);

CREATE OR REPLACE FUNCTION m10_desecharnotificacion (notif integer)
    RETURNS void AS
$BODY$
BEGIN
    UPDATE notificacion set not_desechado = true WHERE not_id = notif;
END;
$BODY$
    LANGUAGE plpgsql VOLATILE
    COST 100;
ALTER FUNCTION m10_desecharnotificacion(integer)
    OWNER TO postgres;

-- Function: m10_getconfiguracion(integer)

--DROP FUNCTION m10_getconfiguracion(integer);

CREATE OR REPLACE FUNCTION m10_getconfiguracion ( IN usuario integer)
    RETURNS TABLE(con_not_id int, con_not_boletin boolean, con_not_preferencias boolean,
                  con_not_recibir boolean, con_not_suscripciones boolean, con_not_etiquetado boolean, con_not_estadisticas boolean) AS
$BODY$
BEGIN
RETURN QUERY
SELECT  c.con_not_id, c.con_not_boletin, c.con_not_preferencias, c.con_not_recibir, c.con_not_suscripciones, 
        c.con_not_etiquetado, c.con_not_estadisticas
        FROM config_notificacion c
        WHERE c.usu_id = usuario;
END;
$BODY$
    LANGUAGE plpgsql VOLATILE
    COST 100
    ROWS 1000;
ALTER FUNCTION m10_getconfiguracion(integer)
    OWNER TO postgres;

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
        WHERE (n.not_desechado=false and n.vid_id=v.vid_id and n.usu_id = usuario and v.usu_id = u.usu_id)
        ORDER BY not_fecha DESC;
END;
$BODY$
    LANGUAGE plpgsql VOLATILE
    COST 100
    ROWS 1000;
ALTER FUNCTION m10_getnotificaciones(integer)
    OWNER TO postgres;

-- Function: m10_sendmailnotificacion(integer)

--DROP FUNCTION m10_sendmailnotificacion(integer);

CREATE OR REPLACE FUNCTION m10_sendmailnotificacion ( IN usuario integer)
    RETURNS TABLE(usu_id integer, usu_login character varying, usu_clave character varying, usu_token character varying, 
                usu_act boolean, usu_correo character varying, usu_avatar bytea) AS
$BODY$
BEGIN
RETURN QUERY
SELECT  * FROM usuario u
        WHERE u.usu_id = usuario;
END;
$BODY$
    LANGUAGE plpgsql VOLATILE
    COST 100
    ROWS 1000;
ALTER FUNCTION m10_sendmailnotificacion(integer)
    OWNER TO postgres;
    