CREATE SEQUENCE id_etiquetas;
ALTER TABLE etiqueta ALTER COLUMN eti_id SET DEFAULT nextval('id_etiquetas');