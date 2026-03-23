public class Pilha {
    int topo;
    int capacidade;
    int[] itens;
    
    Pilha(int capacidade) {
        topo = -1;
        this.capacidade = capacidade;
        itens = new int[capacidade];
    }
    
    public boolean vazia() {
        return topo == -1;
    }
    
    public boolean cheia() {
        return topo == (capacidade-1);
    }
    
    public void empilhar(int n) {
        if ( cheia() ) {
            System.out.println("Pilha cheia!");
        } else {
            topo++;
            itens[topo] = n;
        }
    }
    
    public int desempilhar() {
        int removido = -1;
        if ( vazia() ) {
            System.out.println("Pilha vazia!");
        } else {
            removido = itens[topo];
            topo--;
        }
        return removido;
    }
    
    public void imprimir() {
        System.out.println("Topo");
        for (int i = topo; i >= 0; i--) {
            System.out.println("  "+itens[i]);
        }
        System.out.println("Base");
    }
    
}