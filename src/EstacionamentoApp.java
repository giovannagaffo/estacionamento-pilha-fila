public class EstacionamentoApp {

    static void chegadaCarro(Pilha estacionamento, Fila espera, int placa) {
        if (!estacionamento.cheia()) {
            estacionamento.empilhar(placa);
            System.out.println("Carro " + placa + " estacionado!");
        } else if (!espera.cheia()) {
            espera.enfileirar(placa);
            System.out.println("Estacionamento cheio! Carro " + placa + " entrou na fila.");
        } else {
            System.out.println("Capacidade total esgotada (Estacionamento + Fila)!");
        }
    }

    static void saidaCarro(Pilha estacionamento, Fila espera) {
        if (!estacionamento.vazia()) {
            int placaSaiu = estacionamento.desempilhar();
            System.out.println("Carro saiu do topo: " + placaSaiu);
            
            // Regra: Se saiu vaga e tem gente na fila, o primeiro da fila entra
            if (!espera.vazia()) {
                int placaEntrou = espera.desenfileirar();
                estacionamento.empilhar(placaEntrou);
                System.out.println("Carro da fila entrou: " + placaEntrou);
            }
        } else {
            System.out.println("Estacionamento vazio!");
        }
    }

    static void saidaCarro(Pilha estacionamento, Fila espera, int placaSaida) {
        Pilha aux = new Pilha(estacionamento.capacidade);
        boolean achouNoEstacionamento = false;

        // 1. Procurar no Estacionamento (Pilha)
        while (!estacionamento.vazia()) {
            int p = estacionamento.desempilhar();
            if (p == placaSaida) {
                achouNoEstacionamento = true;
                break; // Carro encontrado e removido
            }
            aux.empilhar(p);
        }

        // Devolver carros para o estacionamento na ordem correta
        while (!aux.vazia()) {
            estacionamento.empilhar(aux.desempilhar());
        }

        if (achouNoEstacionamento) {
            System.out.println("Carro " + placaSaida + " saiu do estacionamento.");
            // Se liberou vaga, puxa da fila
            if (!espera.vazia()) {
                int placaFila = espera.desenfileirar();
                estacionamento.empilhar(placaFila);
                System.out.println("Carro " + placaFila + " da fila ocupou a vaga aberta.");
            }
            return; // Finaliza o método
        }

        // 2. Se não achou no estacionamento, procurar na Fila
        Fila filaAux = new Fila(espera.capacidade);
        boolean achouNaFila = false;
        int tamanhoOriginal = espera.tamanho;

        for (int i = 0; i < tamanhoOriginal; i++) {
            int p = espera.desenfileirar();
            if (p == placaSaida) {
                achouNaFila = true; // Simplesmente não re-enfileira
            } else {
                filaAux.enfileirar(p);
            }
        }

        // Devolver para a fila original
        while (!filaAux.vazia()) {
            espera.enfileirar(filaAux.desenfileirar());
        }

        if (achouNaFila) {
            System.out.println("Carro " + placaSaida + " saiu da fila de espera.");
        } else {
            System.out.println("Erro: Carro " + placaSaida + " nao encontrado no sistema.");
        }
    }
}