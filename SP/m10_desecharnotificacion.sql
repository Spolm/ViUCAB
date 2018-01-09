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