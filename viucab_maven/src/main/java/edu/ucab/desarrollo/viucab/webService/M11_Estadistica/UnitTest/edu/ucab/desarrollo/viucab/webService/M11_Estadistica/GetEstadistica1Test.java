package edu.ucab.desarrollo.viucab.webService.M11_Estadistica;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Estadistica;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.GetEstadistica1;
import org.junit.jupiter.api.Test;


import static junit.framework.TestCase.assertNotNull;


/**
 * Created by Daniel on 26/12/2017.
 */
class GetEstadistica1Test {
    @Test
    void execute() throws VIUCABException {

        Entity estadistica = EntityFactory.estadistica("pepe");
        Command command = CommandsFactory.instanciateEstadistica1(estadistica);
        GetEstadistica1 cmd = (GetEstadistica1) command;
        cmd.execute();
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        assertNotNull(json);
    }



}