package gerenciadorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gerenciador.Tarefa;

class TarefaTests {
	
	Tarefa tarefaPadrao;

	@BeforeEach
	void setUp() throws Exception {
		this.tarefaPadrao = new Tarefa("Teste", "dd/mm/aaaa", "Tarefa de teste.");
	}

	@Test
	void testTarefa() {
		Tarefa tarefaTeste = new Tarefa("Teste2", "dd/mm/aaaa", "Tarefa de teste 2.");
		assertEquals("Teste2", tarefaTeste.getNome());
		assertEquals("dd/mm/aaaa", tarefaTeste.getPrazo());
		assertEquals("Tarefa de teste 2.", tarefaTeste.getDetalhes());
	}

	@Test
	void testGetDescricao() {
		assertEquals("Teste: Tarefa de teste. (dd/mm/aaaa)", tarefaPadrao.getDescricao());
	}
	
	@Test
	void testGetDescricaoDetalhesVazio() {
		Tarefa tarefaTeste = new Tarefa("Teste", "dd/mm/aaaa", "");
		assertEquals("Teste (dd/mm/aaaa)", tarefaTeste.getDescricao());
	}

	@Test
	void testToString() {
		assertEquals("Teste (dd/mm/aaaa)", tarefaPadrao.toString());
	}

}
