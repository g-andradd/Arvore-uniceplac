package arvore.teste;

import arvore.modelo.Arvore;
import arvore.modelo.Nodo;

import java.util.Scanner;

public class TestaNodo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int recebeNodo;
        int numero = 0;
        int i = 0;

        Arvore arvore = new Arvore();

        System.out.println("Digite quantos nodos deseja inserir");
        numero = input.nextInt();

        for(i = 0; i <= numero; i++){
            System.out.println("Digite um número");
            recebeNodo = input.nextInt();
            Nodo nodo = new Nodo(recebeNodo);
            arvore.inserir(nodo);
        }

        System.out.println("Arvore préfixado:");
        arvore.preOrdem(arvore.raiz);
        System.out.println();
        System.out.println("Arvore em ordem:");
        arvore.emOrdem(arvore.raiz);
        System.out.println();
        System.out.println("Arvore pósfixado:");
        arvore.posOrdem(arvore.raiz);

    }
}
