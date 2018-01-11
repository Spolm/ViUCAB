-- Function: public.m05_obtenerlista(integer)

-- DROP FUNCTION public.m05_obtenerlista(integer);

CREATE OR REPLACE FUNCTION public.m05_obtenerlista(IN usuario integer)
  RETURNS TABLE(lis_rep_id integer, lis_rep_nombre character varying, lis_rep_descripcion character varying, lis_rep_img character varying, lis_rep_numrep integer, lis_rep_fecha character varying, id_usu integer) AS
$BODY$
BEGIN
RETURN QUERY
SELECT  L.LIS_REP_ID, L.LIS_REP_NOMBRE, L.LIS_REP_DESCRIPCION, L.lis_rep_img, L.LIS_REP_NUMREP, L.LIS_REP_FECHA, L.id_usu
		FROM LISTA_REPRODUCCION AS L, USUARIO AS U
		WHERE L.ID_USU = U.USU_ID AND U.USU_ID = usuario
		ORDER BY L.LIS_REP_FECHA DESC;

END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;


-- FUNCION PARA BUSCAR 1 LISTA EN ESPECIFICO
CREATE OR REPLACE FUNCTION public.m05_obtenerlistaespecifica(IN idlista integer)
  RETURNS TABLE(lis_rep_id integer, lis_rep_nombre character varying, lis_rep_descripcion character varying, lis_rep_img character varying, lis_rep_numrep integer, lis_rep_fecha character varying, id_usu integer) AS
$BODY$
BEGIN
RETURN QUERY
SELECT  L.LIS_REP_ID, L.LIS_REP_NOMBRE, L.LIS_REP_DESCRIPCION, L.lis_rep_img, L.LIS_REP_NUMREP, L.LIS_REP_FECHA, L.id_usu
		FROM LISTA_REPRODUCCION AS L, USUARIO AS U
		WHERE L.LIS_REP_ID = idLista
		GROUP BY L.LIS_REP_ID;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


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

CREATE OR REPLACE FUNCTION m05_modificarLista(listaId integer, lis_rep_nombre character varying, lis_rep_descripcion character varying, list_rep_img character varying)
RETURNS BOOLEAN AS 
$BODY$
BEGIN
UPDATE LISTA_REPRODUCCION SET "lis_rep_nombre"=$2, "lis_rep_descripcion"=$3, "lis_rep_img"=$4
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

CREATE OR REPLACE FUNCTION public.m05_eliminarlista(listaid integer)
  RETURNS boolean AS
$BODY$
BEGIN
perform m05_eliminarrelacionvideolista($1);
IF FOUND THEN
  DELETE FROM LISTA_REPRODUCCION
  WHERE "lis_rep_id" = $1;
  IF FOUND THEN
    RETURN TRUE;
  ELSE
    RETURN FALSE;
  END IF;
ELSE
  RETURN FALSE;
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

/*CREATE OR REPLACE FUNCTION public.m05_eliminarlista(listaid integer)
  RETURNS boolean AS
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
  COST 100;*/



-- FUNCION PARA AGREGAR UN VIDEO A UNA LISTA

CREATE OR REPLACE FUNCTION public.m05_agregarVideoLista(idVideo integer, idlista integer)
RETURNS BOOLEAN AS 
$BODY$
BEGIN
INSERT INTO VIDEO_LISTA VALUES ($1, $2);
IF FOUND THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;
$BODY$
LANGUAGE plpgsql VOLATILE
COST 100;

-- FUNCION PARA ELIMINAR UN VIDEO DE UNA LISTA

CREATE OR REPLACE FUNCTION public.m05_eliminarVideoLista(idVideo integer, idlista integer)
RETURNS BOOLEAN AS 
$BODY$
BEGIN
DELETE FROM VIDEO_LISTA
WHERE "id_vid" = $1 AND "id_lis" = $2;
IF FOUND THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END; 
$BODY$ 
LANGUAGE plpgsql VOLATILE
COST 100;


-- FUNCION PARA OBTENER VIDEOS DE UNA LISTA

CREATE OR REPLACE FUNCTION public.m05_obtenervideoslista(IN idlista integer)
  RETURNS TABLE(vid_id integer, vid_titulo character varying, vid_descripcion character varying, vid_imagen character varying, vid_url character varying, vid_fecha date, vid_visitas integer, vid_usuario integer) AS
$BODY$
BEGIN
RETURN QUERY
SELECT  V.vid_id, V.vid_titulo, V.vid_descripcion, V.vid_imagen, V.vid_url, V.vid_fecha, V.vid_visitas, V.vid_usuario
    FROM VIDEO AS V, VIDEO_LISTA AS VL
    WHERE  VL.id_vid = V.vid_id AND VL.id_lis = idlista
    ORDER BY V.vid_fecha DESC;

 
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;

-- FUNCION QUE ELIMINA DE LA TABLA VIDEO_LISTA LAS FILAS CUANDO SE ELIMINA UNA LISTA

CREATE OR REPLACE FUNCTION public.m05_eliminarrelacionvideolista(idlista integer)
  RETURNS boolean AS
$BODY$
BEGIN
DELETE FROM VIDEO_LISTA
WHERE "id_lis" = $1;
IF FOUND THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END; 
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;