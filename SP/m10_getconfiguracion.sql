-- Function: m10_getconfiguracion(integer)

--DROP FUNCTION m10_getconfiguracion(integer);

CREATE OR REPLACE FUNCTION m10_getconfiguracion ( IN usuario integer)
    RETURNS TABLE(con_not_id int, con_not_boletin boolean, con_not_preferencias boolean,
                  con_not_recibir boolean, con_not_suscripciones boolean, con_not_etiquetado boolean, con_not_estadisticas boolean) AS
$BODY$
BEGIN
RETURN QUERY
SELECT  c.con_not_id, c.con_not_boletin, c.con_not_preferencias, c.con_not_recibir, c.con_not suscripciones, 
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