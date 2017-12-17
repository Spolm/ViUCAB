CREATE OR REPLACE FUNCTION  public.m05_obtenerListaDeReproduccion(idUsuario numeric)
	RETURNS TABLE (idLista numeric, nombreLista character varying,  descripcionLista character varying, numReproducciones character varying,  fechaCreacion character varying)
	AS 
$BODY$ 
DECLARE
var_r record;
BEGIN 
for var_r in(SELECT  L.LIS_REP_ID, L.LIS_REP_NOMBRE, L.LIS_REP_DESCRIPCION, L.LIS_REP_NUMREP, L.LIS_REP_FECHA
		FROM LISTA_REPRODUCCION AS L, USUARIO AS U
		WHERE L.LIS_REP_ID = U.USU_ID AND U.USU_ID = idUsuario
		ORDER BY L.LIS_REP_FECHA DESC)
loop
	idLista:= var_r.list_rep_id;
	nombreLista:= var_r.list_rep_nombre;
	descripcionLista:= var_r.list_rep_descripcion;
	numReproducciones:= var_r.list_rep_numrep;
	fechaCreacion:= var_r.list_rep_fecha;
	return next;
end loop;

END;
$BODY$
  LANGUAGE plpgsql STABLE;