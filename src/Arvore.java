public class Arvore<TIPO extends Comparable> {

  private No<TIPO> raiz;

  public Arvore(){
    this.raiz = null;
  }

  public void adicionar(TIPO valor){
    No<TIPO> novoNo = new No<TIPO>(valor);
    if (raiz == null){
      this.raiz = novoNo;
    }else{
      No<TIPO> atual = this.raiz;
      while(true){
        if (novoNo.getValor().compareTo(atual.getValor()) == -1){
          if (atual.getEsquerda() != null){
            atual = atual.getEsquerda();
          }else{
            atual.setEsquerda(novoNo);
            break;
          }
        }else{ //se for maior ou igual
          if (atual.getDireita() != null){
            atual = atual.getDireita();
          }else{
            atual.setDireita(novoNo);
            break;
          }
        }
      }
    }
  }

  public No<TIPO> getRaiz() {
    return raiz;
  }

  public void emOrdem(No<TIPO> atual){
    if (atual != null){
      emOrdem(atual.getEsquerda());
      System.out.println(atual.getValor());
      emOrdem(atual.getDireita());
    }
  }

  public void preOrdem(No<TIPO> atual){
    if (atual != null){
      System.out.println(atual.getValor());
      preOrdem(atual.getEsquerda());
      preOrdem(atual.getDireita());
    }
  }

  public void posOrdem(No<TIPO> atual){
    if (atual != null){
      posOrdem(atual.getEsquerda());
      posOrdem(atual.getDireita());
      System.out.println(atual.getValor());
    }
  }

  public boolean remover(TIPO valor){
    //buscar o No na árvore
    No<TIPO> atual = this.raiz;
    No<TIPO> paiAtual = null;
    while(atual != null){
      if (atual.getValor().equals(valor)){
        break;
      }else if (valor.compareTo(atual.getValor()) == -1){ //valor procurado é menor que o atual
        paiAtual = atual;
        atual = atual.getEsquerda();
      }else{
        paiAtual = atual;
        atual = atual.getDireita();
      }
    }
    //verifica se existe o elemento
    if (atual != null){

      //elemento tem 2 filhos ou elemento tem somente filho à direita
      if (atual.getDireita() != null){

        No<TIPO> substituto = atual.getDireita();
        No<TIPO> paiSubstituto = atual;
        while(substituto.getEsquerda() != null){
          paiSubstituto = substituto;
          substituto = substituto.getEsquerda();
        }
        substituto.setEsquerda(atual.getEsquerda());
        if (paiAtual != null){
          if (atual.getValor().compareTo(paiAtual.getValor()) == -1){ //atual < paiAtual
            paiAtual.setEsquerda(substituto);
          }else{
            paiAtual.setDireita(substituto);
          }
        }else{ //se não tem paiAtual, então é a raiz
          this.raiz = substituto;
          paiSubstituto.setEsquerda(null);
          this.raiz.setDireita(paiSubstituto);
          this.raiz.setEsquerda(atual.getEsquerda());
        }

        //removeu o elemento da árvore
        if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1){ //substituto < paiSubstituto
          paiSubstituto.setEsquerda(null);
        }else{
          paiSubstituto.setDireita(null);
        }

      }else if (atual.getEsquerda() != null){ //tem filho só à esquerda
        No<TIPO> substituto = atual.getEsquerda();
        No<TIPO> paiSubstituto = atual;
        while(substituto.getDireita() != null){
          paiSubstituto = substituto;
          substituto = substituto.getDireita();
        }
        if (paiAtual != null){
          if (atual.getValor().compareTo(paiAtual.getValor()) == -1){ //atual < paiAtual
            paiAtual.setEsquerda(substituto);
          }else{
            paiAtual.setDireita(substituto);
          }
        }else{ //se for a raiz
          this.raiz = substituto;
        }

        //removeu o elemento da árvore
        if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1){ //substituto < paiSubstituto
          paiSubstituto.setEsquerda(null);
        }else{
          paiSubstituto.setDireita(null);
        }
      }else{ //não tem filho
        if (paiAtual != null){
          if (atual.getValor().compareTo(paiAtual.getValor()) == -1){ //atual < paiAtual
            paiAtual.setEsquerda(null);
          }else{
            paiAtual.setDireita(null);
          }
        }else{ //é a raiz
          this.raiz = null;
        }
      }

      return true;
    }else{
      return false;
    }
  }
}