/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucab.desarrollo.viucab.webService.M04_Reproductor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AlejandroNegrin
 */
public class M04_ReproductorTest {
    
    public M04_ReproductorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getVideoInfo method, of class M04_Reproductor.
     */
    @Test
    public void testGetVideoInfo() throws Exception {
        System.out.println("getVideoInfo");
        String idvideo = "";
        M04_Reproductor instance = new M04_Reproductor();
        String expResult = "";
        String result = instance.getVideoInfo(idvideo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addVisitaVideo method, of class M04_Reproductor.
     */
    @Test
    public void testAddVisitaVideo() {
        System.out.println("addVisitaVideo");
        String idvideo = "";
        M04_Reproductor instance = new M04_Reproductor();
        String expResult = "";
        String result = instance.addVisitaVideo(idvideo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addComentario method, of class M04_Reproductor.
     */
    @Test
    public void testAddComentario() {
        System.out.println("addComentario");
        String idvideo = "";
        String usuario = "";
        String comentario = "";
        M04_Reproductor instance = new M04_Reproductor();
        String expResult = "";
        String result = instance.addComentario(idvideo, usuario, comentario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateLike method, of class M04_Reproductor.
     */
    @Test
    public void testUpdateLike() {
        System.out.println("updateLike");
        String idvideo = "";
        String usuario = "";
        M04_Reproductor instance = new M04_Reproductor();
        String expResult = "";
        String result = instance.updateLike(idvideo, usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIfLike method, of class M04_Reproductor.
     */
    @Test
    public void testGetIfLike() {
        System.out.println("getIfLike");
        String idvideo = "";
        String usuario = "";
        M04_Reproductor instance = new M04_Reproductor();
        String expResult = "";
        String result = instance.getIfLike(idvideo, usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteComentario method, of class M04_Reproductor.
     */
    @Test
    public void testDeleteComentario() {
        System.out.println("deleteComentario");
        String idcomentario = "";
        M04_Reproductor instance = new M04_Reproductor();
        String expResult = "";
        String result = instance.deleteComentario(idcomentario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
