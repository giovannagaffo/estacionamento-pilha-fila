# estacionamento-pilha-fila
Sistema de gerenciamento de estacionamento desenvolvido em Java, utilizando estruturas de dados Pilha (LIFO) para o corredor interno e Fila (FIFO) para a área de espera externa. O sistema gerencia um estacionamento com vagas limitadas e uma fila de espera para veículos que chegam quando o local está lotado. 


-Pilha (Stack): Representa o estacionamento físico. Como em uma garagem de corredor estreito, o último carro a entrar é o primeiro a sair (LIFO - Last-In, First-Out).

-Fila (Queue): Representa a fila de espera na rua. Segue a lógica de que o primeiro carro a chegar na fila é o primeiro a ocupar uma vaga liberada (FIFO - First-In, First-Out).

Funcionalidades
[x]Entrada de Carros: Estaciona o veículo se houver vaga ou o encaminha para a fila de espera.
[x]Saída do Topo: Remove o último carro que estacionou.
[x]Saída por Placa: Remove um carro específico (seja na pilha ou na fila). Se o carro estiver no meio da pilha, os carros à frente são removidos temporariamente e recolocados após a saída do alvo.
[x] Gestão Automática: Assim que uma vaga é liberada na pilha, o primeiro carro da fila de espera ocupa o lugar automaticamente.
[x] Visualização: Listagem em tempo real do estado atual do estacionamento e da fila.