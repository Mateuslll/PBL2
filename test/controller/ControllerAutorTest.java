/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author limam
 */
public class ControllerAutorTest {
    
    ControllerArvore controller;
    ControllerAutor controllerAutor;
    
    public ControllerAutorTest(){
        controller = new ControllerArvore();
        controllerAutor = new ControllerAutor(controller);
    }
    
    @Before
    public void setUp() {
     controller.carregarArvoreBook();
     controller.carregarArvoreAutor();
    }
    
    /**
     * Test of autores method, of class ControllerAutor.
     */
    @Test
    public void testListagemLivros() {
        System.out.println("autores");
        LinkedList list = controllerAutor.autores();
        assertNotEquals(list,null);
        assertNotEquals(list.size(),0);
        
        
    }
    
    @Test
    public void testListagemLivrosQuantidade(){
        System.out.println("autores");
        LinkedList list = controllerAutor.autores();
        assertNotEquals(list,null);
        assertNotEquals(list.size(),0);
        
    }
}
