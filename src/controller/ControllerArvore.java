/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import model.Autor;
import model.Livro;
import util.*;

/**
 *A classe <b>ControllerArvore</b> responsável pela inserção dos elementos na árvore.
 * @author Mateus Lima
 * @since fev 2019
 * @version 2.0
 */
public class ControllerArvore {

    Tree treeBook;
    Tree treeAuthor;
    LinkedList<Autor> listAuthor;
    boolean flag = false;

    public ControllerArvore() {
        treeBook = new Tree();
        treeAuthor = new Tree();
        listAuthor = new LinkedList();
        listAuthor.clear();
    }
     /**
     Método que realiza a inserção na árvore dos livros 
     */
    
    public void carregarArvoreBook() {

        File arquivoCSV = new File("C:\\Users\\limam\\Documents\\arq_pbl\\entrada.txt");

        try {

            
            Scanner leitor = new Scanner(arquivoCSV);

          
            String linhasDoArquivo = null;

          
            leitor.nextLine();

            
            while (leitor.hasNext()) {

               
                linhasDoArquivo = leitor.nextLine();

               
                String[] valoresEntreVirgulas = linhasDoArquivo.split(";");
                String Ebook = valoresEntreVirgulas[0];
                int numEbook = Integer.parseInt(Ebook);

                String titulo = valoresEntreVirgulas[1];

                String autor = valoresEntreVirgulas[2];
                Autor a = new Autor(autor);
                String mes = valoresEntreVirgulas[3];

                String StringAno = valoresEntreVirgulas[4];
                int ano = Integer.parseInt(StringAno);

                String link = valoresEntreVirgulas[5];

                Livro livro = new Livro(numEbook, titulo, autor, mes, ano, link);
                System.out.println(livro.toString());
                treeBook.inserir(livro);

                
                Iterator it = listAuthor.iterator();
                while (it.hasNext()) {
                    Autor aut = (Autor) it.next();
                    if (aut.getNome().equals(a.getNome()) == true) {
                        flag = true;
                        aut.getLivro().add(livro);

                    }
                }

                if (flag == false) {
                    listAuthor.add((Autor) a);
                }

                flag = false;
            }
            
        } catch (FileNotFoundException e) {

        }

    }
     /**
     *
     * Carrega os autores na árvore
     */
    public void carregarArvoreAutor() {
        Iterator it = listAuthor.iterator();
        while (it.hasNext()) {
            Autor aut = (Autor) it.next();
            treeAuthor.inserir(aut);
        }
    }
     /**
     *
     * Retorna a arvore onde esta contida os livros
     */
    public Tree getTreeBook() {
        return this.treeBook;
    }
     /**
     *
     * Retorna a arvores onde esta contida os autores
     */
    public Tree getTreeAuthor() {
        return this.treeAuthor;
    }

    
    

}
