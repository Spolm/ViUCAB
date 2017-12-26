package edu.ucab.desarrollo.viucab.webService.M11_Estadistica;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Estadistica;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.GetEstadistica3;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertNotNull;


/**
 * Created by Daniel on 26/12/2017.
 */
class GetEstadistica3Test {
    @Test
    void execute() throws VIUCABException {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica3(estadisticaObject);
        GetEstadistica3 cmd = (GetEstadistica3) commandEstadistica;

            cmd.execute();

        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        assertNotNull(json);
    }

}