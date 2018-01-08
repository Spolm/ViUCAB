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