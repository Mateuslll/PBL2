
package util;

public final class No{
    private Comparable data;
    private No esquerda;
    private No direita;
    private No pai;
    

    
    
    public No(Comparable data) {
        this.data = data;
        setLeft(null);
        setRight(null);
        setPai(null);        
    }
  
    
    public Comparable getData() {
        return data;
    }

  
    public void setData(Comparable data) {
        this.data = data;
    }

   
    public No getPai() {
        return pai;
    }

   
    public void setPai(No pai) {
        this.pai = pai;
    }

    
    public No getRight() {
        return direita;
    }

  
    public void setRight(No direita) {
        this.direita = direita;
    }

    public No getLeft() {
        return esquerda;
    }

    public void setLeft(No esquerda) {
        this.esquerda = esquerda;
    }


    
}
