import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {

		Pilha estacionamento = new Pilha(3);
		Fila espera = new Fila(5);

		int op;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n=== ESTACIONAMENTO (PILHA + FILA) ===");
			System.out.println("1 - Chegada de carro");
			System.out.println("2 - Saida de carro");
			System.out.println("3 - Saida de carro Placa");
			System.out.println("4 - Listar estacionamento (pilha)");
			System.out.println("5 - Listar fila de espera");
			System.out.println("0 - Sair");
			System.out.print("Opcao: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
			case 1:
				System.out.print("Placa (int): ");
				int placa = Integer.parseInt(sc.nextLine());
				EstacionamentoApp.chegadaCarro(estacionamento, espera, placa);
				break;

			case 2:
				EstacionamentoApp.saidaCarro(estacionamento, espera);
				break;

			case 3:
				System.out.print("Placa (int): ");
				int placaSaida = Integer.parseInt(sc.nextLine());		    
				EstacionamentoApp.saidaCarro(estacionamento, espera, placaSaida);
				break;

			case 4:
				estacionamento.imprimir();
				break;

			case 5:
				espera.imprimir();
				break;

			case 0:
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Opcao invalida!");
			}
		} while (op != 0);

		sc.close();
	}

}

