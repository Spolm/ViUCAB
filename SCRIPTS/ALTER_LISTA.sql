ALTER TABLE LISTA_REPRODUCCION ALTER COLUMN LIS_REP_IMG  DROP  NOT NULL;
ALTER TABLE LISTA_REPRODUCCION ALTER COLUMN LIS_REP_IMG TYPE varchar(500);
ALTER TABLE LISTA_REPRODUCCION ALTER COLUMN lis_rep_fecha TYPE varchar(20);
CREATE SEQUENCE id_lista;
ALTER TABLE LISTA_REPRODUCCION ALTER COLUMN LIS_REP_ID SET DEFAULT nextval('id_lista');