package gerenciador;

/**
 * Representação de uma tarefa. Cada tarefa é identificada unicamente pelo nome.
 * @author Caio Ribeiro Galvão
 */
public class Tarefa {
	
	/**
	 * Nome da tarefa, sendo o identificador único.
	 */
	private String nome;
	
	/**
	 * Prazo da tarefa, no formato dd/mm/aaaa.
	 */
	private String prazo;
	
	/**
	 * Detalhes adicionais da tarefa, pode ser vazio.
	 */
	private String detalhes;
	
	/**
	 * Cria uma nova tarefa.
	 * @param nome
	 * @param prazo Data limite (dd/mm/aaaa).
	 * @param detalhes Outras informações em String, pode ser vazio.
	 */
	public Tarefa(String nome, String prazo, String detalhes) {
		this.nome = nome;
		this.prazo = prazo;
		this.detalhes = detalhes;
	}

	/**
	 * @return Descrição completa da tarefa (nome + detalhes + prazo).
	 */
	public String getDescricao() {
		if (detalhes.equals("")) {
			return toString();
		} else {
			return nome + ": " + detalhes + " (" + prazo + ")";
		}
	}
	
	/**
	 * @return Nome da tarefa.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * @return Prazo da tarefa
	 */
	public String getPrazo() {
		return this.prazo;
	}
	
	/**
	 * @return Detalhes da tarefa.
	 */
	public String getDetalhes() {
		return this.detalhes;
	}
	
	/**
	 * Altera o prazo.
	 * @param novoPrazo
	 */
	public void setPrazo(String novoPrazo) {
		this.prazo = novoPrazo;
	}
	
	/**
	 * Altera os detalhes.
	 * @param novosDetalhes
	 */
	public void setDetalhes(String novosDetalhes) {	
		this.detalhes = novosDetalhes;
	}
	
	@Override
	public String toString() {
		return nome + " (" + prazo + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
