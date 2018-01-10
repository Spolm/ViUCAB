

CREATE OR REPLACE FUNCTION public.m08_get_suscripciones(
	id_usuario integer)
    RETURNS TABLE(idusuario integer, nombreusuario character varying, imagenusuario character varying) 
    LANGUAGE 'plpgsql'

    COST 100
    STABLE 
    ROWS 1000
AS $BODY$
  
DECLARE 
	var_r record; 
BEGIN  
for var_r in(select u.usu_id, u.usu_login, u.usu_avatar from usuario u 
            where (u.usu_id in (select s.id_suscripcion from usuario us, suscripcion s where (id_usuario=s.id_suscriptor)))) 
loop 
    idusuario     := var_r.usu_id;
    nombreusuario := var_r.usu_login; 
    imagenusuario := var_r.usu_avatar; 
    return next; 
     
end loop;     

END;  

$BODY$;


CREATE OR REPLACE FUNCTION public.m08_get_usuarios()
    RETURNS TABLE(idusuario integer, nombreusuario character varying, tokenusuario character varying) 
    LANGUAGE 'plpgsql'

    COST 100
    STABLE 
    ROWS 1000
AS $BODY$
  
DECLARE 
	var_r record; 
BEGIN  
for var_r in(select usu_id, usu_login, usu_token from usuario) 
loop 
    idusuario     := var_r.usu_id;
    nombreusuario := var_r.usu_login; 
    tokenusuario := var_r.usu_token; 
    return next; 
     
end loop;     

END;  

$BODY$;

CREATE OR REPLACE FUNCTION public.m08_set_subscritor(
	idsuscriptor integer,
	idsuscripcion integer)
    RETURNS void
    LANGUAGE 'plpgsql'

AS $BODY$

DECLARE
BEGIN
     insert into suscripcion (id_suscriptor, id_suscripcion) values (idsuscriptor,idsuscripcion);
END; 
$BODY$;


CREATE OR REPLACE FUNCTION public.m08_update_subscritor(
	idsuscriptor integer,
	idsuscripcion integer)
    RETURNS void
    LANGUAGE 'plpgsql'
    
AS $BODY$

DECLARE
BEGIN
    delete from suscripcion where id_suscriptor=idsuscriptor and id_suscripcion=idsuscripcion;
           
END; 
$BODY$;