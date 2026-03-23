public class Fila {
    // atributos
    int inicio;
    int fim;
    int tamanho;
    int capacidade;  // total maximo de itens do array 
    int[] itens;
    
    // construtor
    Fila(int capacidade){
        inicio = 0;
        fim = 0;
        tamanho = 0;
        this.capacidade = capacidade;
        itens = new int[capacidade];
    }
    
    public boolean cheia() {
        return tamanho == capacidade;
    }
    
    public boolean vazia() {
        return tamanho == 0;
    }
    
    public void enfileirar(int n) {
        if ( cheia() ) {
            System.out.println("Fila cheia!");
        } else {
            itens[fim] = n;
            fim = (fim+1) % capacidade;
            tamanho++;
        }
    }
    
    public int desenfileirar() {
        int removido = -1;
        if ( vazia() ) {
            System.out.println("Fila vazia!");
        } else {
            removido = itens[inicio];
            inicio = (inicio+1) % capacidade;
            tamanho--;
        }
        return removido;
    }
    public void imprimir() {
        System.out.print("Fila -> ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(itens[(inicio+i) % capacidade]+" ");
        }
        System.out.println();
    }
    
    public void imprimir2() {
        for (int i = 0; i < capacidade; i++) {
            System.out.print(itens[i]+" ");
        }
        System.out.println();
    }
}