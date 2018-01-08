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