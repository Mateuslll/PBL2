/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.LinkedList;

/*
   * A classe <b>Autor</b> responsável para pegar e salvar o nome do autor.
   * @author Mateus Lima
   * @since fev 2019
   * @version 2.0
 */
public class Autor implements Comparable{
    private String nome;
    private LinkedList<Livro> livro;

    public Autor(String nome) {
        this.nome = nome;
        this.livro = new LinkedList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
    /*
    *Este metodo é utilizado para comparar objetos do tipo autor .
    */
    public LinkedList<Livro> getLivro() {
        return livro;
    }

    public void setLivro(LinkedList<Livro> livro) {
        this.livro = livro;
    }
    
    /*
    *Este metodo é utilizado para comparar objetos do tipo autor .
    */
    @Override
    public int compareTo(Object o) {
        Autor a = (Autor)o;  
        if(this.getLivro().size() > a.getLivro().size()){  
            return 1;
        }
        else if (this.getLivro().size() < a.getLivro().size()){
            return -1;
        }
        else
            return 0;
    }
   
    
}
