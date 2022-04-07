package arvore.modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class Arvore {

    //Atributo raiz do Nodo
    public Nodo raiz;

    //Método que insere um Nodo na Arvore
    public void inserir(Nodo novo) {
        //se não houver raiz, seta a raiz
        if (raiz == null) {
            this.raiz = novo;
            System.out.println("inserindo a raiz " + this.raiz.numero);
        } else {
            Nodo aux = raiz;
            //enquanto aux for diferente de null
            while (aux != null) {
                //se o numero do nodo parametro for menor que o numero nodo aux
                if (novo.numero < aux.numero) {
                    //se a esquerda do aux estiver vazia, seta o nodo na esquerda do aux
                    if (aux.esquerda == null) {
                        aux.esquerda = novo;
                        System.out.println("inserindo " + novo.numero + " a esquerda de " + aux.numero);
                        break;
                    }
                    //novo valor para o nodo aux
                    aux = aux.esquerda;
                } else {
                    //senao, se a direita do nodo aux for null, set nodo parametro na direita do nodo aux
                    if (aux.direita == null) {
                        aux.direita = novo;
                        System.out.println("inserindo " + novo.numero + " a direita de " + aux.numero);
                        break;
                    }
                    //novo valor para o nodo aux
                    aux = aux.direita;
                }
            }
            //seta quem é o nodo pai do nodo mais recente inserido
            novo.pai = aux;
        }
    }

    //método em forma de pilha(recursao) para trazer os vares da arvore de forma prefixada
    public void arvorePrefixado(Nodo nodo){
        //se nodo nao for null
        if(nodo != null){
            //printa o numero do nodo
            System.out.print(nodo.numero + " ");
            //faz uma recursao passando o nodo atual.esquerda como novo valor até ser null
            arvorePrefixado(nodo.esquerda);
            //faz uma recursao passando o nodo atual.direita como novo valor até ser null
            arvorePrefixado(nodo.direita);
        }
    }

    //método em forma de pilha para trazer os vares da árvore de forma posfixada
    public void arvorePosfixado(Nodo nodo){
        if(nodo != null){
            //faz uma recursao passando o nodo atual.esquerda como novo valor até ser null
            arvorePosfixado(nodo.esquerda);
            //faz uma recursao passando o nodo atual.direita como novo valor até ser null
            arvorePosfixado(nodo.direita);
            //printa o numero do nodo
            System.out.print(nodo.numero + " ");
        }
    }

    //método em forma de pilha para trazer os vares da arvore em ordem
    public void arvoreEmOrdem(Nodo nodo) {
        if(nodo != null){
            //faz uma recursao passando o nodo atual.esquerda como novo valor até ser null
            arvoreEmOrdem(nodo.esquerda);
            //printa o numero do nodo
            System.out.print(nodo.numero + " ");
            //faz uma recursao passando o nodo atual.direita como novo valor até ser null
            arvoreEmOrdem(nodo.direita);
        }
    }

    public static void nivel(Nodo nodo){
        if(nodo == null){
            System.out.println("Fila não existente.");
        } else{
            Deque<Nodo> fila = new ArrayDeque<>();
            fila.add(nodo);
            while(!fila.isEmpty()){
                Nodo atual = fila.removeFirst();

                System.out.println(atual.numero + ", ");
                if(atual.esquerda != null){
                    fila.add(atual.esquerda);
                }
                if(atual.direita != null){
                    fila.add(atual.direita);
                }
            }
        }
    }

    //Metodo que retorna onde está o nodo com aquele número
    public Nodo pesquisar(int numero) {
        Nodo aux = raiz;
        while (aux != null) {
            if (aux.numero == numero) {
                return aux;
            } else if (numero < aux.numero) {
                aux = aux.esquerda;
            } else {
                aux = aux.direita;
            }
        }
        return null;
    }
}
