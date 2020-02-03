package util;

/**
 *
 * @author limam
 */
import java.io.*;
import java.util.*;

////////////////////////////////////////////////
public class Tree {

    private No root; // raiz

    public Tree() {
        root = null;
    } // inicializa arvore

    public void inserir(Comparable dados) {
        No novo = new No(dados); // cria um novo Nó
        novo.setData(dados); // atribui o valor recebido ao item de dados do Nó
        novo.setRight(null);
        novo.setLeft(null);

        if (root == null) {
            root = novo;
        } else { // se nao for a raiz
            No atual = root;
            No anterior;
            while (true) {
                anterior = atual;
                if (atual.getData().compareTo(dados) < 0 || atual.getData().compareTo(dados) == 0) { // ir para esquerda
                    atual = atual.getLeft();
                    if (atual == null) {
                        anterior.setLeft(novo);
                        return;
                    }
                } // fim da condição ir a esquerda
                else if (atual.getData().compareTo(dados) > 0 ) { // ir para direita
                    atual = atual.getRight();
                    if (atual == null) {
                        anterior.setRight(novo);
                        return;
                    }
                } // fim da condição ir a direita
            } // fim do laço while
        } // fim do else não raiz

    }

    public No buscar(Comparable dados) {
        if (root == null) {
            return null; // se arvore vazia
        }
        No atual = root;  // começa a procurar desde raiz
        while (atual.getData().compareTo(dados) != 0) { // enquanto nao encontrou
            if (atual.getData().compareTo(dados) < 0) {
                atual = atual.getLeft(); // caminha para esquerda
            } else if (atual.getData().compareTo(dados) > 0) {
                atual = atual.getRight(); // caminha para direita
            }
            if (atual == null) {
                return null; // encontrou uma folha -> sai
            }
        } // fim laço while
        return atual; // terminou o laço while e chegou aqui é pq encontrou item
    }

    public boolean remover(Comparable dados) {
        if (root == null) {
            return false; // se arvore vazia
        }
        No atual = root;
        No pai = root;
        boolean filho_esq = true;

        // ****** Buscando o valor **********
        while (atual.getData().compareTo(dados) != 0) { // enquanto nao encontrou
            pai = atual;
            if (atual.getData().compareTo(dados) < 0) { // caminha para esquerda
                atual = atual.getLeft();
                filho_esq = true; // é filho a esquerda? sim
            } else if (atual.getData().compareTo(dados) > 0) { // caminha para direita
                atual = atual.getRight();
                filho_esq = false; // é filho a esquerda? NAO
            }
            if (atual == null) {
                return false; // encontrou uma folha -> sai
            }
        } // fim laço while de busca do valor

    // **************************************************************
        // se chegou aqui quer dizer que encontrou o valor (v)
        // "atual": contem a referencia ao No a ser eliminado
        // "pai": contem a referencia para o pai do No a ser eliminado
        // "filho_esq": é verdadeiro se atual é filho a esquerda do pai
        // **************************************************************
        // Se nao possui nenhum filho (é uma folha), elimine-o
        if (atual.getLeft() == null && atual.getRight() == null) {
            if (atual == root) {
                root = null; // se raiz
            } else if (filho_esq) {
                pai.setLeft(null); // se for filho a esquerda do pai
            } else {
                pai.setRight(null); // se for filho a direita do pai
            }
        } // Se é pai e nao possui um filho a direita, substitui pela subarvore a direita
        else if (atual.getRight() == null) {
            if (atual == root) {
                root = atual.getLeft(); // se raiz
            } else if (filho_esq) {
                pai.setLeft(atual.getLeft()); // se for filho a esquerda do pai
            } else {
                pai.setRight(atual.getLeft()); // se for filho a direita do pai
            }
        } // Se é pai e nao possui um filho a esquerda, substitui pela subarvore a esquerda
        else if (atual.getLeft() == null) {
            if (atual == root) {
                root = atual.getRight(); // se raiz
            } else if (filho_esq) {
                pai.setLeft(atual.getRight());// se for filho a esquerda do pai
            } else {
                pai.setRight(atual.getRight()); // se for  filho a direita do pai
            }
        } // Se possui mais de um filho, se for um avô ou outro grau maior de parentesco
        else {
            No sucessor = no_sucessor(atual);
            // Usando sucessor que seria o Nó mais a esquerda da subarvore a direita do No que deseja-se remover
            if (atual == root) {
                root = sucessor; // se raiz
            } else if (filho_esq) {
                pai.setLeft(sucessor);  // se for filho a esquerda do pai
            } else {
                pai.setRight(sucessor); // se for filho a direita do pai
            }
            sucessor.setLeft(atual.getLeft());  // acertando o ponteiro a esquerda do sucessor agora que ele assumiu 
            // a posição correta na arvore   
        }

        return true;
    }

