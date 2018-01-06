CREATE OR REPLACE  FUNCTION M10_AddWater( tm timestamp, gt integer, fkP integer,
                                 OUT res integer)
AS $$
DECLARE  
max integer;
BEGIN
		
	INSERT INTO glass_historic(
	 GLASSTIME, GLASSTYPE, fk_person)
	VALUES ( tm, gt, fkp);

    

    res = (SELECT Count(t.glasshistoricid) FROM glass_historic as t WHERE DATE(t.GLASSTIME) = DATE(tm) and fk_person = fkp);

END;
$$ LANGUAGE plpgsql VOLATILE;