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
