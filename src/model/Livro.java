/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/*
   * 
   * @author Mateus Lima
   * @since fev 2019
   * @version 2.0
   * A classe <b>Livro</b> responsavel por pegar e salvar numero de ebook, titulo , autor, mes , ano e link do livro.
 */
public class Livro implements Comparable{
    private int numEbook;
    private String autor;
    private String mes;
    private int ano;
    private String titulo; 
    public Livro(int numEbook, String titulo, String autor, String mes, int ano, String link) {
        this.numEbook = numEbook;
        this.autor = autor;
        this.mes = mes;
        this.ano = ano;
        this.link = link;
        this.titulo = titulo;
    }
    
    public Livro(){
        
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public int getNumEbook() {
        return numEbook;
    }

    public void setNumEbook(int numEbook) {
        this.numEbook = numEbook;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    private String link;

    @Override
    public int compareTo(Object o) {
        Livro x = (Livro)o;
        if(this.numEbook > x.getNumEbook()){
            return 1;
        }
        else if (this.numEbook < x.getNumEbook()){
            return -1;
        }
        else
            return 0;
    }
     /*
    *Este metodo é utilizado para comparar objetos do tipo livro .
    */
    @Override
    public String toString(){
        return "Número do Ebook: "+ this.numEbook+" Título: "+ this.titulo+" Autor: "+this.autor;
    }
}