    // O sucessor é o Nó mais a esquerda da subarvore a direita do No que foi passado como parametro do metodo
    public No no_sucessor(No apaga) { // O parametro é a referencia para o No que deseja-se apagar
        No paidosucessor = apaga;
        No sucessor = apaga;
        No atual = apaga.getRight(); // vai para a subarvore a direita

        while (atual != null) { // enquanto nao chegar no Nó mais a esquerda
            paidosucessor = sucessor;
            sucessor = atual;
            atual = atual.getLeft(); // caminha para a esquerda
        }
     // *********************************************************************************
        // quando sair do while "sucessor" será o Nó mais a esquerda da subarvore a direita
        // "paidosucessor" será o o pai de sucessor e "apaga" o Nó que deverá ser eliminado
        // *********************************************************************************
        if (sucessor != apaga.getRight()) { // se sucessor nao é o filho a direita do Nó que deverá ser eliminado
            paidosucessor.setLeft(sucessor.getRight()); // pai herda os filhos do sucessor que sempre serão a direita
            // lembrando que o sucessor nunca poderá ter filhos a esquerda, pois, ele sempre será o
            // Nó mais a esquerda da subarvore a direita do Nó apaga.
            // lembrando também que sucessor sempre será o filho a esquerda do pai

            sucessor.setRight(apaga.getRight()); // guardando a referencia a direita do sucessor para 
            // quando ele assumir a posição correta na arvore
        }
        return sucessor;
    }

    public void caminhar() {
        System.out.print("\n Exibindo em ordem: ");
        inOrder(root);
    }
    
    public No getRoot(){
        return this.root;
    }
    public void inOrder(No atual) {
        if (atual != null) {
            inOrder(atual.getLeft());
            System.out.println(atual.getData().toString() + " ");
            inOrder(atual.getRight());
        }
    }

    public void preOrder(No atual) {
        if (atual != null) {
            System.out.print(atual.getData() + " ");
            preOrder(atual.getLeft());
            preOrder(atual.getRight());
        }
    }

    public void posOrder(No atual) {
        if (atual != null) {
            posOrder(atual.getLeft());
            posOrder(atual.getRight());
            System.out.print(atual.getData() + " ");
        }
    }

    public int altura(No atual) {
        if (atual == null || (atual.getLeft() == null && atual.getRight() == null)) {
            return 0;
        } else {
            if (altura(atual.getLeft()) > altura(atual.getRight())) {
                return (1 + altura(atual.getLeft()));
            } else {
                return (1 + altura(atual.getRight()));
            }
        }
    }

    public int folhas(No atual) {
        if (atual == null) {
            return 0;
        }
        if (atual.getLeft() == null && atual.getRight() == null) {
            return 1;
        }
        return folhas(atual.getLeft()) + folhas(atual.getRight());
    }

    public int contarNos(No atual) {
        if (atual == null) {
            return 0;
        } else {
            return (1 + contarNos(atual.getLeft()) + contarNos(atual.getRight()));
        }
    }

    public No min() {
        No atual = root;
        No anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.getRight();
        }
        return anterior;
    }

    public No max() {
        No atual = root;
        No anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.getLeft();
        }
        return anterior;
    }
}
////////////////////////////////////////////////
class AarvoreBinariaApp {
  public static void main(String[] args) {
    Scanner le = new Scanner(System.in);
    Tree arv = new Tree();
    int opcao;
    String nome = "Olavo Bilac";
    
    System.out.print("\n Programa Arvore binaria");
    do {
        System.out.print("\n***********************************");
        System.out.print("\nEntre com a opcao:");
	System.out.print("\n ----1: Inserir");
	System.out.print("\n ----2: Excluir");
	System.out.print("\n ----3: Pesquisar");
	System.out.print("\n ----4: Exibir");
	System.out.print("\n ----5: Sair do programa");
	System.out.print("\n***********************************");
	System.out.print("\n-> ");
	opcao = le.nextInt();
	switch(opcao) {
	 	case 1: {
		       System.out.print("\n Informe o Autor -> ");
		       nome = le.next();
		       arv.inserir(nome);
		       break;
		}
		case 2: {
		       System.out.print("\n Informe o Autor -> ");
                       nome = le.next();
		       if ( !arv.remover(nome) )
                          System.out.print("\n Nome não encontrado!");;
		       break;
		}
		case 3: {
		       System.out.print("\n Informe o Autor -> ");
                       nome = le.next();
	      	       if( arv.buscar(nome) != null )
		          System.out.print("\n Nome encontrado");
		       else 
		          System.out.print("\n Nome nao encontrado!");
		       break;
		}	 
		case 4: {
		      arv.caminhar();
		      break; 
		}
        } // fim switch
    } while(opcao != 5);

  }
}