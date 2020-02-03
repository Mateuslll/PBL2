/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import model.Livro;
import util.No;
import util.Tree;

/*
   * A classe <b>ControllerLivros</b> responsável por gerenciar buscas, listagens e adição de exemplares na arvore.
   * @author Mateus Lima
   * @since fev 2019
   * @version 2.0
 */
public class ControllerLivros {

    LinkedList<Livro> listaLivros;
    ControllerArvore controllerArvore;
    LinkedList<Livro> listaBuscaAno;
    public ControllerLivros(ControllerArvore control) {
        listaLivros = new LinkedList();
        controllerArvore = control;
        listaBuscaAno = new LinkedList();
    }
     /**
     *@param numBook - Numero do livro, String titulo - Titulo do Livro, String autor - Autor do livro, String mes - Mes de publicação, int ano - numero do ano do livro, String linkLivro - Link do Livro
     *Esse metodo adiciona os livros na estrutura de dados
     */
    public void AdicionarLivros(int numBook, String titulo, String autor, String mes, int ano, String linkLivro) throws IOException {

        File arquivoCSV = new File("C:\\Users\\limam\\Documents\\arq_pbl\\entrada.txt");
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\limam\\Documents\\arq_pbl\\entrada.txt", true));
            bw.write(numBook + ";" + titulo + ";" + autor + ";" + mes + ";" + ano + ";" + linkLivro);
            bw.newLine();
            bw.close();
            Livro livro = new Livro(numBook, titulo, autor, mes, ano, linkLivro);
            controllerArvore.getTreeBook().inserir(livro);
        } catch (FileNotFoundException e) {

        }
    }
    /**
     *@param numBook - Numero do livro
     *@return Retorna o livro buscado
     * 
     */
    public Livro buscarLivroEbook(int numEbook){
       Tree b = controllerArvore.getTreeBook();
       Livro a = new Livro();
       a.setNumEbook(numEbook);
       No c = b.buscar(a);  
       if(c != null){
           return (Livro) c.getData();
       }else
         return null;
    }
    
    /**
     *@param Ano - Numero do livro
     *@return Retorna o livro buscado
     * @/see Este metodo utiliza o método inOrder para realizar a busca na arvore
     */
    
    public LinkedList buscarLivroAno(int ano){
        Tree b = controllerArvore.getTreeBook();
        return this.inOrder(b.getRoot(), ano);
        
    }
    private LinkedList inOrder(No atual, int ano) {
        if (atual != null) {
            inOrder(atual.getLeft(), ano);
            Livro livro = (Livro) atual.getData();
            if(livro.getAno() == ano){
                listaBuscaAno.add(livro);
            }
            inOrder(atual.getRight(), ano);
        }
        return listaBuscaAno;
    }
    /**
     *@param numEbook - Numero do livro
     *@return Retorna o livro excluido que foi requisitado 
     * 
     */
    public boolean excluirLivro(int numEbook){
        Livro livro = new Livro();
        livro.setNumEbook(numEbook);
        return controllerArvore.getTreeBook().remover(livro);   
    }
   
    
}
