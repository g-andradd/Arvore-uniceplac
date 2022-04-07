package arvore.modelo;

public class Nodo {

    //atributos do Nodo
    public int numero;
    public Nodo esquerda;
    public Nodo direita;
    public Nodo pai;

    //Contrutor do Nodo
    public Nodo(int numero) {
        this.numero = numero;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;

    }
}
