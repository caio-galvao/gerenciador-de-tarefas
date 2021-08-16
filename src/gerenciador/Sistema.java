package gerenciador;

import java.util.HashMap;
import java.util.Map;

/**
 * Sistema do gerenciador de tarefas, guarda o conunto de tarefas cadastradas e tem
 * operações de criação, acesso e alteração das tarefas.
 * @author Caio Ribeiro Galvão
 */
public class Sistema {
	
	/**
	 * Guarda as tarefas. A chave é o nome da tarefa em String.
	 */
	private Map<String, Tarefa> tarefas; 
	
	/**
	 * Cria um novo sistema.
	 */
	public Sistema() {
		this.tarefas = new HashMap<>();
	}
	
	/**
	 * Cria uma nova tarefa no sistema, a partir do nome, prazo e detalhes adicionais.
	 * Checa se os dados são válidos.
	 * @param nome Nome da tarefa, o seu identificador únido.
	 * @param prazo Data do prazo da tarefa (dd/mm/aaaa).
	 * @param detalhes Detalhes adicionais da tarefa, podendo ser vazio.
	 * @return true para tarefa criada com sucesso e false para tarefa não criada.
	 */
	public boolean novaTarefa(String nome, String prazo, String detalhes) {
		if (existeTarefa(nome) == true || checaData(prazo) == false) {
			return false;
		}
		if (nome.equals("")) {
			return false;
		}
		Tarefa tarefa = new Tarefa(nome, prazo, detalhes);
		this.tarefas.put(nome, tarefa);
		return true;
	}
	
	/**
	 * Lista todas as tarefas cadastradas, com o toString de cada uma.
	 * @return String com a lista das tarefas.
	 */
	public String listaTarefas() {
		String listagem = "";
		for (Tarefa tarefa : this.tarefas.values()) {
			listagem += "\n" + tarefa;
		}
		return listagem;
	}
	
	/**
	 * Mostra todos os dados da tarefa, ou seja, uma tarefa completa.
	 * @param nome Nome da tarefa.
	 * @return Descrição completa da tarefa ou null para tarefa não existente.
	 */
	public String verTarefa(String nome) {
		if (existeTarefa(nome) == false) {
			return null;
		}
		return this.tarefas.get(nome).getDescricao();
	}
	
	/**
	 * Altera o prazo de uma tarefa.
	 * @param nome Nome da tarefa.
	 * @param novoPrazo Novo prazo da tarefa (data).
	 * @return true para alteração feita e false para alteração não feita.
	 */
	public boolean mudaPrazo(String nome, String novoPrazo) {
		if (existeTarefa(nome) == false) {
			return false;
		}
		if (checaData(novoPrazo) == false) {
			return false;
		}
		Tarefa tarefa = this.tarefas.get(nome);
		tarefa.setPrazo(novoPrazo);
		return true;
	}
	
	/**
	 * Altera os detalhes de uma tarefa.
	 * @param nome Nome da tarefa
	 * @param novosDetalhes Novos detalhes da tarefa.
	 * @return true para alteração feita e false para alteração não feita.
	 */
	public boolean mudaDetalhes(String nome, String novosDetalhes) {
		if (existeTarefa(nome) == false) {
			return false;
		}
		Tarefa tarefa = this.tarefas.get(nome);
		tarefa.setDetalhes(novosDetalhes);
		return true;
	}
	
	/**
	 * Checa se uma tarefa está cadastrada no sistema a partir do nome.
	 * @param nome Nome da tarefa.
	 * @return true para cadastrada e false para não cadastrada.
	 */
	public boolean existeTarefa(String nome) {
		return this.tarefas.containsKey(nome);
	}
	
	/**
	 * Checa se o formato da data está correto.
	 * @param data Data recebida.
	 * @return true para correto e false para errado.
	 */
	private boolean checaData(String data) {
		if (data.length() != 10) {
			return false;
		}
		return true;
		// incompleto
	}
}
