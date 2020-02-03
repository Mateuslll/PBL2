/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controller.ControllerArvore;
import controller.ControllerAutor;
import controller.ControllerLivros;
import java.io.IOException;
import java.util.LinkedList;
import model.Livro;

/**
 
 */
public class Facade {

    ControllerArvore controllerArvore;
    ControllerAutor controllerAutor;
    ControllerLivros controllerLivro;

    public Facade() {
        this.controllerArvore = new ControllerArvore();
        this.controllerAutor = new ControllerAutor(controllerArvore);
        this.controllerLivro = new ControllerLivros(controllerArvore);
    }

    public void CadastrarLivro(int numBook, String titulo, String autor, String mes, int ano, String linkLivro) throws IOException {
        controllerLivro.AdicionarLivros(numBook, titulo, autor, mes, ano, linkLivro);
    }

    public void CarregarDados() {
        controllerArvore.carregarArvoreBook();
        controllerArvore.carregarArvoreAutor();
    }

    public LinkedList ListarAutoresLivrosQuantidade() {
        return controllerAutor.autores();
    }

    public LinkedList ListarAutorLivros() {
        return controllerAutor.autores();
    }

    public void ListarLivros() {
        controllerArvore.getTreeBook().caminhar();
    }

    public String BuscarLivro(int numEbook) {
        Livro livro = controllerLivro.buscarLivroEbook(numEbook);
        if (livro != null) {
            return livro.getLink();
        }
        return null;
    }

    public LinkedList BuscarLivroPeloAno(int ano) {
        return controllerLivro.buscarLivroAno(ano);
    }

    public boolean ExcluirLivro(int numEbook) {
        return controllerLivro.excluirLivro(numEbook);
    }
}
