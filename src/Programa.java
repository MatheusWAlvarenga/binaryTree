public class Programa {

  public static void main(String[] args) {
    Arvore<Integer> arvore = new Arvore<Integer>();
    arvore.adicionar(15);
    arvore.adicionar(34);
    arvore.adicionar(2);
    arvore.adicionar(13);
    arvore.adicionar(155);
    arvore.adicionar(166);
    arvore.adicionar(23);
    arvore.adicionar(300);

    System.out.println("\n\nEm-ordem");
    arvore.emOrdem(arvore.getRaiz());


    System.out.println("\n\nPré-ordem");
    arvore.preOrdem(arvore.getRaiz());

    System.out.println("\n\nPós-ordem");
    arvore.posOrdem(arvore.getRaiz());


  }
}