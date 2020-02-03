/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.LinkedList;
import model.Livro;
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
public class ControllerLivrosTest {

    ControllerArvore controller;
    ControllerLivros controllerLivro;

    public ControllerLivrosTest() {
        controller = new ControllerArvore();
        controllerLivro = new ControllerLivros(controller);

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        controller.carregarArvoreBook();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of AdicionarLivros method, of class ControllerLivros.
     */
    @Test
    public void testAdicionarLivros() throws Exception {

        System.out.println("AdicionarLivros");
        int numBook = 0;
        String titulo = "TituloTeste";
        String autor = "Marco Pena";
        String mes = "maio";
        int ano = 2012;
        String linkLivro = "https: www.adicionalivrosteste.com";
        controllerLivro.AdicionarLivros(numBook, titulo, autor, mes, ano, linkLivro);
        assertNotEquals(controllerLivro.buscarLivroEbook(numBook), null);

    }

    /**
     * livro usado como teste Número do Ebook: 408064 Título: Cass Timberlane
     * Autor: Sinclair Lewis Test of buscarLivroEbook method, of class
     * ControllerLivros. Número do Ebook: 169562 Título: Men Women and Guns
     * Autor: Sapper
     */
    @Test
    public void testBuscarLivroEbook() {
        System.out.println("buscarLivroEbook");
        Livro result = controllerLivro.buscarLivroEbook(408064);
        assertEquals(408064, result.getNumEbook());
        assertEquals("Cass Timberlane", result.getTitulo());
        assertEquals("Sinclair Lewis", result.getAutor());

        Livro result1 = controllerLivro.buscarLivroEbook(169562);
        assertEquals(169562, result1.getNumEbook());
        assertEquals("Men Women and Guns", result1.getTitulo());
        assertEquals("Sapper", result1.getAutor());

    }

    /**
     * Test of buscarLivroAno method, of class ControllerLivros.
     */
    @Test
    public void testBuscarLivroAno() {
        System.out.println("buscarLivroAno");
        LinkedList list = controllerLivro.buscarLivroAno(2010);
        assertNotEquals(list.size(), 0);
        assertEquals(list.size(), 11);
    }

    /**
     * Test of excluirLivro method, of class ControllerLivros.
     */
    @Test
    public void testExcluirLivro() {
        System.out.println("excluirLivro");
        Livro exemplar = new Livro();
        exemplar.setNumEbook(334336);
        boolean flag = controllerLivro.excluirLivro(408064);
        assertEquals(flag, true);

        Livro result = controllerLivro.buscarLivroEbook(408064);
        assertEquals(result, null);

    }
}
