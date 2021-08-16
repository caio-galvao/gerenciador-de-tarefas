package gerenciador;

import java.util.Scanner;

/**
 * Menus para o gerenciador de tarefas.
 * @author Caio Ribeiro Galvão
 */
public class Main {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		Scanner sc = new Scanner(System.in);
		System.out.println("Bem-vindo!");
		
		while (true) {
			String comando = menu(sc);
			decideComando(sistema, sc, comando);
		}
	}

	private static String menu(Scanner sc) {
		String textoMenu = "\nGerenciador de Tarefas" + "\n" +
						"(C)adastrar tarefa" + "\n" +
						"(L)istar tarefas" + "\n" +
						"(V)er Tarefa" + "\n" +
						"(E)ditar Tarefa" + "\n" +
						"(S)air" + "\n";
		System.out.print(textoMenu);
		String comando = sc.nextLine();
		return comando.toUpperCase();
	}
	
	private static void decideComando(Sistema sistema, Scanner sc, String comando) {
		switch (comando) {
			case "C":
				cadastraTarefa(sistema, sc);
				break;
			case "L":
				listaTarefas(sistema);
				break;
			case "V":
				verTarefa(sistema, sc);
				break;
			case "E":
				editarTarefa(sistema, sc);
				break;
			case "S":
				sair();
				break;
			default:
				System.out.println("Comando não existe, tente novamente.");
		}
		
	}

	private static void cadastraTarefa(Sistema sistema, Scanner sc) {
		System.out.println("\nCadastra Tarefa");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Prazo (data - dd/mm/aaaa): ");
		String prazo = sc.nextLine();
		System.out.print("Detalhes adicionais: ");
		String detalhes = sc.nextLine();
		boolean status = sistema.novaTarefa(nome, prazo, detalhes);
		
		 if (status == false) {
			 System.out.println("Erro, tente novamente.");
		 } else {
			 System.out.println("Tarefa cadastrada com sucesso");
		 }
	}
	
	private static void listaTarefas(Sistema sistema) {
		System.out.print("\nTarefas:");
		String listagem = sistema.listaTarefas();
		
		if (listagem.equals("")) {
			System.out.println("Não existem tarefas cadastradas.");
		} else {
			System.out.println(listagem);
		}
	}
	
	private static void verTarefa(Sistema sistema, Scanner sc) {
		System.out.print("\nNome: ");
		String nome = sc.nextLine();
		String descricaoTarefa = sistema.verTarefa(nome);
		
		if (descricaoTarefa == null) {
			System.out.println("Tarefa não cadastrada.");
		} else {
			System.out.println(descricaoTarefa);
		}
	}
	
	private static void editarTarefa(Sistema sistema, Scanner sc) {
		System.out.print("\nNome: ");
		String nome = sc.nextLine();
		
		if (sistema.existeTarefa(nome) == false) {
			System.out.println("Tarefa não cadastrada.");
		} else {
			System.out.println("Editar (P)razo" + "\n" +
								"Editar (D)etalhes");
			String comando1 = sc.nextLine().toUpperCase();
			if (comando1.equals("P")) {
				mudaPrazo(nome, sistema, sc);
			} else if (comando1.equals("D")) {
				mudaDetalhes(nome, sistema, sc);
			} else {
				System.out.println("Comando não existe.");
			}
		}
	}
	
	private static void mudaPrazo(String nome, Sistema sistema, Scanner sc) {
		System.out.print("Novo prazo (dd/mm/aaaa): ");
		String novoPrazo = sc.next();
		boolean status = sistema.mudaPrazo(nome, novoPrazo);
		
		if (status == false) {
			System.out.println("Erro, tente novamente.");
		} else {
			System.out.println("Alteração feita com sucesso.");
		}
	}

	private static void mudaDetalhes(String nome, Sistema sistema, Scanner sc) {
		System.out.print("Novos detalhes: ");
		String novosDetalhes = sc.next();
		boolean status = sistema.mudaDetalhes(nome, novosDetalhes);
		
		if (status == false) {
			System.out.println("Erro, tente novamente.");
		} else {
			System.out.println("Alteração feita com sucesso.");
		}
	}

	private static void sair() {
		System.out.println("\nSaindo...");
		System.exit(0);
	}

}
