
-- FUNCION PARA ELIMINAR UN USUARIO

CREATE OR REPLACE FUNCTION m01_eliminarusuario(idusu integer)
RETURNS BOOLEAN AS 

    $BODY$
        BEGIN
            DELETE FROM usuario
            WHERE "usu_id" = $1;
                IF FOUND THEN
                    RETURN TRUE;
                ELSE
                    RETURN FALSE;
        END IF;
END;
$BODY$ 
LANGUAGE plpgsql VOLATILE
COST 100;

-------AGREGAR USUARIO

CREATE OR REPLACE FUNCTION m01_agregarusuario (username character varying, claveusu character varying, correousu character varying)
RETURNS BOOLEAN AS
$BODY$
DECLARE
    actusu BOOLEAN =FALSE;
BEGIN
INSERT INTO usuario (usu_id,usu_login,usu_clave,usu_act,usu_correo) VALUES ((SELECT MAX( "usu_id" ) + 1 FROM usuario), $1, $2, actusu , $3);
RETURN TRUE;
END; 
$BODY$ 
LANGUAGE plpgsql VOLATILE
COST 100;

-------AGREGAR USUARIO por redes

CREATE OR REPLACE FUNCTION m01_agregarusuarioredes (username character varying, correousu character varying)
RETURNS BOOLEAN AS
$BODY$
DECLARE
    actusu BOOLEAN =TRUE;
BEGIN
INSERT INTO usuario (usu_id,usu_login,usu_act,usu_correo) VALUES ((SELECT MAX( "usu_id" ) + 1 FROM usuario), $1, actusu , $2);
RETURN TRUE;
END; 
$BODY$ 
LANGUAGE plpgsql VOLATILE
COST 100;



------ BUSCAR USUARIO
CREATE OR REPLACE FUNCTION public.m01_getusuario(usucorreo character varying)
    RETURNS TABLE(cierto BOOLEAN) as
    $BODY$
BEGIN
RETURN QUERY
SELECT EXISTS (SELECT usu_correo from usuario WHERE usu_correo = $1);
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;