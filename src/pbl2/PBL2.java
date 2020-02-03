/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2;

import controller.ControllerArvore;
import facade.Facade;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import model.Autor;
import util.Tree;

/**
 *
 * @author limam
 */
public class PBL2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner(System.in);
        Facade facade = new Facade();

        int requisitos = 0;

        while (requisitos != 12) {
            System.out.println("Bem vindo ao Sistema de Catalogação de Livros");
            System.out.println("1- Cadastar Livro"
                    + "\n2- Carregar base de dados"
                    + "\n3- Listar autores e quantidade de livros"
                    + "\n4- Listar livros referenciando o autor"
                    + "\n5- Listar livros catalogados"
                    + "\n6- Busca de livros por numero de Ebook"
                    + "\n7- Busca de livros por ano"
                    + "\n8- Exclusão de exemplares");

            System.out.println();
            requisitos = entrada.nextInt();
            System.out.println();
            //entrada dos dados
            //int numBook, String titulo, String autor, String mes, int ano, String linkLivro
            switch (requisitos) {
                case 1:
                    String titulo;
                    String autor;
                    String mes;
                    int ano;
                    int numBook;
                    String LinkLivro;

                    System.out.println("1-Informe o N* do ebook do livro");
                    numBook = entrada.nextInt();
                    System.out.print("Informe o título do ebook: ");
                    titulo = entrada.next();
                    System.out.print("1-Informe o autor do livro: ");
                    autor = entrada.next();
                    System.out.print("Informe o mês de publicação: ");
                    mes = entrada.next();
                    System.out.print("1-Informe o ano de publicação");
                    ano = entrada.nextInt();
                    System.out.println("1-Informe o link do exemplar");
                    LinkLivro = entrada.next();

                    facade.CadastrarLivro(numBook, titulo, autor, mes, ano, LinkLivro);

                    System.out.println();
                    break;
                case 2:
                    //entrada.nextLine();
                    facade.CarregarDados();

                    break;
                case 3:
                    LinkedList lista = facade.ListarAutoresLivrosQuantidade();
                    Iterator it = lista.iterator();
                    while (it.hasNext()) {
                        Autor autorX = (Autor) it.next();
                        int count = autorX.getLivro().size() + 1;
                        System.out.println("Nome do Autor: " + autorX.getNome() + " Quantidade de Livros: " + count);
                    }
                    break;
                case 4:
                    LinkedList listaLivros = facade.ListarAutorLivros();
                    Iterator ita = listaLivros.iterator();
                    while (ita.hasNext()) {
                            Autor autorY = (Autor) ita.next();
                            System.out.println("Nome do Autor: " + autorY.getNome());
                            System.out.println("Livros publicados pelo Autor: ");
                            if (autorY.getLivro().iterator().hasNext()) {
                                System.out.print(autorY.getLivro().iterator().next().toString() + " ");
                            }
                        }
                    case 5:
                        facade.ListarLivros();
                    break;
                case 6:
                    System.out.println("Digite o numero do ebook que quer buscar");
                    numBook = entrada.nextInt();
                    String endereco = facade.BuscarLivro(numBook);
                    if(endereco!=null){
                        System.out.println("Link do livro: "+endereco);
                    }else{
                        System.out.println("Seu livro não foi encontrado");
                    }
                    
                    break;
                case 7:
                    System.out.println("7- Digite o Ano do livro que vc quer buscar");
                    ano = entrada.nextInt();
                    LinkedList listaAno = facade.BuscarLivroPeloAno(ano);
                    if(listaAno.size()==0){
                        System.out.println("Não existe exemplares com esse ano digitado");
                    }else{
                        Iterator ite = listaAno.iterator();
                        while(ite.hasNext()){
                            System.out.println(ite.next().toString());
                        }
                    }
                    break;
                case 8:
                    System.out.println("8- Digite o numero de ebook do respectivo livro que quer excluir");
                    numBook = entrada.nextInt();
                    if(facade.ExcluirLivro(numBook)){
                        System.out.println("Livro Excluido com sucesso!");
                    }
                    break;
                
                default:
                    System.out.println("opção invalida!");
            }
        }
    }
}
