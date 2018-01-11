package edu.ucab.desarrollo.viucab.Test.M07_Etiqueta;

import edu.ucab.desarrollo.viucab.common.entities.Entity;
import edu.ucab.desarrollo.viucab.common.entities.EntityFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.Command;
import edu.ucab.desarrollo.viucab.domainLogicLayer.CommandsFactory;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.ConsultarVideos;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.EliminarEtiqueta;
import edu.ucab.desarrollo.viucab.domainLogicLayer.M07_Etiquetas.InsertarEtiqueta;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class M07_TestEtiqueta {

    @Test
    public void testInsertarEtiqueta(){
        Entity etiquetaObject = EntityFactory.insertEtiqueta("*testInsertarEtiqueta", 1);
        Command commandEtiqueta = CommandsFactory.instanciateInsertEtiqueta(etiquetaObject);
        InsertarEtiqueta cmd = (InsertarEtiqueta) commandEtiqueta;
        cmd.execute();
        Entity result = cmd.Return();
        Assert.assertNotNull(result);
    }

    @Test
    public void testConsultarVideos(){
        Entity etiquetaObject = EntityFactory.consultarVideos(1);
        Command commandEtiqueta = CommandsFactory.instanciateConsultarVideos(etiquetaObject);
        ConsultarVideos cmd = (ConsultarVideos) commandEtiqueta;
        cmd.execute();
        List<Entity> result = cmd.ReturnList();
        Assert.assertTrue(result != null && !result.isEmpty());
    }

    @Test
    public void testEliminarEtiqueta(){
        Entity etiquetaObject = EntityFactory.eliminarEtiqueta(1, "*testInsertarEtiqueta");
        Command commandEtiqueta = CommandsFactory.instanciateEliminarEtiqueta(etiquetaObject);
        EliminarEtiqueta cmd = (EliminarEtiqueta) commandEtiqueta;
        cmd.execute();
        Entity result = cmd.Return();
        Assert.assertNotNull(result);
    }
}
