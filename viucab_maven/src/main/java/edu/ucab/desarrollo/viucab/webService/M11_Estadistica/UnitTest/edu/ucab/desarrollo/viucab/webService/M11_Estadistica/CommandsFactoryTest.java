package edu.ucab.desarrollo.viucab.webService.M11_Estadistica;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.common.entities.Estadistica;
import edu.ucab.desarrollo.viucab.common.exceptions.VIUCABException;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M11.*;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;


import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Daniel on 26/12/2017.
 */

class CommandsFactoryTest {


    @Test
    void instanciateEstadistica1() {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica1(estadisticaObject);
        GetEstadistica1 cmd = (GetEstadistica1) commandEstadistica;
        try {
            cmd.execute();
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        assertNotNull(json);

    }

    @Test
    void instanciateEstadistica2() {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica2(estadisticaObject);
        GetEstadistica2 cmd = (GetEstadistica2) commandEstadistica;
        try {
            cmd.execute();
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        assertNotNull(json);
    }

    @Test
    void instanciateEstadistica3() {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica3(estadisticaObject);
        GetEstadistica3 cmd = (GetEstadistica3) commandEstadistica;
        try {
            cmd.execute();
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        assertNotNull(json);
    }

    @Test
    void instanciateEstadistica4() {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica4(estadisticaObject);
        GetEstadistica4 cmd = (GetEstadistica4) commandEstadistica;
        try {
            cmd.execute();
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        assertNotNull(json);
    }

    @Test
    void instanciateEstadistica5() {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica5(estadisticaObject);
        GetEstadistica5 cmd = (GetEstadistica5) commandEstadistica;
        try {
            cmd.execute();
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        assertNotNull(json);
    }

    @Test
    void instanciateEstadistica6() {
        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica6(estadisticaObject);
        GetEstadistica6 cmd = (GetEstadistica6) commandEstadistica;
        try {
            cmd.execute();
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        assertNotNull(json);
    }

    @Test
    void instanciateEstadistica7() {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica7(estadisticaObject);
        GetEstadistica7 cmd = (GetEstadistica7) commandEstadistica;
        try {
            cmd.execute();
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        assertNotNull(json);
    }

    @Test
    void instanciateEstadistica8() {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica8(estadisticaObject);
        GetEstadistica8 cmd = (GetEstadistica8) commandEstadistica;
        try {
            cmd.execute();
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        assertNotNull(json);
    }

    @Test
    void instanciateEstadistica9() {

        Entity estadisticaObject = EntityFactory.estadistica("pepe");
        Command commandEstadistica = CommandsFactory.instanciateEstadistica9(estadisticaObject);
        GetEstadistica9 cmd = (GetEstadistica9) commandEstadistica;
        try {
            cmd.execute();
        } catch (VIUCABException e) {
            e.printStackTrace();
        }
        Entity result = cmd.Return();
        Estadistica json = (Estadistica) result;
        assertNotNull(json);
    }

}