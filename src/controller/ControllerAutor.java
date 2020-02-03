/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.LinkedList;
import model.Autor;
import model.Livro;
import util.No;
import util.Tree;

 /**
     *
     * A classe <b>ControllerAutor</b> responsável por gerenciar os autores na arvore.
     * @author Mateus Lima
     * @since fev 2019
     * @version 2.0
     */
public class ControllerAutor {

    ControllerArvore controlerArvore;
    LinkedList<Autor> listaAutores;

    public ControllerAutor(ControllerArvore control) {
        listaAutores = new LinkedList();
        controlerArvore = control;
    }
    /**
     * esse metodo retorna todos os autores presentes na arvore
     * @return retorna uma lista de contem todos os autores da arvore
     * 
     */
    public LinkedList autores() {
        Tree arvoreAutor = controlerArvore.getTreeAuthor();
        return this.inOrder(arvoreAutor.getRoot());
    }
    /**
     * 
     * @return retorna uma lista de contem todos os autores da arvore
     * metodo para percorrer a arvore de autores
     */
    private LinkedList inOrder(No atual) {

        if (atual != null) {
            inOrder(atual.getLeft());
            Autor autor = (Autor) atual.getData();
            listaAutores.add(autor);
            inOrder(atual.getRight());
        }

        return listaAutores;
    }
}
