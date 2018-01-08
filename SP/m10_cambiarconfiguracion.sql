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