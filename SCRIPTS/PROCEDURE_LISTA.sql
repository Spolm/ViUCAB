-- Function: public.m05_obtenerlista(integer)

-- DROP FUNCTION public.m05_obtenerlista(integer);

CREATE OR REPLACE FUNCTION public.m05_obtenerlista(IN usuario integer)
  RETURNS TABLE(lis_rep_id integer, lis_rep_nombre character varying, lis_rep_descripcion character varying, lis_rep_numrep integer, lis_rep_fecha date) AS
$BODY$
BEGIN
RETURN QUERY
SELECT  L.LIS_REP_ID, L.LIS_REP_NOMBRE, L.LIS_REP_DESCRIPCION, L.LIS_REP_NUMREP, L.LIS_REP_FECHA
		FROM LISTA_REPRODUCCION AS L, USUARIO AS U
		WHERE L.ID_USU = U.USU_ID AND U.USU_ID = usuario
		ORDER BY L.LIS_REP_FECHA DESC;

END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION public.m05_obtenerlista(integer)
  OWNER TO postgres;


-- FUNCION PARA AGREGAR LISTA

CREATE OR REPLACE FUNCTION public.m05_crearlista(lis_rep_nombre character varying, lis_rep_descripcion character varying, list_rep_img character varying, lis_rep_numrep integer, lis_rep_fecha character varying, id_usu integer)
RETURNS INTEGER AS 
$BODY$
DECLARE
	idList INTEGER;
BEGIN
select nextval('id_lista') into idList;
INSERT INTO LISTA_REPRODUCCION VALUES (idList, $1, $2, $3, $4, $5, $6);
RETURN idList;
END; 
$BODY$ 
LANGUAGE plpgsql VOLATILE
COST 100;


-- FUNCION PARA MODIFICAR LISTA

CREATE OR REPLACE FUNCTION m05_modificarLista(listaId integer,lis_rep_nombre character varying, lis_rep_descripcion character varying, list_rep_img character varying, lis_rep_numrep integer, lis_rep_fecha character varying)
RETURNS BOOLEAN AS 
$BODY$
BEGIN
UPDATE LISTA_REPRODUCCION SET "lis_rep_nombre"=$2, "lis_rep_descripcion"=$3, "lis_rep_img"=$4, "lis_rep_numrep"=$5, "lis_rep_fecha"=$6
WHERE "lis_rep_id" = listaId;

IF FOUND THEN
      RETURN TRUE;
   ELSE
      RETURN FALSE;
   END IF;
END; 
$BODY$ 
LANGUAGE plpgsql VOLATILE
COST 100;


-- FUNCION PARA ELIMINAR UNA LISTA

CREATE OR REPLACE FUNCTION m05_eliminarLista(listaId integer)
RETURNS BOOLEAN AS 

$BODY$
BEGIN
DELETE FROM LISTA_REPRODUCCION
WHERE "lis_rep_id" = $1;
IF FOUND THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;
$BODY$ 
LANGUAGE plpgsql VOLATILE
COST 100;
